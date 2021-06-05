package io.muic.ssc.assn.a3.zork.map;

import java.util.HashMap;
import java.util.Map;

public class MapFactory {
    private static final Map<String, MapType> MAP_LOOKUP = new HashMap<>();

    static {{
        for (MapType map : MapType.values()) {
            MAP_LOOKUP.put(map.getMapName(), map);
        }
    }}

    public static MapType getMap(String item) {
        return MAP_LOOKUP.getOrDefault(item, null);
    }
}
