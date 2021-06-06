package io.muic.ssc.assn.a3.zork.command.impl;

import io.muic.ssc.assn.a3.zork.command.Command;

public class SaveCommand extends Command {
    @Override
    public void execute(String arg) {
        game.getOutput().println("\u001B[33mSaving current state to checkpoint: \u001B[35m" + arg + "\u001B[0m");
        game.save(arg);
    }
}
