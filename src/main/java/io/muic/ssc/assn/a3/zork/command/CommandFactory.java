package io.muic.ssc.assn.a3.zork.command;

import java.util.*;

public class CommandFactory {
    // Maps the inputted command with its respective implementation of the command
    private static final Map<String, CommandType> COMMAND_LOOKUP = new HashMap<>();
    // Set of commands available when the game is in session
    private static final Set<String> COMMAND_DURING_GAME = new HashSet<>();
    // Set of commands available when there is no game currently in session
    private static final Set<String> COMMAND_BEFORE_GAME = new HashSet<>();

    static {{
        for (CommandType commandType : CommandType.values()) {
            COMMAND_LOOKUP.put(commandType.getCommand(), commandType);
            if (commandType.isDuringGame()) { COMMAND_DURING_GAME.add(commandType.getCommand()); }
            if (commandType.isStartOfGame()) { COMMAND_BEFORE_GAME.add(commandType.getCommand()); }
        }
    }}

    public static CommandType getCommandType(String command) {
        return COMMAND_LOOKUP.get(command);
    }

    /**
     * @param isPlayingGame whether there is a game in session
     * @return the set of commands available depending on isPlayingGame parameter
     */
    public static Set<String> getAvailableCommands(boolean isPlayingGame) {
        if (isPlayingGame) { return COMMAND_DURING_GAME; }
        else { return COMMAND_BEFORE_GAME; }
    }
 }
