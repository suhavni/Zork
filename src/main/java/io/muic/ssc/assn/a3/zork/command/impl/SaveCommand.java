package io.muic.ssc.assn.a3.zork.command.impl;

import io.muic.ssc.assn.a3.zork.command.Command;

import java.util.List;

public class SaveCommand extends Command {
    @Override
    public void execute(List<String> args) {
        game.getOutput().println("Saving current state to checkpoint: " + args.get(0));
        game.save(args.get(0));
    }
}
