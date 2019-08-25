package net.horse.serverstatus;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {

    @SerializedName("online")
    @Expose
    private boolean online;
    @SerializedName("ip")
    @Expose
    private String ip;
    @SerializedName("port")
    @Expose
    private long port;
    @SerializedName("debug")
    @Expose
    private Debug debug;
    @SerializedName("motd")
    @Expose
    private Motd motd;
    @SerializedName("players")
    @Expose
    private Players players;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("protocol")
    @Expose
    private long protocol;
    @SerializedName("hostname")
    @Expose
    private String hostname;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("software")
    @Expose
    private String software;
    @SerializedName("map")
    @Expose
    private String map;
    @SerializedName("plugins")
    @Expose
    private Plugins plugins;
    @SerializedName("mods")
    @Expose
    private Mods mods;
    @SerializedName("info")
    @Expose
    private Info info;

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public long getPort() {
        return port;
    }

    public void setPort(long port) {
        this.port = port;
    }

    public Debug getDebug() {
        return debug;
    }

    public void setDebug(Debug debug) {
        this.debug = debug;
    }

    public Motd getMotd() {
        return motd;
    }

    public void setMotd(Motd motd) {
        this.motd = motd;
    }

    public Players getPlayers() {
        return players;
    }

    public void setPlayers(Players players) {
        this.players = players;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public long getProtocol() {
        return protocol;
    }

    public void setProtocol(long protocol) {
        this.protocol = protocol;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSoftware() {
        return software;
    }

    public void setSoftware(String software) {
        this.software = software;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public Plugins getPlugins() {
        return plugins;
    }

    public void setPlugins(Plugins plugins) {
        this.plugins = plugins;
    }

    public Mods getMods() {
        return mods;
    }

    public void setMods(Mods mods) {
        this.mods = mods;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }


    public class Debug {
        @SerializedName("ping")
        @Expose
        private boolean ping;
        @SerializedName("query")
        @Expose
        private boolean query;
        @SerializedName("srv")
        @Expose
        private boolean srv;
        @SerializedName("querymismatch")
        @Expose
        private boolean querymismatch;
        @SerializedName("ipinsrv")
        @Expose
        private boolean ipinsrv;
        @SerializedName("animatedmotd")
        @Expose
        private boolean animatedmotd;
        @SerializedName("proxypipe")
        @Expose
        private boolean proxypipe;
        @SerializedName("cachetime")
        @Expose
        private long cachetime;

        public boolean isPing() {
            return ping;
        }

        public void setPing(boolean ping) {
            this.ping = ping;
        }

        public boolean isQuery() {
            return query;
        }

        public void setQuery(boolean query) {
            this.query = query;
        }

        public boolean isSrv() {
            return srv;
        }

        public void setSrv(boolean srv) {
            this.srv = srv;
        }

        public boolean isQuerymismatch() {
            return querymismatch;
        }

        public void setQuerymismatch(boolean querymismatch) {
            this.querymismatch = querymismatch;
        }

        public boolean isIpinsrv() {
            return ipinsrv;
        }

        public void setIpinsrv(boolean ipinsrv) {
            this.ipinsrv = ipinsrv;
        }

        public boolean isAnimatedmotd() {
            return animatedmotd;
        }

        public void setAnimatedmotd(boolean animatedmotd) {
            this.animatedmotd = animatedmotd;
        }

        public boolean isProxypipe() {
            return proxypipe;
        }

        public void setProxypipe(boolean proxypipe) {
            this.proxypipe = proxypipe;
        }

        public long getCachetime() {
            return cachetime;
        }

        public void setCachetime(long cachetime) {
            this.cachetime = cachetime;
        }

    }

    public class Info {

        @SerializedName("raw")
        @Expose
        private List<String> raw = null;
        @SerializedName("clean")
        @Expose
        private List<String> clean = null;
        @SerializedName("html")
        @Expose
        private List<String> html = null;

        public List<String> getRaw() {
            return raw;
        }

        public void setRaw(List<String> raw) {
            this.raw = raw;
        }

        public List<String> getClean() {
            return clean;
        }

        public void setClean(List<String> clean) {
            this.clean = clean;
        }

        public List<String> getHtml() {
            return html;
        }

        public void setHtml(List<String> html) {
            this.html = html;
        }

    }

    public class Mods {

        @SerializedName("names")
        @Expose
        private List<String> names = null;
        @SerializedName("raw")
        @Expose
        private List<String> raw = null;

        public List<String> getNames() {
            return names;
        }

        public void setNames(List<String> names) {
            this.names = names;
        }

        public List<String> getRaw() {
            return raw;
        }

        public void setRaw(List<String> raw) {
            this.raw = raw;
        }

    }

    public class Motd {
        @SerializedName("raw")
        @Expose
        private List<String> raw = null;
        @SerializedName("clean")
        @Expose
        private List<String> clean = null;
        @SerializedName("html")
        @Expose
        private List<String> html = null;

        public List<String> getRaw() {
            return raw;
        }

        public void setRaw(List<String> raw) {
            this.raw = raw;
        }

        public List<String> getClean() {
            return clean;
        }

        public void setClean(List<String> clean) {
            this.clean = clean;
        }

        public List<String> getHtml() {
            return html;
        }

        public void setHtml(List<String> html) {
            this.html = html;
        }
    }

    public class Players {
        @SerializedName("online")
        @Expose
        private long online;
        @SerializedName("max")
        @Expose
        private long max;
        @SerializedName("list")
        @Expose
        private List<String> list = null;

        public long getOnline() {
            return online;
        }

        public void setOnline(long online) {
            this.online = online;
        }

        public long getMax() {
            return max;
        }

        public void setMax(long max) {
            this.max = max;
        }

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }
    }

    public class Plugins {

        @SerializedName("names")
        @Expose
        private List<String> names = null;
        @SerializedName("raw")
        @Expose
        private List<String> raw = null;

        public List<String> getNames() {
            return names;
        }

        public void setNames(List<String> names) {
            this.names = names;
        }

        public List<String> getRaw() {
            return raw;
        }

        public void setRaw(List<String> raw) {
            this.raw = raw;
        }
    }
}


