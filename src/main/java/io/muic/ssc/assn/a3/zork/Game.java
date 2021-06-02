package io.muic.ssc.assn.a3.zork;

import io.muic.ssc.assn.a3.zork.Command.CommandType;

import java.util.List;
import java.util.Scanner;

public class Game {
    private GameOutput output;
    private CommandParser parser;

    public Game() {
        output = new GameOutput();
        parser = new CommandParser();

        System.out.println("Initializing new Zork game");
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        List<String> words = parser.parse(s);
        CommandType command = CommandFactory.getCommandType(words.get(0));
        command.getCommandInstance().execute(this, words.subList(1, words.size()));
    }

    public GameOutput getOutput() {
        return output;
    }

    public void exit() {
        System.exit(55555);
    }
}
