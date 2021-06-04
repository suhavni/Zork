package io.muic.ssc.assn.a3.zork.command.type;

import io.muic.ssc.assn.a3.zork.command.Command;
import io.muic.ssc.assn.a3.zork.command.CommandFactory;

import java.util.List;

public class HelpCommand extends Command {

    @Override
    public void execute(List<String> args) {
        game.getOutput().println("User requests for help. These are the list of commands we have:");
        game.getOutput().printf("Command", "Number of Arguments");
        game.getOutput().println("------------------------------------");
        CommandFactory.getAvailableCommands(game.isPlayingGame()).forEach(command ->
                game.getOutput().printf(command, "" + CommandFactory.getCommandType(command).getNumArgs()));
    }
}
