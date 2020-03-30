package org.phantasye.oasis.entity.user.command.impl;

import discord4j.core.event.domain.message.MessageCreateEvent;
import org.phantasye.oasis.Oasis;
import org.phantasye.oasis.entity.user.command.CommandContext;
import org.phantasye.oasis.entity.user.command.CommandListener;
import org.phantasye.oasis.io.data.factory.GuildContextFactory;

public class TestCommandListener implements CommandListener<MessageCreateEvent> {

    @Override
    public void execute(MessageCreateEvent event, CommandContext ctx) {
//        final StringBuilder sb = new StringBuilder();
//        ctx.getArgs().stream().forEach(arg-> sb.append(arg).append(" "));
//        event.getMessage().getChannel().block().createMessage(sb.toString()).block();
        Oasis.getInstance().getValueFactory(new GuildContextFactory()).getValue(1L).ifPresent(guildContext -> System.out.println(guildContext.getGuildId()));
    }

    @Override
    public void log(MessageCreateEvent event, CommandContext ctx) {
        System.out.println("LOGGED");
    }
}
