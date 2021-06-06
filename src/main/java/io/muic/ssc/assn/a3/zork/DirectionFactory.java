package io.muic.ssc.assn.a3.zork;

import java.util.HashMap;
import java.util.Map;

public class DirectionFactory {
    private static final Map<String, Direction> DIRECTION_MAP = new HashMap<>();

    static {{
        for (Direction direction : Direction.values()) {
            DIRECTION_MAP.put(direction.getInputDir(), direction);
        }
    }}

    public static Direction getDirection(String item) {
        return DIRECTION_MAP.getOrDefault(item, null);
    }
}
