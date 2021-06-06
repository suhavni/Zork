package io.muic.ssc.assn.a3.zork.command.impl;

import io.muic.ssc.assn.a3.zork.command.Command;

public class LoadCommand extends Command {
    @Override
    public void execute(String arg) {
        game.getOutput().println("\u001B[33mLoading game state from " + arg + "\u001B[0m");
        game.load(arg);
    }
}
