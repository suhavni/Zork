package io.muic.ssc.assn.a3.zork.command;

import io.muic.ssc.assn.a3.zork.Game;

import java.util.List;

public class TakeCommand extends Command {
    @Override
    // TODO: spaghetti code, update accordingly
    public void execute(Game game, List<String> args) {
        if (game.getCurrentRoom().containsItem()) {
            game.getPlayer().addItemToInventory(args.get(0));
        }
        game.run();
    }
}
