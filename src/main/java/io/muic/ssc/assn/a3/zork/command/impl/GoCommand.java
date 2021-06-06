package io.muic.ssc.assn.a3.zork.command.impl;

import io.muic.ssc.assn.a3.zork.Direction;
import io.muic.ssc.assn.a3.zork.DirectionFactory;
import io.muic.ssc.assn.a3.zork.command.Command;

public class GoCommand extends Command {
    @Override
    public void execute(String arg) {
        Direction direction = DirectionFactory.getDirection(arg);
        if (direction == null) {
            game.getOutput().println("THAT ISN'T A DIRECTION RIP");
        } else {
            game.getOutput().println("\u001B[33mMoving " + arg + "\u001B[0m");
            game.getCheckPoint().getPlayer().updateMaxHp(15);
            game.getCheckPoint().move(direction);
        }
    }
}
