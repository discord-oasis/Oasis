package org.phantasye.oasis;

import discord4j.core.DiscordClient;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import org.alicebot.ab.AIMLProcessor;
import org.alicebot.ab.Bot;
import org.languagetool.JLanguageTool;
import org.languagetool.language.BritishEnglish;
import org.phantasye.RepositoryManager;
import org.phantasye.oasis.discord.event.DiscordEventDispatcher;
import org.phantasye.oasis.entity.user.command.CommandDispatcher;
import org.phantasye.oasis.entity.user.command.CommandContext;
import org.phantasye.oasis.io.data.factory.AbstractValueFactory;
import org.phantasye.oasis.io.data.manager.GuildContextRepositoryManager;
import org.phantasye.oasis.model.dialog.response.TestAIMLExtenstion;

import java.io.File;
import java.util.logging.Logger;

public class Oasis implements OasisCommons {

    private static Logger logger = Logger.getLogger(Oasis.class.getName());

    private static Oasis instance = null;

    private final DiscordClient client;
    private final CommandDispatcher commandDispatcher;
    private final DiscordEventDispatcher discordEventDispatcher;
    private final JLanguageTool languageTool;
    private final Bot bot = new Bot("oasis", getResourcesPath());
    private final GuildContextRepositoryManager guildContextRepositoryManager;
//    private final Chat chatSession = new Chat(bot);

    public static void main(String[] args) {
        Oasis oasis = new Oasis();

        oasis.login();
    }

    public static Oasis getInstance() {
        if (instance == null)
            instance = new Oasis();
        return instance;
    }

    private Oasis() {
        this.client = buildClient(TOKEN);
        this.commandDispatcher = new CommandDispatcher();
        this.discordEventDispatcher = new DiscordEventDispatcher();
        this.languageTool = new JLanguageTool(new BritishEnglish());
        bot.brain.nodeStats();
        bot.writeAIMLFiles();
        AIMLProcessor.extension =  new TestAIMLExtenstion();
        this.guildContextRepositoryManager = new GuildContextRepositoryManager();
        this.registerEventListener();


    }

    private void registerEventListener() {
        client.getEventDispatcher().on(ReadyEvent.class)
                .subscribe(ready -> logger.info("Logged in as " + ready.getSelf().getUsername()));
        client.getEventDispatcher().on(MessageCreateEvent.class)
                .filter(messageCreateEvent -> messageCreateEvent.getMember().map(user -> !user.isBot()).orElse(false))
                .filter(messageCreateEvent -> messageCreateEvent.getMessage().getContent().isPresent())
                .filter(messageCreateEvent -> messageCreateEvent.getMessage().getContent().get().startsWith(COMMAND_PREFIX))
                .subscribe(messageCreateEvent -> commandDispatcher.dispatch(
                        new CommandContext(
                                messageCreateEvent.getGuild(),
                                messageCreateEvent.getMember().get(),
                                messageCreateEvent.getMessage().getChannel(),
                                messageCreateEvent.getMessage(),
                                messageCreateEvent.getMessage().getContent().get().split(" ")
                        ),
                        messageCreateEvent
                ));
        client.getEventDispatcher().on(MessageCreateEvent.class)
                .filter(messageCreateEvent -> messageCreateEvent.getMember().map(user -> !user.isBot()).orElse(false))
                .filter(messageCreateEvent -> messageCreateEvent.getMessage().getContent().isPresent())
                .subscribe(discordEventDispatcher::dispatch);
    }

    private static String getResourcesPath() {
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        path = path.substring(0, path.length() - 2);
        String resourcesPath = path + File.separator + "src" + File.separator + "main" + File.separator + "resources";
        return resourcesPath;
    }

    private void login() {
        client.getEventDispatcher().on(ReadyEvent.class)
                .subscribe(ready -> System.out.println("Logged in as " + ready.getSelf().getUsername()));

        client.login().block();
    }

    private DiscordClient buildClient(String token) {
        logger.info("Building client with token: " + token);
        return new DiscordClientBuilder(TOKEN).build();
    }

    public void saveRepository(RepositoryManager<?,?> repositoryManager) {
        repositoryManager.updateRepository();
    }

    public DiscordEventDispatcher getDiscordEventDispatcher() {
        return discordEventDispatcher;
    }

    public CommandDispatcher getCommandDispatcher() {
        return commandDispatcher;
    }

    public JLanguageTool getLanguageTool() {
        return languageTool;
    }

    public Bot getBot() {
        return bot;
    }

    public <K,V> AbstractValueFactory<K,V> getValueFactory(AbstractValueFactory<K,V> valueFactory) {
        return valueFactory;
    }

    public GuildContextRepositoryManager getGuildContextRepositoryManager() {
        return guildContextRepositoryManager;
    }
}
