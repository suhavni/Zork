package io.muic.ssc.assn.a3.zork.command.impl;

import io.muic.ssc.assn.a3.zork.command.Command;

public class TakeCommand extends Command {
    @Override
    // TODO: spaghetti code, update accordingly
    public void execute(String arg) {
        game.getOutput().println("\u001B[33mAdding " + arg + " to inventory!\u001B[0m");
        if (game.getCheckPoint().getCurrentRoom().containsItem(arg)) {
            game.getCheckPoint().getPlayer().getInventory().addItemToInventory(arg);
            game.getCheckPoint().getCurrentRoom().removeItem(arg);
        } else {
            game.getOutput().println("Sorry, room doesn't have " + arg);
        }
    }
}
