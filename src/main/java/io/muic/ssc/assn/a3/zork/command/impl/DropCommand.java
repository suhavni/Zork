package io.muic.ssc.assn.a3.zork.command.impl;

import io.muic.ssc.assn.a3.zork.command.Command;
import io.muic.ssc.assn.a3.zork.item.ItemFactory;

import java.lang.reflect.InvocationTargetException;

public class DropCommand extends Command {

    @Override
    // TODO: spaghetti code, edit this
    public void execute(String arg) {
        System.out.println("\u001B[33mPlayer chooses to drop item\u001B[0m");
        if (game.getCheckPoint().getPlayer().getInventory().carriesItem(arg)) {
            try {
                if (! ItemFactory.getItemType(arg).getItemClass().getConstructor().newInstance().useItem()) {
                    game.getCheckPoint().getCurrentRoom().addItem(arg);
                }
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException ignored) {
            }
            game.getCheckPoint().getPlayer().getInventory().removeItemFromInventory(arg);
        } else {
            game.getOutput().println("Item not found in inventory...");
        }
    }
}
