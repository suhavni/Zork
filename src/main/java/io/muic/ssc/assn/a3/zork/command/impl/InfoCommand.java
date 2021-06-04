package io.muic.ssc.assn.a3.zork.command.impl;

import io.muic.ssc.assn.a3.zork.command.Command;

import java.util.List;

public class InfoCommand extends Command {
    @Override
    // TODO: UPDATE this
    public void execute(String arg) {
        // TODO: in case there's extra player stats.
        game.getOutput().println("PLAYER STATS:");
        game.getOutput().printf("HP:", "" + game.getCheckPoint().getPlayer().getHp());
        game.getOutput().printf("Max HP:", "" + game.getCheckPoint().getPlayer().getMaxHp());
        game.getOutput().printf("Attack Power:", "" + game.getCheckPoint().getPlayer().getAttack());
        game.getOutput().printf("Defense:", "" + game.getCheckPoint().getPlayer().getDefense());

        game.getOutput().println("INVENTORY:");
        game.getCheckPoint().getPlayer().printInventory();

        game.getOutput().println("SAVED CHECKPOINTS");
        game.getOutput().println(game.getSavedCheckPoints().toString());
        // TODO: ROOM STATS
        // TODO: Monster stat, items stat, doors, etc
    }
}
