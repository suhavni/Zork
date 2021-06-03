package io.muic.ssc.assn.a3.zork.command;

import java.util.*;

public class CommandFactory {
    private static final Map<String, CommandType> COMMAND_LOOKUP = new HashMap<>();
    private static final Set<String> COMMAND_DURING_GAME = new HashSet<>();
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

    public static Set<String> getAvailableCommands(boolean isPlayingGame) {
        if (isPlayingGame) { return COMMAND_DURING_GAME; }
        else { return COMMAND_BEFORE_GAME; }
    }
 }
