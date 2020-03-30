package org.phantasye.oasis.entity.user;

import org.phantasye.oasis.entity.user.skill.Skill;
import org.phantasye.oasis.util.math.AdjustableNumber;
import org.phantasye.oasis.util.math.AdjustableNumberValue;

public class User {

    private final UserDefinition definition;

    public User(long userId) {
        this(new UserDefinition(userId));
    }

    public User(UserDefinition definition) {
        this.definition = definition;
    }

    public void train(Skill.Data skill, int xp) {
        AdjustableNumber<Integer> skillXp = definition.getSkillMap().get(skill.ordinal());

        if(skillXp == null) {
            definition.getSkillMap().put(skill.ordinal(),new AdjustableNumberValue<>(xp));

            train(skill,xp);
        }

        skillXp.add(xp);
    }
}
