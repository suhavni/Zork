package io.muic.ssc.assn.a3.zork.command.impl;

import io.muic.ssc.assn.a3.zork.command.Command;

import java.util.List;

public class ExitCommand extends Command {

    @Override
    public void execute(List<String> args) {
        game.getOutput().println("Exiting Zork... Bye bye");
        game.exit();
    }
}
