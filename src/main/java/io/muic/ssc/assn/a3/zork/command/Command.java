package io.muic.ssc.assn.a3.zork.command;


import java.util.List;

public abstract class Command {
    public abstract void execute(List<String> args);
}
