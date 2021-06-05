package io.muic.ssc.assn.a3.zork.map;

import io.muic.ssc.assn.a3.zork.Direction;
import io.muic.ssc.assn.a3.zork.Game;
import io.muic.ssc.assn.a3.zork.item.Item;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Room {

    protected Monster monster;
    protected Set<Item> items;
    private String roomName;
    private Map<Direction, Room> doors;

    public Room(String roomName) {
        this.items = new HashSet<>();
        this.roomName = roomName;
        doors = new HashMap<>();
    }

    public void addDoors(Room north, Room east, Room south, Room west) {
        addDoor(Direction.NORTH, north);
        addDoor(Direction.EAST, east);
        addDoor(Direction.SOUTH, south);
        addDoor(Direction.WEST, west);
    }

    private void addDoor(Direction direction, Room room) {
        if (room != null) {
            doors.put(direction, room);
        }
    }

    public Room addMonster(Monster monster) {
        this.monster = monster;
        return this;
    }

    public Room addItem(Item item) {
        items.add(item);
        return this;
    }

    public String getRoomName() {
        return roomName;
    }

    // TODO: implement this
    public boolean containsItem() {
        return true;
    }

    public void printMonsterStats() {
        if (monster != null) {
            monster.printStats();
        }
    }

    public String getAvailableDirections() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Direction direction : doors.keySet()) {
            stringBuilder.append(direction.getInputDir()).append(" ");
        }
        return stringBuilder.toString();
    }

    public Room getNextRoom(Direction direction) {
        return doors.getOrDefault(direction, null);
    }
}
