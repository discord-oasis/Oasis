package org.phantasye.oasis.io.data.manager;

import org.phantasye.RepositoryManager;
import org.phantasye.oasis.io.data.repo.GuildContextRepository;
import org.phantasye.oasis.model.guild.GuildContext;

public class GuildContextRepositoryManager extends RepositoryManager<GuildContext, GuildContextRepository> {

    public GuildContextRepositoryManager() {
        super("./assets/data/repositories/guild-context-repository.json", GuildContextRepository.class);
    }
}
