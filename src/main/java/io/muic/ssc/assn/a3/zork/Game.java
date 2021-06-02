package io.muic.ssc.assn.a3.zork;

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
            output.println(s);
        }
    }

    public void exit() {
        System.out.println("exiting game");
        System.exit(0);
    }
}
