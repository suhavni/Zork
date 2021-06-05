package io.muic.ssc.assn.a3.zork.map.impl;

import io.muic.ssc.assn.a3.zork.map.GameMap;
import io.muic.ssc.assn.a3.zork.map.Monster;
import io.muic.ssc.assn.a3.zork.map.Room;

import java.io.File;

public class OneMap extends GameMap {

    public OneMap() {
        super();
        addMapName("One Map");
        addMap(new File("src/main/java/maps/one.txt"));
        constructRooms();
    }

    private void constructRooms() {
        Room R1 = new Room("R1").addMonster(new Monster(500, 500));
        Room R2 = new Room("R2");
        Room R3 = new Room("R3").addMonster(new Monster(600, 500));
        Room R4 = new Room("R4").addMonster(new Monster(700, 500));
        Room R5 = new Room("R5");
        Room R6 = new Room("R6");
        Room R7 = new Room("R7").addMonster(new Monster(800, 650));

        addRooms(new Room[] {R1, R2, R3, R4, R5, R5, R6, R7});

        R1.addDoors(null, R2, null, null);
        R2.addDoors(null, null, R4, R1);
        R3.addDoors(null, R7, R5, null);
        R4.addDoors(R2, R5, null, null);
        R5.addDoors(R3, null, null, R4);
        R6.addDoors(R7, null, null, null);
        R7.addDoors(null, null, R6, R3);

        setSpawnRoom(R1);
    }
}
