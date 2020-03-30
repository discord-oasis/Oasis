package org.phantasye.oasis.entity.user.skill.impl;

import org.phantasye.oasis.entity.user.User;
import org.phantasye.oasis.entity.user.skill.Skill;
import org.phantasye.oasis.entity.user.skill.action.impl.XPSkillAction;

public class PostingSkill extends Skill {

    private final User user;

    public PostingSkill(User user) {
        this.user = user;
    }

    @Override
    public void train(XPSkillAction action) {
        action.getActor().train(Data.POSTING,action.getXp());
    }
}
