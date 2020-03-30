package org.phantasye.oasis.discord.event.message;

import discord4j.core.event.domain.message.MessageCreateEvent;
import org.phantasye.oasis.discord.event.DiscordEventListener;
import org.phantasye.oasis.service.message.MessageServiceChain;
import org.phantasye.oasis.service.message.impl.DefaultMessageChain;

public class MessageCreateEventListener implements DiscordEventListener<MessageCreateEvent> {

    @Override
    public void execute(MessageCreateEvent event) {
        final MessageServiceChain defaultMessageServiceChain = new DefaultMessageChain();
        defaultMessageServiceChain.handle(event.getMessage());

    }

    @Override
    public void log(MessageCreateEvent event) {
        logger.info("Message Created with content: " + event.getMessage().getContent().get());
    }
}
