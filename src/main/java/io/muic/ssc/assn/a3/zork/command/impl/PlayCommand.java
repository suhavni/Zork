package io.muic.ssc.assn.a3.zork.command.impl;

import io.muic.ssc.assn.a3.zork.command.Command;
import io.muic.ssc.assn.a3.zork.map.MapFactory;
import io.muic.ssc.assn.a3.zork.map.MapType;

public class PlayCommand extends Command {

    @Override
    public void execute(String arg) {
        game.getOutput().println("\u001B[33mInitializing new Zork Game!!!\u001B[0m");
        if (MapFactory.getMap(arg) == null) {
            game.getOutput().println("Sorry, map does not exist. Currently, the maps we have are: ");
            for (MapType map : MapType.values()) {
                game.getOutput().print("\u001B[35m" + map.getMapName() + " \u001B[0m");
            }
            game.getOutput().println("");
        } else {
            game.play(arg);
        }
    }
}
