package org.phantasye.oasis.io.data.repo;

import org.phantasye.AbstractJsonRepository;
import org.phantasye.oasis.model.guild.GuildContext;

public class GuildContextRepository extends AbstractJsonRepository<GuildContext> {
    @Override
    public void create(GuildContext guildContext) {
        entries.put(String.valueOf(guildContext.getGuildId()),guildContext);
    }

    @Override
    public GuildContext read(GuildContext guildContext) {
        return entries.get(String.valueOf(guildContext.getGuildId()));
    }

    @Override
    public void delete(GuildContext guildContext) {
        entries.remove(String.valueOf(guildContext.getGuildId()));
    }
}
