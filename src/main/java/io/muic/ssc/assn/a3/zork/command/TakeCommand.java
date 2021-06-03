package io.muic.ssc.assn.a3.zork.command;

import io.muic.ssc.assn.a3.zork.Game;

import java.util.List;

public class TakeCommand extends Command {
    @Override
    // TODO: spaghetti code, update accordingly
    public void execute(Game game, List<String> args) {
//        System.out.println("executed");
        if (game.getCurrentRoom().containsItem()) {
//            System.out.println("pass if");
            game.getOutput().println("Adding " + args.get(0) + " to inventory!");
            game.getPlayer().addItemToInventory(args.get(0));
        } else {
            game.getOutput().println("Sorry, room doesn't have " + args.get(0));
        }
    }
}
