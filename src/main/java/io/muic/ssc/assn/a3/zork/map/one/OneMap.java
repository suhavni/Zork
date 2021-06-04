package io.muic.ssc.assn.a3.zork.map.one;

import io.muic.ssc.assn.a3.zork.map.GameMap;
import io.muic.ssc.assn.a3.zork.map.Room;

public class OneMap extends GameMap {

    public OneMap() {
        super();
    }

    {{
        addMapName("One Map");

        Room R1 = new Room("R1");
        Room R2 = new Room("R2");
        Room R3 = new Room("R3");
        Room R4 = new Room("R4");
        Room R5 = new Room("R5");
        Room R6 = new Room("R6");
        Room R7 = new Room("R7");

    }}
}
