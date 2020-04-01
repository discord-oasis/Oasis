package org.phantasye.oasis.service.message.impl;

import discord4j.core.object.entity.Message;
import org.phantasye.oasis.Oasis;
import org.phantasye.oasis.OasisCommons;
import org.phantasye.oasis.entity.user.command.CommandContext;
import org.phantasye.oasis.model.chat.ChatSessionFactory;
import org.phantasye.oasis.service.message.MessageServiceChain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class ParseMessageServiceChain implements MessageServiceChain {


    @Override
    public void setNextChain(MessageServiceChain chain) {

    }

    @Override
    public void handle(Message message) {
            final String msg = message.getContent().orElse(null);

            try {
                if (msg != null) {
                    final Queue<String> parsedWords = new LinkedList<>();
                    final List<String> uniqueWords = new ArrayList<>();

                    for (String word : msg.split(" ")) {

                        if (Oasis.getInstance().getLanguageTool().check(word).size() > 0) {
                            parsedWords.add(word);
                        } else if (!parsedWords.isEmpty() && !parsedWords.peek().equalsIgnoreCase(word)) {
                            parsedWords.add(word);
                            uniqueWords.add(word);
                        } else if (parsedWords.isEmpty()) {
                            parsedWords.add(word);
                            uniqueWords.add(word);
                        } else {
                            parsedWords.add(word);
                        }
                    }
                    if (!uniqueWords.isEmpty()) {
                        final List<String> validWord = uniqueWords.stream().filter(word -> word.length() > 3).collect(Collectors.toList());
                        int xp = validWord.size() * 3;
                        Oasis.GLOBAL_LOGGER.info("Earned XP: " + xp);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
