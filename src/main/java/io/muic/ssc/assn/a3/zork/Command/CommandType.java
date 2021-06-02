package io.muic.ssc.assn.a3.zork.Command;

import java.lang.reflect.InvocationTargetException;

public enum CommandType {
    EXIT(0, "exit", ExitCommand.class),
    HELP(0, "help", HelpCommand.class),
    INFO(0, "info", InfoCommand.class);

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
