package org.phantasye.oasis.model.dialog;

public abstract class AbstractDialogChainBase implements DialogChain {

    private DialogChain dialogChain;

    protected AbstractDialogChainBase() {

    }

    public DialogChain getDialogChain() {
        return dialogChain;
    }

    public void setDialogChain(DialogChain dialogChain) {
        this.dialogChain = dialogChain;
    }
}
