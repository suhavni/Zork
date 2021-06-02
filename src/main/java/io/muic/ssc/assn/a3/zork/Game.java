package io.muic.ssc.assn.a3.zork;

import io.muic.ssc.assn.a3.zork.Command.Command;
import io.muic.ssc.assn.a3.zork.Command.CommandType;

import java.lang.reflect.InvocationTargetException;
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
            CommandType command = CommandFactory.getCommandType(words.get(0));
            try {
                command.getCommandClass().getConstructor().newInstance().execute(this, words.subList(1, words.size()));
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

    public GameOutput getOutput() {
        return output;
    }

    public void exit() {
        System.exit(0);
    }
}
