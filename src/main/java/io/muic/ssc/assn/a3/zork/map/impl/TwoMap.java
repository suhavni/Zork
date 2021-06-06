package io.muic.ssc.assn.a3.zork.map.impl;

import io.muic.ssc.assn.a3.zork.map.GameMap;
import io.muic.ssc.assn.a3.zork.map.Monster;
import io.muic.ssc.assn.a3.zork.map.Room;

import java.io.File;

public class TwoMap extends GameMap {
    public TwoMap() {
        super();
        addMapName("Two Map");
        addMap(new File("src/main/resources/maps/two.txt"));
        Room[] rooms = constructRooms();
        addRoomProperties(rooms);
        addMonstersAndItems(rooms);
    }

    public TwoMap(TwoMap map, String curRoom) {
        super();
        addMapName("Two Map");
        addMap(new File("src/main/resources/maps/two.txt"));
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
        rooms[0].addDoors(null, rooms[1], rooms[2], null);
        rooms[1].addDoors(null, null, null, rooms[0]);
        rooms[2].addDoors(rooms[0], null, rooms[4], null);
        rooms[3].addDoors(null, null, rooms[5], null);
        rooms[4].addDoors(rooms[2], rooms[5], null, null);
        rooms[5].addDoors(rooms[3], rooms[6], null, rooms[4]);
        rooms[6].addDoors(null, null, null, rooms[5]);

        setSpawnRoom(rooms[5]);
    }

    private void addMonstersAndItems(Room[] rooms) {
        rooms[0].addMonster(new Monster(700, 800));
        rooms[1].addMonster(new Monster(500, 400));
        rooms[2].addMonster(new Monster(550, 350));
        rooms[4].addMonster(new Monster(350, 200));
        rooms[6].addMonster(new Monster(450, 300));
        setMonsterCount(5);

        rooms[1].addItem("luck grenade");
        rooms[1].addItem("sword");
        rooms[2].addItem("attack potion");
        rooms[4].addItem("attack potion");
        rooms[5].addItem("bow");
    }
}
