package io.muic.ssc.assn.a3.zork.command.type;

import io.muic.ssc.assn.a3.zork.Game;
import io.muic.ssc.assn.a3.zork.command.Command;

import java.util.List;

public class TakeCommand extends Command {
    @Override
    // TODO: spaghetti code, update accordingly
    public void execute(List<String> args) {
        if (game.getCurrentRoom().containsItem()) {
            game.getOutput().println("Adding " + args.get(0) + " to inventory!");
            game.getPlayer().addItemToInventory(args.get(0));
        } else {
            game.getOutput().println("Sorry, room doesn't have " + args.get(0));
        }
    }
}
