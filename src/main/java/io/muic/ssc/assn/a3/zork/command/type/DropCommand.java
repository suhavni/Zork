package io.muic.ssc.assn.a3.zork.command.type;

import io.muic.ssc.assn.a3.zork.Game;
import io.muic.ssc.assn.a3.zork.command.Command;
import io.muic.ssc.assn.a3.zork.item.ItemFactory;

import java.util.List;

public class DropCommand extends Command {
    @Override
    // TODO: spagetti code, edit this
    public void execute(List<String> args) {
        String item = args.get(0);
        if (Game.INSTANCE.getPlayer().carriesItem(item)) {
            ItemFactory.getItemType(item).getItemInstance().useItem(Game.INSTANCE);
            Game.INSTANCE.getPlayer().removeItemFromInventory(item);
        } else {
            Game.INSTANCE.getOutput().println("Item not found in inventory...");
        }
    }
}
