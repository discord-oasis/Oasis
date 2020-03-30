package org.phantasye.oasis.model.guild;

public class GuildContext {

    private final long guildId;
    private long welcomeChannelId;

    public GuildContext(long guildId) {
        this.guildId = guildId;
    }

    public long getGuildId() {
        return guildId;
    }

    public long getWelcomeChannelId() {
        return welcomeChannelId;
    }

    public void setWelcomeChannelId(long welcomeChannelId) {
        this.welcomeChannelId = welcomeChannelId;
    }
}
