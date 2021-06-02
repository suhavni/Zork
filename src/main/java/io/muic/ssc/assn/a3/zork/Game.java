package io.muic.ssc.assn.a3.zork;

import io.muic.ssc.assn.a3.zork.Command.Command;

import java.util.List;
import java.util.Scanner;

public class Game {
    private GameOutput output = new GameOutput();
    private CommandParser parser = new CommandParser();

    public void run() {
        while (true) {
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            List<String> words = parser.parse(s);
            Command command = CommandFactory.getCommandInstance(words.get(0));
            command.execute(this, words.subList(1, words.size()));
            output.println(s);
        }
    }

    public GameOutput getOutput() {
        return output;
    }

    public void exit() {
        System.exit(0);
    }
}
