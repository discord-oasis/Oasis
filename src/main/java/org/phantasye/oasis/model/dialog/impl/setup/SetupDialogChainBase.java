package org.phantasye.oasis.model.dialog.impl.setup;

import org.phantasye.oasis.entity.user.command.CommandContext;
import org.phantasye.oasis.model.dialog.AbstractDialogChainBase;
import org.phantasye.oasis.model.dialog.DialogChain;

public class SetupDialogChainBase extends AbstractDialogChainBase {
    @Override
    public DialogChain replyTo(CommandContext response) {
        return null;
    }
}
