package io.muic.ssc.assn.a3.zork.command.type;

import io.muic.ssc.assn.a3.zork.Game;
import io.muic.ssc.assn.a3.zork.command.Command;

import java.util.List;

public class PlayCommand extends Command {

    @Override
    public void execute(List<String> args) {
        Game.INSTANCE.getOutput().println("Initializing new Zork Game!!!");
        Game.INSTANCE.play(args.get(0));
    }
}