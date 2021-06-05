package io.muic.ssc.assn.a3.zork.map;

import io.muic.ssc.assn.a3.zork.Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public abstract class GameMap {
    protected Set<Room> rooms;
    protected String mapName;
    protected File map;
    protected Room spawnRoom;

    protected void addMap(File file) {
        map = file;
        System.out.println(file.getAbsolutePath());
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

    protected void printMap() throws FileNotFoundException {
        Scanner scanner = new Scanner(map);
        while (scanner.hasNext()) {
            Game.INSTANCE.getOutput().println(scanner.nextLine());
        }
    }

    public Room getSpawnRoom() {
        return spawnRoom;
    }
}