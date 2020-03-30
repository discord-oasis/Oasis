package org.phantasye.oasis.service.message;


public final class Message {

    private final String content;
    private final long channelId;
    private final long messageId;
    private final long guildId;
    private final long userId;

    public Message(String content, long channelId, long messageId, long userId) {
        this.content = content;
        this.channelId = channelId;
        this.messageId = messageId;
        this.guildId = 0;
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public long getChannelId() {
        return channelId;
    }

    public long getMessageId() {
        return messageId;
    }

    public long getUserId() { return userId; }

    public long getGuildId() {
        return guildId;
    }

    @Override
    public String toString() {
        return content;
    }
}
