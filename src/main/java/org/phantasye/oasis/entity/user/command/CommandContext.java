package org.phantasye.oasis.entity.user.command;

import discord4j.core.object.entity.*;
import discord4j.core.object.util.Snowflake;
import org.phantasye.oasis.Oasis;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandContext {

    private final List<String> args;
    private final Mono<Guild> guild;
    private final Member author;
    private final Mono<MessageChannel> channel;
    private final Message message;


    public CommandContext(Mono<Guild> guild,Member author,Mono<MessageChannel> channel,Message message, String...args) {
        this.guild = guild;
        this.author = author;
        this.channel = channel;
        this.message = message;
        this.args = Arrays.asList(args);
    }

    public List<String> getArgs() {
        return args;
    }

    public Mono<MessageChannel> getChannel() {
        return channel;
    }

    public Mono<Guild> getGuild() {
        return guild;
    }

    public Member getAuthor() {
        return author;
    }

    public Message getMessage() {
        return message;
    }

    public String getCommand() {
        return args.get(1);
    }

    public String getArgsAsString() {
        final List<String> newArgs = new ArrayList<>(args);
        newArgs.remove(0);
        final String string = Arrays.toString(newArgs.toArray(new String[0]));
        return string.substring(1,string.length() - 1).trim();
    }

    @Override
    public String toString() {
        return Arrays.toString(args.toArray(new String[0]));
    }
}
