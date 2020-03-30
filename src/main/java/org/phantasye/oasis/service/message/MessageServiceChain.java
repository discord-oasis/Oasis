package org.phantasye.oasis.service.message;

import discord4j.core.object.entity.Message;

public interface MessageServiceChain {

    void setNextChain(MessageServiceChain chain);

    void handle(Message message);
}
