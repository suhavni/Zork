package io.muic.ssc.assn.a3.zork.map;

import io.muic.ssc.assn.a3.zork.map.one.OneMap;

public enum MapType {
    ONE("one", OneMap.class);

    String mapName;
    Class<? extends GameMap> mapClass;

    MapType(String mapName, Class<? extends GameMap> mapClass) {
        this.mapName = mapName;
        this.mapClass = mapClass;
    }

    public String getMapName() {
        return mapName;
    }
}
