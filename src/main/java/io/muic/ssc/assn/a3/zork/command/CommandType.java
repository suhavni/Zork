package io.muic.ssc.assn.a3.zork.command;

import io.muic.ssc.assn.a3.zork.command.type.*;

import java.lang.reflect.InvocationTargetException;

public enum CommandType {
//     TODO: ADD more commands
//     TODO: attack with, go {direction}, map, autopilot {file},
    // TODO: play {map-name}, save {saved-point-name}, load {saved-point-name}
    EXIT(0, "exit", ExitCommand.class),
    HELP(0, "help", HelpCommand.class),
    INFO(0, "info", InfoCommand.class),
    QUIT(0, "quit", QuitCommand.class),
    TAKE(1, "take", TakeCommand.class),
    DROP(1, "drop", DropCommand.class);

    int numArgs;
    String command;
    Command commandInstance;

    CommandType(int numArgs, String command, Class<? extends Command> commandClass) {
        this.numArgs = numArgs;
        this.command = command;
        try {
            this.commandInstance = commandClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public int getNumArgs() { return numArgs; }
    public String getCommand() { return command; }
    public Command getCommandInstance() { return commandInstance; }

}
