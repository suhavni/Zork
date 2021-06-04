package io.muic.ssc.assn.a3.zork.command.impl;

import io.muic.ssc.assn.a3.zork.command.Command;

import java.util.List;

public class PlayCommand extends Command {

    @Override
    public void execute(String arg) {
        game.getOutput().println("Initializing new Zork Game!!!");
        game.play(arg);
    }
}
