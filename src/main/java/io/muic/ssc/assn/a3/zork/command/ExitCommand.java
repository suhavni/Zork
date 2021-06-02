package io.muic.ssc.assn.a3.zork.command;

import io.muic.ssc.assn.a3.zork.Game;

import java.util.List;

public class ExitCommand extends Command {

    @Override
    public void execute(Game game, List<String> args) {
        game.getOutput().println("Exiting Zork... Bye bye");
        game.exit();
    }
}
