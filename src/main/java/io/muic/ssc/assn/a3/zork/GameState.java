package io.muic.ssc.assn.a3.zork;

import io.muic.ssc.assn.a3.zork.map.GameMap;
import io.muic.ssc.assn.a3.zork.map.MapType;
import io.muic.ssc.assn.a3.zork.map.Room;

import java.lang.reflect.InvocationTargetException;

public class GameState {
    // an instance of the Player class (with stats associated with the player)
    private final Player player;
    // The room the player is currently in
    private Room currentRoom;
    private final MapType mapType;
    private GameMap map;

    /**
     * Creates an instance of the game state with a given mapName to initialize
     * initial game state
     *
     * @param mapType the map played by the user
     */
    public GameState(MapType mapType) {
        this.mapType = mapType;
        this.player = new Player();
        try {
            map = mapType.getMapClass().getConstructor().newInstance();
            currentRoom = map.getSpawnRoom();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException ignored) {
        }
    }

    /**
     * Creates an instance of the game state  by duplicating a given game state
     * Used when user wants to save / load CheckPoints
     *
     * @param gameState the game state we want to duplicate
     */
    public GameState(GameState gameState) {
        this.player = new Player(gameState.player);
        this.currentRoom = gameState.currentRoom;
        this.mapType = gameState.mapType;
        try {
            this.map = mapType.getMapClass().getConstructor(GameMap.class, String.class).newInstance(gameState.map, gameState.currentRoom.getRoomName());
            this.currentRoom = this.map.getSpawnRoom();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException ignored) {
        }
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
            Game.INSTANCE.getOutput().println("Move successful. Adding 750 HP.");
            Game.INSTANCE.getCheckPoint().getPlayer().updateHp(750);
            currentRoom = nextRoom;
        } else {
            Game.INSTANCE.getOutput().println("Move unsuccessful. There is no door there.");
        }
    }
}
