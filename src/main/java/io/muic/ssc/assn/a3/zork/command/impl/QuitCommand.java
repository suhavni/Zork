package io.muic.ssc.assn.a3.zork.command.impl;

import io.muic.ssc.assn.a3.zork.command.Command;

public class QuitCommand extends Command {

    @Override
    public void execute(String arg) {
        game.getOutput().println("\u001B[33mQuitting current Zork session\u001B[0m");
        game.quit();
    }
}
