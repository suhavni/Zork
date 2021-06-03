package io.muic.ssc.assn.a3.zork.command.type;

import io.muic.ssc.assn.a3.zork.Game;
import io.muic.ssc.assn.a3.zork.command.Command;

import java.util.List;

public class DropCommand extends Command {
    @Override
    public void execute(Game game, List<String> args) {
        String item = args.get(0);
        if (game.getPlayer().carriesItem(item)) {

            game.getPlayer().removeItemFromInventory(item);
        }
    }
}
