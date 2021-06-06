package io.muic.ssc.assn.a3.zork.map;

import io.muic.ssc.assn.a3.zork.Direction;
import io.muic.ssc.assn.a3.zork.item.ItemFactory;
import io.muic.ssc.assn.a3.zork.item.ItemType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Room {

    protected Monster monster;
    protected Set<ItemType> items;
    private final String roomName;
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

    public void addMonster(Monster monster) {
        this.monster = monster;
    }

    public void addItem(String item) {
        items.add(ItemFactory.getItemType(item));
    }

    public String getRoomName() {
        return roomName;
    }

    public boolean containsItem(String item) {
        return items.contains(ItemFactory.getItemType(item));
    }

    public Monster getMonster() {
        return monster;
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

    public Set<ItemType> getItems() {
        return items;
    }

    public void removeItem(String item) {
        items.remove(ItemFactory.getItemType(item));
    }
}
