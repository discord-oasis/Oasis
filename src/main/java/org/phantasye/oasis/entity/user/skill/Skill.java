package org.phantasye.oasis.entity.user.skill;

import org.phantasye.oasis.entity.user.skill.action.impl.XPSkillAction;

public abstract class Skill {

    public static enum Data {
        POSTING
    }

    public abstract void train(XPSkillAction action);
}
