package org.phantasye.oasis.model.dialog;

import org.phantasye.oasis.entity.user.command.CommandContext;

public interface DialogChain {

    DialogChain replyTo(CommandContext response);
}
