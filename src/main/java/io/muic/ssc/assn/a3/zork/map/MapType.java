package io.muic.ssc.assn.a3.zork.map;

import io.muic.ssc.assn.a3.zork.map.impl.OneMap;
import io.muic.ssc.assn.a3.zork.map.impl.TwoMap;

public enum MapType {
    ONE("one", OneMap.class),
    TWO("two", TwoMap.class);

    String mapName;
    Class<? extends GameMap> mapClass;

    MapType(String mapName, Class<? extends GameMap> mapClass) {
        this.mapName = mapName;
        this.mapClass = mapClass;
    }

    public String getMapName() {
        return mapName;
    }

    public Class<? extends GameMap> getMapClass() {
        return mapClass;
    }
}
