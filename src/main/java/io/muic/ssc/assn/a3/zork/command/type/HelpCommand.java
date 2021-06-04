package io.muic.ssc.assn.a3.zork.command.type;

import io.muic.ssc.assn.a3.zork.Game;
import io.muic.ssc.assn.a3.zork.command.Command;
import io.muic.ssc.assn.a3.zork.command.CommandFactory;

import java.util.List;

public class HelpCommand extends Command {

    @Override
    public void execute(List<String> args) {
        Game.INSTANCE.getOutput().println("User requests for help. These are the list of commands we have:");
        Game.INSTANCE.getOutput().printf("Command", "Number of Arguments");
        Game.INSTANCE.getOutput().println("------------------------------------");
        for (String command : CommandFactory.getAvailableCommands(Game.INSTANCE.isPlayingGame())) {
            Game.INSTANCE.getOutput().printf(command, "" + CommandFactory.getCommandType(command).getNumArgs());
        }
    }
}
