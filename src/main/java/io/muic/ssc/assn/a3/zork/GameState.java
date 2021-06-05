package io.muic.ssc.assn.a3.zork;

import io.muic.ssc.assn.a3.zork.map.GameMap;
import io.muic.ssc.assn.a3.zork.map.MapFactory;
import io.muic.ssc.assn.a3.zork.map.MapType;
import io.muic.ssc.assn.a3.zork.map.Room;
import io.muic.ssc.assn.a3.zork.player.Player;

public class GameState {
    // TODO: private GameMap;
    // an instance of the Player class (with stats associated with the player)
    private Player player;
    // The room the player is currently in
    private Room currentRoom;
    private MapType mapType;
    private GameMap map;

    /**
     * Creates an instance of the game state with a given mapName to initialize
     * initial game state
     *
     * @param mapType the map played by the user
     */
    public GameState(MapType mapType) {
        // TODO: GameMap game = MAP_LOOKUP.get(mapName);
        this.mapType = mapType;
        this.player = new Player();
        map = mapType.getInstance();
        assert map != null;
        currentRoom = map.getSpawnRoom();
    }

    /**
     * Creates an instance of the game state  by duplicating a given game state
     * Used when user wants to save / load CheckPoints
     *
     * @param gameState the game state we want to duplicate
     */
    public GameState(GameState gameState) {
        // TODO: this.GameMap = save.GameMap;
        this.player = new Player(gameState.player);
        this.currentRoom = gameState.currentRoom;
        this.mapType = gameState.mapType;
        this.map = mapType.getInstance(mapType, gameState.map, gameState.currentRoom.getRoomName());
        assert this.map != null;
        this.currentRoom = this.map.getSpawnRoom();
    }

    public Player getPlayer() {
        return player;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public GameMap getMap() {
        return map;
    }

    public void move(Direction direction) {
        Room nextRoom = currentRoom.getNextRoom(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
        }
    }
}
