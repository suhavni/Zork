package io.muic.ssc.assn.a3.zork;

import io.muic.ssc.assn.a3.zork.room.Room;

public class GameState {
    // TODO: private GameMap;
    // an instance of the Player class (with stats associated with the player)
    private Player player;
    // The room the player is currently in
    private Room currentRoom;

    /**
     * Creates an instance of the game state with a given mapName to initialize
     * initial game state
     *
     * @param mapName name of the map the user wants to play
     */
    public GameState(String mapName) {
        // TODO: GameMap game = MAP_LOOKUP.get(mapName);
        this.player = new Player();
        currentRoom = new Room() {

        };
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
    }

    public Player getPlayer() {
        return player;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
