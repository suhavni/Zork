package io.muic.ssc.assn.a3.zork.command;

import io.muic.ssc.assn.a3.zork.command.impl.*;

import java.lang.reflect.InvocationTargetException;

public enum CommandType {
//     TODO: ADD more commands
//     TODO: attack with
    EXIT(false, true,0, "exit", ExitCommand.class),
    HELP(true, true,0, "help", HelpCommand.class),
    INFO(true, false, 0, "info", InfoCommand.class),
    QUIT(true, false, 0, "quit", QuitCommand.class),
    TAKE(true, false,1, "take", TakeCommand.class),
    DROP(true, false, 1, "drop", DropCommand.class),
    SAVE(true, false, 1, "save", SaveCommand.class),
    LOAD(false, true, 1, "load", LoadCommand.class),
    AUTOPILOT(true, false, 1, "autopilot", AutopilotCommand.class),
    MAP(true, false, 0, "map", MapCommand.class),
    GO(true, false, 1, "go", GoCommand.class),
    PLAY(false, true, 1, "play", PlayCommand.class);

    int numArgs;
    String command;
    Command commandInstance;
    boolean duringGame;
    boolean startOfGame;

    CommandType(boolean duringGame, boolean startOfGame, int numArgs, String command, Class<? extends Command> commandClass) {
        this.numArgs = numArgs;
        this.command = command;
        this.duringGame = duringGame;
        this.startOfGame = startOfGame;
        try {
            this.commandInstance = commandClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public int getNumArgs() { return numArgs; }
    public String getCommand() { return command; }
    public Command getCommandInstance() { return commandInstance; }
    public boolean isDuringGame() { return duringGame; }
    public boolean isStartOfGame() { return startOfGame; }

}
