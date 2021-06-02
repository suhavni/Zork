package io.muic.ssc.assn.a3.zork.Command;

import io.muic.ssc.assn.a3.zork.Game;

import java.util.List;

public interface Command {
    int numArgs();

    String getCommand();

    void execute(Game game, List<String> args);
}
