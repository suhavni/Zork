package io.muic.ssc.assn.a3.zork;


import io.muic.ssc.assn.a3.zork.command.CommandFactory;
import io.muic.ssc.assn.a3.zork.command.CommandParser;
import io.muic.ssc.assn.a3.zork.command.CommandType;
import io.muic.ssc.assn.a3.zork.map.MapFactory;

import java.util.*;

public enum Game {
    INSTANCE;

    // The output class of the game
    private GameOutput output;
    // Whether a Zork game is being played
    private boolean playingGame;

    private CommandParser parser;
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
        parser = new CommandParser();
        savedCheckPoints = new HashMap<>();
        getOutput().println("\u001B[33mType \u001B[35mhelp \u001B[33mat any time to see the available commands.\u001B[0m" );
        getOutput().println("This game has 3 specialties: " );
        getOutput().println("1. If you drop any item that's not a weapon, you will trigger its effect and the item will be gone forever," );
        getOutput().println("but if you drop an item that is a weapon, you will simply be placing the weapon in the room and you can take it back in the future." );
        getOutput().println("2. Any monster you defeat will give you a HP potion that can increase your Max HP and increase your attack power.");
        getOutput().println("3. Moving to various rooms is highly recommended. Everytime you switch a room, your HP will constantly increase until you reach Max HP.");
        getOutput().println("\u001B[31mNOTE: If you die, the QUIT command will automatically be triggered\u001B[0m");
    }

    /**
     * Called whenever the user uses the PLAY command. creates an instance of
     * the game state starting from the beginning
     *
     * @param mapName The name of the map the user would like to play
     */
    public void play(String mapName) {
        playingGame = true;
        gameState = new GameState(MapFactory.getMap(mapName));
    }

    /**
     * Continues to get the user input, parses it through the CommandParser
     * class to get the command and arguments, then runs the respective commands
     * on the given arguments. This will continue to run until the user decides
     * to use the EXIT command
     */
    public void run() {
        String input;
        CommandType latestCommand = null;
        while (playingGame || latestCommand == null || !latestCommand.equals(CommandType.EXIT)) {
            getOutput().print("\n\u001B[32m> \u001B[0m");
            input = scanner.nextLine();
            latestCommand = runHelper(input);
        }
    }

    public CommandType runHelper(String input) {
        List<String> words = parser.parse(input, playingGame);
        try {
            CommandType command = CommandFactory.getCommandType(words.get(0));
            command.getCommandInstance().execute(words.get(1));
            if (isPlayingGame() && getCheckPoint().getPlayer().getHp() <= 0) { return CommandType.QUIT; }
            return command;
        } catch (NullPointerException e) {
            output.println("Command does not exist");
        }
        return null;
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
        if (!checkPointName.isEmpty()) {
            savedCheckPoints.put(checkPointName, new GameState(gameState));
        } else {
            getOutput().println("Can't save to empty string name.");
        }
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
