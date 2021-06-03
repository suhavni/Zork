package io.muic.ssc.assn.a3.zork.command;

import io.muic.ssc.assn.a3.zork.command.CommandType;

import java.util.*;

public class CommandFactory {
    private static final Map<String, CommandType> COMMAND_LOOKUP = new HashMap<>();

    static {{
        for (CommandType commandType : CommandType.values()) {
            COMMAND_LOOKUP.put(commandType.getCommand(), commandType);
        }
    }}

    public static CommandType getCommandType(String command) {
        return COMMAND_LOOKUP.get(command);
    }

    public static List<String> getAllCommands() {
        return new ArrayList<>(COMMAND_LOOKUP.keySet());
    }
 }
