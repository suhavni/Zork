package io.muic.ssc.assn.a3.zork.command.impl;

import io.muic.ssc.assn.a3.zork.command.Command;

import java.io.FileNotFoundException;

public class MapCommand extends Command {
    @Override
    public void execute(String arg) {
        game.getCheckPoint().getMap().printMap();
    }
}
