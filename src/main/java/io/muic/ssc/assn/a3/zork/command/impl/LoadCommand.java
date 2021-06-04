package io.muic.ssc.assn.a3.zork.command.impl;

import io.muic.ssc.assn.a3.zork.command.Command;

public class LoadCommand extends Command {
    @Override
    public void execute(String arg) {
        game.getOutput().println("Loading game state from " + arg);
        game.load(arg);
    }
}
