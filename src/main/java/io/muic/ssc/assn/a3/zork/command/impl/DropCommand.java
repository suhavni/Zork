package io.muic.ssc.assn.a3.zork.command.impl;

import io.muic.ssc.assn.a3.zork.command.Command;
import io.muic.ssc.assn.a3.zork.item.ItemFactory;

public class DropCommand extends Command {

    @Override
    // TODO: spagetti code, edit this
    public void execute(String arg) {
        System.out.println("Player chooses to drop item");
        if (game.getCheckPoint().getPlayer().carriesItem(arg)) {
            ItemFactory.getItemType(arg).getItemInstance().useItem();
            game.getCheckPoint().getPlayer().removeItemFromInventory(arg);
        } else {
            game.getOutput().println("Item not found in inventory...");
        }
    }
}
