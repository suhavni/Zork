package io.muic.ssc.assn.a3.zork.Command;

import io.muic.ssc.assn.a3.zork.Game;

public class ExitCommand implements Command {

    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public String getCommand() {
        return "exit";
    }

    @Override
    public void execute(Game game) {
        game.exit();
    }
}
