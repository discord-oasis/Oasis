package org.phantasye.oasis.discord.event;

import discord4j.core.event.domain.Event;

import java.util.logging.Logger;

public interface DiscordEventListener<E extends Event> {

    Logger logger = Logger.getLogger(DiscordEventListener.class.getName());

    void execute(E event);

    void log(E event);

}

