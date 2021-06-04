package io.muic.ssc.assn.a3.zork.command;


import io.muic.ssc.assn.a3.zork.Game;

import java.util.List;

public abstract class Command {
    protected Game game = Game.INSTANCE;
    public abstract void execute(String arg);
}
