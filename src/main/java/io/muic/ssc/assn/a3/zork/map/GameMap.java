package io.muic.ssc.assn.a3.zork.map;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class GameMap {
    protected Set<Room> rooms;
    protected String mapName;
    protected File map;
    protected Room spawnRoom;

    protected void addMap(File file) {
        map = file;
    }

    public GameMap() {
        rooms = new HashSet<>();
    }

    protected void addMapName(String mapName) {
        this.mapName = mapName;
    }

    protected void addRooms(Room[] roomsToAdd) {
        rooms.addAll(Arrays.asList(roomsToAdd));
    }

    protected void setSpawnRoom(Room room) {
        spawnRoom = room;
    }
}
