package io.muic.ssc.lect.zork.Command;

public interface Command {
    int numArgs();

    String getCommand();

    void execute(Game game);
}
