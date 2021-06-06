package io.muic.ssc.assn.a3.zork.command.impl;

import io.muic.ssc.assn.a3.zork.command.Command;

import java.io.FileNotFoundException;

public class MapCommand extends Command {
    @Override
    public void execute(String arg) {
        game.getOutput().println("\u001B[33mUser requests to look at current map.\u001B[0m");
        game.getOutput().println("* represents the walls.");
        game.getOutput().println("|| represents the doors.");
        game.getOutput().println("x represents monsters.");
        game.getOutput().println("o represents items.\n");
        game.getCheckPoint().getMap().printMap();
    }
}
