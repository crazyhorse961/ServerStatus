package net.horse.serverstatus;

import com.google.gson.Gson;
import discord4j.core.DiscordClient;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import kong.unirest.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class ServerStatus {

    private static final Map<String, Command> commands = new HashMap<>();

    private static DiscordClient client;

    private static Gson gson;


    static {
        commands.put("load", event -> Mono.justOrEmpty(event.getMessage().getContent())
                .map(content -> Arrays.asList(content.split(" ")))
                .doOnNext(command -> checkStatus(command.get(1), event))
                .then());

    }

    public static void main(String[] args) {
        client = new DiscordClientBuilder(args[0]).build();
        client.getEventDispatcher().on(MessageCreateEvent.class)
                .flatMap(event -> Mono.justOrEmpty(event.getMessage().getContent())
                        .flatMap(content -> Flux.fromIterable(commands.entrySet())
                                .filter(entry -> content.startsWith('.' + entry.getKey()))
                                .flatMap(entry -> entry.getValue().execute(event))
                                .next())).subscribe();
        client.login().block();
    }

    //Calls method for checking status and sends message to
    private static void checkStatus(String address, MessageCreateEvent event) {
        Mono<Message> message = event.getMessage().getChannel().block().createMessage(messageSpec -> {
            try {
                Response response = gson.fromJson(Unirest.post("https:/api.mcsrvstat.us/2/" + address).header("accept", "application/json").asJsonAsync(new Callback<JsonNode>() {
                    @Override
                    public void completed(HttpResponse<JsonNode> httpResponse) {

                    }

                    @Override
                    public void failed(UnirestException e) {
                        event.getMessage().getChannel().block().createMessage("An error occurred contacting Minecraft's API.");
                    }

                    @Override
                    public void cancelled() {
                        event.getMessage().getChannel().block().createMessage("The GET request was cancelled.");

                    }
                }).get().getBody().getObject().toString(), Response.class);
                messageSpec.setContent("Here you can find " + address + " server data.");
                String url = post(response.toString());
                if (response.isOnline()) {
                    messageSpec.setEmbed(embed -> embed.setTitle(address + " - Status: ONLINE")
                            .setDescription("SERVER IS ONLINE - "));
                } else {
                    messageSpec.setEmbed(embed -> embed.setTitle(address + " - Status: OFFLINE")
                            .setDescription("SERVER IS OFFLINE")
                            .setUrl(url)
                            .setColor(Color.GRAY)
                            .setFooter("SERVER IS OFFLINE", "https://colourlex.com/wp-content/uploads/2017/03/Chrome-red-painted-swatch-203-225-opt.jpg")
                            .setImage("https://miro.medium.com/max/534/1*wUOrpv-selJOytCkslSIhg.png")
                            .setThumbnail("https://miro.medium.com/max/534/1*wUOrpv-selJOytCkslSIhg.png")
                            .setAuthor("crazyhoorse961", "github.com/crazyhorse961", "http://www.flagblvd.com/wp-content/uploads/2015/09/swiss-flag-medium.png")
                            .addField("Hastebin Output", "Response: " + url, true));
                }
            } catch (InterruptedException | ExecutionException | UnirestException ex) {
                System.err.println("AN ERROR OCCURRED WHILE OBTAINING RESPONSE'S BODY");
                ex.printStackTrace();
            }
        });
    }

    private static String post(String data) {
        try {
            return "https://hastebin.com/" + Unirest.post("https://hastebin.com/documents").body("").asJsonAsync(new Callback<JsonNode>() {
                @Override
                public void completed(HttpResponse<JsonNode> httpResponse) {
                }
            }).get().getBody().getObject().getString("key");
        } catch (InterruptedException | ExecutionException | UnirestException ex) {
            ex.printStackTrace();
        }
        return "Couldn't upload on Hastebin";
    }

    //Interface for commands
    public interface Command {
        Mono<Void> execute(MessageCreateEvent event);
    }
}
