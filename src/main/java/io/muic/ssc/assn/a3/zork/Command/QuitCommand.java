package io.muic.ssc.assn.a3.zork.Command;

import io.muic.ssc.assn.a3.zork.Game;

import java.util.List;

public class QuitCommand extends Command {

    @Override
    public void execute(Game game, List<String> args) {
        game.getOutput().println("Quitting current Zork session");
    }
}
