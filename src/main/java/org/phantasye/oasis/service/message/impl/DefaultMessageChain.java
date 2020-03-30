package org.phantasye.oasis.service.message.impl;

import discord4j.core.object.entity.Message;
import org.phantasye.oasis.service.message.MessageServiceChain;

public class DefaultMessageChain implements MessageServiceChain {


    @Override
    public void setNextChain(MessageServiceChain chain) {

    }

    @Override
    public void handle(Message message) {
        MessageServiceChain parseMessageChain = new ParseMessageServiceChain();

        parseMessageChain.handle(message);
    }
}
