package io.muic.ssc.assn.a3.zork.command.impl;

import io.muic.ssc.assn.a3.zork.command.Command;

import java.util.List;

public class LoadCommand extends Command {
    @Override
    public void execute(List<String> args) {
        game.getOutput().println("Loading game state from " + args.get(0));
        game.load(args.get(0));
    }
}
