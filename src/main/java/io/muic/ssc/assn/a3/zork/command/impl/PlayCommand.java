package io.muic.ssc.assn.a3.zork.command.impl;

import io.muic.ssc.assn.a3.zork.command.Command;
import io.muic.ssc.assn.a3.zork.map.MapType;

public class PlayCommand extends Command {

    @Override
    public void execute(String arg) {
        game.getOutput().println("Initializing new Zork Game!!!");
        if (!game.play(arg)) {
            game.getOutput().println("Sorry, map does not exist. Currently, the maps we have are: ");
            for (MapType map : MapType.values()) {
                game.getOutput().println(map.getMapName());
            }
        }
    }
}
