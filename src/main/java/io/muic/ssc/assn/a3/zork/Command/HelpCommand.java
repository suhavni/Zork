package io.muic.ssc.assn.a3.zork.Command;

import io.muic.ssc.assn.a3.zork.CommandFactory;
import io.muic.ssc.assn.a3.zork.Game;

import java.util.List;

public class HelpCommand extends Command {

    @Override
    public void execute(Game game, List<String> args) {
        System.out.println("User requests for helo. These are the list of commands we have:");
        System.out.printf("%-10s | %-25s\n", "Command", "Number of Arguments");
        System.out.println("=================================");
        for (String command : CommandFactory.getAllCommands()) {
            System.out.printf("%-10s | %-25d\n", command, CommandFactory.getCommandType(command).getNumArgs());
        }
    }
}
