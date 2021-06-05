package io.muic.ssc.assn.a3.zork.command.impl;

import io.muic.ssc.assn.a3.zork.Direction;
import io.muic.ssc.assn.a3.zork.command.Command;

public class GoCommand extends Command {
    @Override
    public void execute(String arg) {
        for (Direction direction : Direction.values()) {
            if (direction.getInputDir().equals(arg)) {
                game.getCheckPoint().move(direction);
                return;
            }
        }
        game.getOutput().println("THAT ISN'T A DIRECTION RIP");
    }
}
