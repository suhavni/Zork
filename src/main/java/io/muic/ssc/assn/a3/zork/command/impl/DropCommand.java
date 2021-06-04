package io.muic.ssc.assn.a3.zork.command.impl;

import io.muic.ssc.assn.a3.zork.command.Command;
import io.muic.ssc.assn.a3.zork.item.ItemFactory;

import java.util.List;

public class DropCommand extends Command {
    @Override
    // TODO: spagetti code, edit this
    public void execute(List<String> args) {
        String item = args.get(0);
        System.out.println("Player chooses to drop item");
        if (game.getCheckPoint().getPlayer().carriesItem(item)) {
            ItemFactory.getItemType(item).getItemInstance().useItem();
            game.getCheckPoint().getPlayer().removeItemFromInventory(item);
        } else {
            game.getOutput().println("Item not found in inventory...");
        }
    }
}
