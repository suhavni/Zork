package io.muic.ssc.assn.a3.zork.command.impl;

import io.muic.ssc.assn.a3.zork.command.Command;

public class TakeCommand extends Command {
    @Override
    // TODO: spaghetti code, update accordingly
    public void execute(String arg) {
        if (game.getCheckPoint().getCurrentRoom().containsItem()) {
            game.getOutput().println("Adding " + arg + " to inventory!");
            game.getCheckPoint().getPlayer().getInventory().addItemToInventory(arg);
        } else {
            game.getOutput().println("Sorry, room doesn't have " + arg);
        }
    }
}
