package io.muic.ssc.assn.a3.zork.command.impl;

import io.muic.ssc.assn.a3.zork.command.Command;

public class SaveCommand extends Command {
    @Override
    public void execute(String arg) {
        game.getOutput().println("Saving current state to checkpoint: " + arg);
        game.save(arg);
    }
}
