package io.muic.ssc.assn.a3.zork.command.impl;

import io.muic.ssc.assn.a3.zork.command.Command;

import java.util.List;

public class PlayCommand extends Command {

    @Override
    public void execute(List<String> args) {
        game.getOutput().println("Initializing new Zork Game!!!");
        game.play(args.get(0));
    }
}
