package io.muic.ssc.assn.a3.zork;

import io.muic.ssc.assn.a3.zork.room.Room;

public class CheckPoint {
    // TODO: private GameMap;
    private Player player;
    private Room currentRoom;

    public CheckPoint(String mapName) {
        // TODO: GameMap game = MAP_LOOKUP.get(mapName);
        this.player = new Player();
        currentRoom = new Room() {

        };
    }

    public CheckPoint(CheckPoint save) {
        // TODO: this.GameMap = save.GameMap;
        this.player = new Player(save.player);
        this.currentRoom = save.currentRoom;
    }

    public Player getPlayer() {
        return player;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
