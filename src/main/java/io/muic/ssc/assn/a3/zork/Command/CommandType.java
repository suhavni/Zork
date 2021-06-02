package io.muic.ssc.assn.a3.zork.Command;

public enum CommandType {
    EXIT(0, "exit", ExitCommand.class),
    HELP(0, "help", HelpCommand.class),
    INFO(0, "info", InfoCommand.class);

    int numArgs;
    String command;
    Class<? extends Command> commandClass;

    CommandType(int numArgs, String command, Class<? extends Command> commandClass) {
        this.numArgs = numArgs;
        this.command = command;
        this.commandClass = commandClass;
    }

    public int getNumArgs() { return numArgs; }
    public String getCommand() { return command; }
    public Class<? extends Command> getCommandClass() { return commandClass; }

}
