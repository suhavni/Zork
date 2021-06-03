package io.muic.ssc.assn.a3.zork.command.type;

import io.muic.ssc.assn.a3.zork.Game;
import io.muic.ssc.assn.a3.zork.command.Command;

import java.util.List;

public class PlayCommand extends Command {

    @Override
    public void execute(Game game, List<String> args) {
        game.getOutput().println("Initializing new Zork Game!!!");
        game.play(args.get(0));
    }
}
