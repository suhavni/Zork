package io.muic.ssc.assn.a3.zork.map;

import java.util.HashSet;
import java.util.Set;

public abstract class GameMap {
    protected Set<Room> rooms;
    protected String mapName;

    public GameMap() {
        rooms = new HashSet<>();
    }

    protected void addMapName(String mapName) {
        this.mapName = mapName;
    }

    protected void addRoom(Room room) {
        rooms.add(room);
    }
}
