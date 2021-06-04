package io.muic.ssc.assn.a3.zork.command.type;

import io.muic.ssc.assn.a3.zork.Game;
import io.muic.ssc.assn.a3.zork.command.Command;

import java.util.List;

public class InfoCommand extends Command {
    @Override
    // TODO: UPDATE this
    public void execute(List<String> args) {
        // TODO: in case there's extra player stats.
        Game.INSTANCE.getOutput().println("PLAYER STATS:");
        Game.INSTANCE.getOutput().printf("HP:", "" + Game.INSTANCE.getPlayer().getHp());
        Game.INSTANCE.getOutput().printf("Max HP:", "" + Game.INSTANCE.getPlayer().getMaxHp());
        Game.INSTANCE.getOutput().printf("Attack Power:", "" + Game.INSTANCE.getPlayer().getAttack());
        Game.INSTANCE.getOutput().printf("Defense:", "" + Game.INSTANCE.getPlayer().getDefense());

        Game.INSTANCE.getOutput().println("INVENTORY:");
        Game.INSTANCE.getPlayer().printInventory();
        // TODO: ROOM STATS
        // TODO: Monster stat, items stat, doors, etc
    }
}
