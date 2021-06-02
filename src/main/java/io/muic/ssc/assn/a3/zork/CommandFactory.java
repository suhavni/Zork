package io.muic.ssc.assn.a3.zork;

import io.muic.ssc.assn.a3.zork.Command.Command;
import io.muic.ssc.assn.a3.zork.Command.ExitCommand;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class CommandFactory {
    private static final List<Class<? extends Command>> REGISTERED_COMMANDS = Arrays.asList(
            ExitCommand.class, ExitCommand.class
    );

    private static final Map<String, Command> COMMAND_LOOKUP = new HashMap<>();

    static {{
        for (Class <? extends  Command> commandClass : REGISTERED_COMMANDS) {
            try {
                Command command = commandClass.getDeclaredConstructor().newInstance();
                COMMAND_LOOKUP.put(command.getCommand(), command);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }}

    public static Command getCommandInstance(String command) {
        return COMMAND_LOOKUP.get(command);
    }

    public static List<String> getAllCommands() {
        return new ArrayList<>(COMMAND_LOOKUP.keySet());
    }
 }
