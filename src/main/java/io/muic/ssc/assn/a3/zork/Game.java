package io.muic.ssc.assn.a3.zork;


import io.muic.ssc.assn.a3.zork.command.CommandFactory;
import io.muic.ssc.assn.a3.zork.command.CommandParser;
import io.muic.ssc.assn.a3.zork.command.CommandType;

import java.util.*;

public enum Game {
    INSTANCE;

    // The output class of the game
    private GameOutput output;
    // Whether a Zork game is being played
    private boolean playingGame;
    // Scanner for user input
    private Scanner scanner = new Scanner(System.in);
    // The game's current state
    GameState gameState;
    // Map of all game saved in the current ggme session
    Map<String, GameState> savedCheckPoints;

    /**
     * Creates a new singleton instance of the game. The game starts with the
     * state playingGame to be false. This will change to true whenever the user
     * decides to play the game and back to false whenever the user quits the game.
    **/
    Game() {
        output = new GameOutput();
        playingGame = false;
        savedCheckPoints = new HashMap<>();
    }

    /**
     * Called whenever the user uses the PLAY command. creates an instance of
     * the game state starting from the beginning
     *
     * @param mapName The name of the map the user would like to play
     */
    public void play(String mapName) {
        playingGame = true;
        // TODO: FIX this
        gameState = new GameState(mapName);
    }

    /**
     * Continues to get the user input, parses it through the CommandParser
     * class to get the command and arguments, then runs the respective commands
     * on the given arguments. This will continue to run until the user decides
     * to use the EXIT command
     */
    public void run() {
        CommandParser parser = new CommandParser();
        String input;
        List<String> words;
        CommandType command;
        while (true) {
            input = scanner.nextLine();
            words = parser.parse(input, playingGame);
            try {
                command = CommandFactory.getCommandType(words.get(0));
                command.getCommandInstance().execute(words.get(1));
            } catch (NullPointerException e) {
                output.println("Command does not exist");
            }
        }
    }

    /**
     * Exits the game entirely.
     */
    public void exit() {
        scanner.close();
        System.exit(55555);
    }

    /**
     * Quit the current game session and returns back to the command line before game
     * has started.
     */
    public void quit() {
        playingGame = false;
    }

    /**
     * Saves the current state with the specified name
     *
     * @param checkPointName the name to label the saved state
     */
    public void save(String checkPointName) {
        savedCheckPoints.put(checkPointName, new GameState(gameState));
    }

    /**
     * Load a saved state associated with the specified checkpoint name
     *
     * @param checkPointName name of checkpoint user wants to load from
     */
    public void load(String checkPointName) {
        if (savedCheckPoints.containsKey(checkPointName)) {
            playingGame = true;
            gameState = new GameState(savedCheckPoints.get(checkPointName));
        } else {
            output.println("No such checkpoint found");
        }
    }

    public GameOutput getOutput() {
        return output;
    }

    public GameState getCheckPoint() {
        return gameState;
    }

    public boolean isPlayingGame() {
        return playingGame;
    }

    public Set<String> getSavedCheckPoints() {
        return savedCheckPoints.keySet();
    }
}
