package io.muic.ssc.assn.a3.zork.map;

import io.muic.ssc.assn.a3.zork.Game;
import io.muic.ssc.assn.a3.zork.item.ItemType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public abstract class GameMap {
    private Map<String, Room> rooms;
    protected String mapName;
    private File map;
    private Room spawnRoom;

    protected void addMap(File file) {
        map = file;
    }

    public GameMap() {
        rooms = new HashMap<>();
    }

    protected void addMapName(String mapName) {
        this.mapName = mapName;
    }

    protected void addRooms(Room[] roomsToAdd) {
        for (Room room : roomsToAdd) {
            rooms.put(room.getRoomName(), room);
        }
    }

    protected void setSpawnRoom(Room room) {
        spawnRoom = room;
    }

    public void printMap() {
        try {
            Scanner scanner = new Scanner(map);
            while (scanner.hasNext()) {
                Game.INSTANCE.getOutput().println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            Game.INSTANCE.getOutput().println("Game is unable to print map right now due to undergoing some difficulties.");
            Game.INSTANCE.getOutput().println("Please try again later.");
        }
    }

    public Room getSpawnRoom() {
        return spawnRoom;
    }

    protected Set<String> getRooms() {
        return rooms.keySet();
    }

    protected Room RoomLookup(String roomName) {
        return rooms.get(roomName);
    }

    protected void copyMonstersAndItems(Room copyTo, Room copyFrom) {
        Monster monster = copyFrom.getMonster();
        if (monster != null) {
            copyTo.addMonster(new Monster(monster.getHp(), monster.getAttack()));
        }
        for (ItemType itemType : copyFrom.getItems()) {
            copyTo.addItem(itemType.getItem());
        }
    }
}
