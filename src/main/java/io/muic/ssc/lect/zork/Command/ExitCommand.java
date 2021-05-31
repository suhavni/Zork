package io.muic.ssc.lect.zork.Command;

public class ExitCommand implements Command {

    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public String getCommand() {
        return 'exit';
    }

    @Override
    public void execute(Game game) {
        game.exit();
    }
}
