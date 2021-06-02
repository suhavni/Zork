package io.muic.ssc.assn.a3.zork.command;

import io.muic.ssc.assn.a3.zork.CommandFactory;
import io.muic.ssc.assn.a3.zork.Game;

import java.util.List;

public class HelpCommand extends Command {

    @Override
    public void execute(Game game, List<String> args) {
        game.getOutput().println("User requests for helo. These are the list of commands we have:");
        game.getOutput().printf("Command", "Number of Arguments");
        game.getOutput().println("----------------------------");
        for (String command : CommandFactory.getAllCommands()) {
            game.getOutput().printf(command, ""+CommandFactory.getCommandType(command).getNumArgs());
        }
        game.run();
    }
}
