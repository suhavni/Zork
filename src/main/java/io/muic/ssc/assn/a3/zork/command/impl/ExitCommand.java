package io.muic.ssc.assn.a3.zork.command.impl;

import io.muic.ssc.assn.a3.zork.command.Command;

public class ExitCommand extends Command {

    @Override
    public void execute(String arg) {
        game.getOutput().println("\u001B[31mExiting Zork... Bye bye\u001B[0m");
        game.exit();
    }
}
