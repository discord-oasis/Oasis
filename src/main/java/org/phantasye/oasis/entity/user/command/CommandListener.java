package org.phantasye.oasis.entity.user.command;

import discord4j.core.event.domain.Event;

public interface CommandListener<E extends Event> {

    void execute(E event, CommandContext ctx);

    void log(E event, CommandContext ctx);

}
