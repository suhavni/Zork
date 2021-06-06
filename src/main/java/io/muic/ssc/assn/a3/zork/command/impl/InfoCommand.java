package io.muic.ssc.assn.a3.zork.command.impl;

import io.muic.ssc.assn.a3.zork.command.Command;

public class InfoCommand extends Command {
    @Override
    public void execute(String arg) {
        game.getOutput().println("\u001B[34mPLAYER STATS:\u001B[0m");
        game.getOutput().printf("HP:", "" + game.getCheckPoint().getPlayer().getHp());
        game.getOutput().printf("Max HP:", "" + game.getCheckPoint().getPlayer().getMaxHp());
        game.getOutput().printf("Attack Power:", "" + game.getCheckPoint().getPlayer().getAttack());
        game.getOutput().printf("Storage:", "" + game.getCheckPoint().getPlayer().getInventory().getSpaceTaken() +
                "/" + game.getCheckPoint().getPlayer().getInventory().getCapacity());

        game.getOutput().println("==========================");
        game.getOutput().println("\u001B[34mINVENTORY:\u001B[0m");
        game.getCheckPoint().getPlayer().getInventory().printInventory();

        game.getOutput().println("==========================");
        game.getOutput().println("\u001B[34mROOM STATS\u001B[0m");
        game.getOutput().printf("Current Room:", game.getCheckPoint().getCurrentRoom().getRoomName());
        game.getOutput().printf("Doors:", game.getCheckPoint().getCurrentRoom().getAvailableDirections());
        game.getOutput().printf("Items:", game.getCheckPoint().getCurrentRoom().getItems().toString());

        game.getOutput().println("==========================");
        if (game.getCheckPoint().getCurrentRoom().getMonster() != null) {
            game.getCheckPoint().getCurrentRoom().getMonster().printStats();
        }
    }
}
