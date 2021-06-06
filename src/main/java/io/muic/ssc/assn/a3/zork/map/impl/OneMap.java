package io.muic.ssc.assn.a3.zork.map.impl;

import io.muic.ssc.assn.a3.zork.map.GameMap;
import io.muic.ssc.assn.a3.zork.map.Monster;
import io.muic.ssc.assn.a3.zork.map.Room;

import java.io.File;

public class OneMap extends GameMap {

    public OneMap() {
        super();
        addMapName("One Map");
        addMap(new File("src/main/resources/maps/one.txt"));
        Room[] rooms = constructRooms();
        addRoomProperties(rooms);
        addMonstersAndItems(rooms);
    }

    public OneMap(OneMap map, String curRoom) {
        super();
        addMapName("One Map");
        addMap(new File("src/main/resources/maps/one.txt"));
        Room[] rooms = constructRooms();
        addRoomProperties(rooms);
        setSpawnRoom(RoomLookup(curRoom));
        for (String room : getRooms()) {
            copyMonstersAndItems(this.RoomLookup(room), map.RoomLookup(room));
        }
        setMonsterCount(map.getMonsterCount());
    }

    private Room[] constructRooms() {
        Room R1 = new Room("R1");
        Room R2 = new Room("R2");
        Room R3 = new Room("R3");
        Room R4 = new Room("R4");
        Room R5 = new Room("R5");
        Room R6 = new Room("R6");
        Room R7 = new Room("R7");

        Room[] rooms = new Room[] {R1, R2, R3, R4, R5, R6, R7};
        addRooms(rooms);
        return rooms;
    }

    private void addRoomProperties(Room[] rooms) {
        rooms[0].addDoors(null, rooms[1], null, null);
        rooms[1].addDoors(null, null, rooms[3], rooms[0]);
        rooms[2].addDoors(null, rooms[6], rooms[4], null);
        rooms[3].addDoors(rooms[1], rooms[4], null, null);
        rooms[4].addDoors(rooms[2], null, null, rooms[3]);
        rooms[5].addDoors(rooms[6], null, null, null);
        rooms[6].addDoors(null, null, rooms[5], rooms[2]);

        setSpawnRoom(rooms[0]);
    }

    private void addMonstersAndItems(Room[] rooms) {
        rooms[0].addMonster(new Monster(500, 300));
        rooms[3].addMonster(new Monster(600, 400));
        rooms[4].addMonster(new Monster(700, 400));
        rooms[6].addMonster(new Monster(800, 650));
        setMonsterCount(4);

        rooms[0].addItem("bow");
        rooms[1].addItem("luck grenade");
        rooms[2].addItem("attack potion");
        rooms[4].addItem("storage space");
        rooms[5].addItem("sword");
        rooms[6].addItem("attack potion");
    }
}
