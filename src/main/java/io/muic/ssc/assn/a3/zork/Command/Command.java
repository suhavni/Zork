package io.muic.ssc.assn.a3.zork.Command;

import io.muic.ssc.assn.a3.zork.Game;

public interface Command {
    int numArgs();

    String getCommand();

    void execute(Game game);
}
