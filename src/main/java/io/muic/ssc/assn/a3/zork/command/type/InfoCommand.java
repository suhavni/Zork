package io.muic.ssc.assn.a3.zork.command.type;

import io.muic.ssc.assn.a3.zork.Game;
import io.muic.ssc.assn.a3.zork.command.Command;

import java.util.HashMap;
import java.util.List;

public class InfoCommand extends Command {
    @Override
    // TODO: UPDATE this
    public void execute(Game game, List<String> args) {
        // TODO: in case there's extra player stats.
        game.getOutput().println("PLAYER STATS:");
        game.getOutput().printf("HP:", "" + game.getPlayer().getHp());
        game.getOutput().printf("Max HP:", "" + game.getPlayer().getMaxHp());
        game.getOutput().printf("Attack Power:", "" + game.getPlayer().getAttack());
        game.getOutput().printf("Defense:", "" + game.getPlayer().getDefense());

        game.getOutput().println("INVENTORY:");
        game.getPlayer().printInventory();
        // TODO: ROOM STATS
        // TODO: Monster stat, items stat, doors, etc
    }
}
