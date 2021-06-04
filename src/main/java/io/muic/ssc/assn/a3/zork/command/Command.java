package io.muic.ssc.assn.a3.zork.command;

import io.muic.ssc.assn.a3.zork.Game;

public abstract class Command {
    /// The singleton instance of the game
    protected Game game = Game.INSTANCE;

    /**
     *
     * @param arg arguments given with the command
     */
    public abstract void execute(String arg);
}
