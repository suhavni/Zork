package io.muic.ssc.assn.a3.zork.map;

import io.muic.ssc.assn.a3.zork.Game;
import io.muic.ssc.assn.a3.zork.map.impl.OneMap;

import java.lang.reflect.InvocationTargetException;

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

    public GameMap getInstance() {
        try {
            return mapClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public GameMap getInstance(MapType mapType, GameMap map, String room) {
        try {
            return mapClass.getConstructor(mapType.getMapClass(), String.class).newInstance(map, room);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Class<? extends GameMap> getMapClass() {
        return mapClass;
    }
}
