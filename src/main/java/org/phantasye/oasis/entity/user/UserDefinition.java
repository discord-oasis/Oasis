package org.phantasye.oasis.entity.user;

import org.phantasye.oasis.util.math.AdjustableNumberValue;

import java.util.HashMap;
import java.util.Map;

public class UserDefinition {

    private final long userId;

    private final Map<Integer, AdjustableNumberValue<Integer>> skillMap;

    public UserDefinition(long userId) {
        this.userId = userId;
        this.skillMap = new HashMap<>();
    }

    public long getUserId() {
        return userId;
    }

    public Map<Integer, AdjustableNumberValue<Integer>> getSkillMap() {
        return skillMap;
    }
}
