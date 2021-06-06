package io.muic.ssc.assn.a3.zork.command.impl;

import io.muic.ssc.assn.a3.zork.command.Command;

public class InfoCommand extends Command {
    @Override
    // TODO: UPDATE this
    public void execute(String arg) {
        // TODO: in case there's extra player stats.
        game.getOutput().println("\u001B[34mPLAYER STATS:\u001B[0m");
        game.getOutput().printf("HP:", "" + game.getCheckPoint().getPlayer().getHp());
        game.getOutput().printf("Max HP:", "" + game.getCheckPoint().getPlayer().getMaxHp());
        game.getOutput().printf("Attack Power:", "" + game.getCheckPoint().getPlayer().getAttack());

        game.getOutput().println("==========================");
        game.getOutput().println("\u001B[34mINVENTORY:\u001B[0m");
        game.getCheckPoint().getPlayer().getInventory().printInventory();

        game.getOutput().println("==========================");
        game.getOutput().println("\u001B[34mROOM STATS\u001B[0m");
        game.getOutput().printf("Current Room:", game.getCheckPoint().getCurrentRoom().getRoomName());
        game.getOutput().printf("Doors:", game.getCheckPoint().getCurrentRoom().getAvailableDirections());
        game.getOutput().printf("Items:", game.getCheckPoint().getCurrentRoom().itemsAsString());

        game.getOutput().println("==========================");
        if (game.getCheckPoint().getCurrentRoom().getMonster() != null) {
            game.getCheckPoint().getCurrentRoom().getMonster().printStats();
        }
    }
}
