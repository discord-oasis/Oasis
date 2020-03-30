package org.phantasye.oasis.discord.event;

import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.message.MessageCreateEvent;
import org.phantasye.oasis.discord.event.message.MessageCreateEventListener;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class DiscordEventDispatcher {

    private final Map<Class<? extends Event>, DiscordEventListener> discordEventDispatcherMap;
    private final Logger logger = Logger.getLogger(DiscordEventDispatcher.class.getName());

    public DiscordEventDispatcher() {
        this.discordEventDispatcherMap = new HashMap<>();

        discordEventDispatcherMap.put(MessageCreateEvent.class,new MessageCreateEventListener());
    }

    public void dispatch(Event event) {
        if(discordEventDispatcherMap.containsKey(event.getClass())) {
            discordEventDispatcherMap.get(event.getClass()).execute(event);
            discordEventDispatcherMap.get(event.getClass()).log(event);
        } else {
            logger.warning("No Event Listener Found for Event: " + event);
        }
    }

}
