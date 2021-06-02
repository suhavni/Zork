package io.muic.ssc.assn.a3.zork.command;

import io.muic.ssc.assn.a3.zork.Game;

import java.util.List;

public abstract class Command {

    public abstract void execute(Game game, List<String> args);
}
