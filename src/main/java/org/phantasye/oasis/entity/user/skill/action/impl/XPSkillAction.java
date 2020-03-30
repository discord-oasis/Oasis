package org.phantasye.oasis.entity.user.skill.action.impl;

import org.phantasye.oasis.entity.user.User;
import org.phantasye.oasis.entity.user.skill.action.SkillAction;

public abstract class XPSkillAction implements SkillAction {

    private final User actor;
    private final int xp;

    protected XPSkillAction(User user,int xp) {
        this.actor = user;
        this.xp = xp;
    }

    public User getActor() {
        return actor;
    }

    public int getXp() {
        return xp;
    }
}
