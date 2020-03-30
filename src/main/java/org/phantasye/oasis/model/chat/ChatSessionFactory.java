package org.phantasye.oasis.model.chat;

import org.alicebot.ab.Chat;
import org.phantasye.oasis.Oasis;

import java.util.HashMap;
import java.util.Map;

public final class ChatSessionFactory {

    private final static Map<Long,Chat> chatMap = new HashMap<>();

    public static Chat getChatForGuild(long guildId) {
        Chat chat = chatMap.get(guildId);

        if(chat == null) {
            chat = new Chat(Oasis.getInstance().getBot(),String.valueOf(guildId));
            chatMap.put(guildId,chat);
        }
        return chat;
    }
}
