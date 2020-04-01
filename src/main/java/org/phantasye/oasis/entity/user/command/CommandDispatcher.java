package org.phantasye.oasis.entity.user.command;

import discord4j.core.event.domain.Event;
import discord4j.core.object.entity.MessageChannel;
import discord4j.core.object.util.Snowflake;
import org.alicebot.ab.Chat;
import org.phantasye.oasis.Oasis;
import org.phantasye.oasis.entity.user.command.impl.TestCommandListener;
import org.phantasye.oasis.model.chat.ChatSessionFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CommandDispatcher {

    private final Map<String, CommandListener> discordEventListenerMap;

    public CommandDispatcher() {
        this.discordEventListenerMap = new HashMap<>();

        discordEventListenerMap.put("test", new TestCommandListener());
    }

    public boolean dispatch(CommandContext ctx, Event event) {
        Oasis.GLOBAL_LOGGER.info("RECEIVED COMMAND: " + ctx.getCommand());
        if(isCommand(ctx.getCommand())) {
            discordEventListenerMap.get(ctx.getCommand()).execute(event,ctx);
            discordEventListenerMap.get(ctx.getCommand()).log(event,ctx);
            return true;
        } else {
            final Chat chat = ChatSessionFactory.getChatForGuild(ctx.getGuild().block().getId().asLong());
            final String response = chat.multisentenceRespond(ctx.getArgsAsString());
            ctx.getMessage().getChannel().block().createMessage(response).block();
        }
        return false;
    }

    public boolean isCommand(String text) {
        return discordEventListenerMap.containsKey(text) && !text.equalsIgnoreCase(Oasis.COMMAND_PREFIX);
    }

    public Map<String, CommandListener> getDiscordEventListenerMap() {
        return discordEventListenerMap;
    }
}
