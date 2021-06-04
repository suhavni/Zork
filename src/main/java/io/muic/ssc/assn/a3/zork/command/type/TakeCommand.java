package io.muic.ssc.assn.a3.zork.command.type;

import io.muic.ssc.assn.a3.zork.Game;
import io.muic.ssc.assn.a3.zork.command.Command;

import java.util.List;

public class TakeCommand extends Command {
    @Override
    // TODO: spaghetti code, update accordingly
    public void execute(List<String> args) {
        if (Game.INSTANCE.getCurrentRoom().containsItem()) {
            Game.INSTANCE.getOutput().println("Adding " + args.get(0) + " to inventory!");
            Game.INSTANCE.getPlayer().addItemToInventory(args.get(0));
        } else {
            Game.INSTANCE.getOutput().println("Sorry, room doesn't have " + args.get(0));
        }
    }
}
