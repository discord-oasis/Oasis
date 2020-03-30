package org.phantasye.oasis.io.data.factory;

import org.phantasye.oasis.Oasis;
import org.phantasye.oasis.model.guild.GuildContext;

public final class GuildContextFactory extends AbstractValueFactory<Long,GuildContext> {

    @Override
    public GuildContext loadValueFor(Long guildId) {
        GuildContext context;
        context = Oasis.getInstance().getGuildContextRepositoryManager().getRepository().readByKey(String.valueOf(guildId));
        if (context == null) {
            context = new GuildContext(guildId);
        }
        return context;
    }
}
