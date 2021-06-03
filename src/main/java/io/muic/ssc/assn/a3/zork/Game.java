package io.muic.ssc.assn.a3.zork;

import io.muic.ssc.assn.a3.zork.command.CommandFactory;
import io.muic.ssc.assn.a3.zork.command.CommandParser;
import io.muic.ssc.assn.a3.zork.command.CommandType;
import io.muic.ssc.assn.a3.zork.room.Room;

import java.util.List;
import java.util.Scanner;

public class Game {
    private GameOutput output;
    private CommandParser parser;
    private Player player;
    private Room currentRoom;
    private Scanner scanner;
    private boolean playingGame;

    public Game() {
        scanner = new Scanner(System.in);
        output = new GameOutput();
        parser = new CommandParser();
        player = new Player(this);
        playingGame = true;
        output.println("Initializing new Zork game");
        // TODO: FIX this
        currentRoom = new Room() {

        };
    }

    public void run() {
        while (playingGame) {
            String input = scanner.nextLine();
            List<String> words = parser.parse(input);
            CommandType command = CommandFactory.getCommandType(words.get(0));
            command.getCommandInstance().execute(this, words.subList(1, words.size()));
        }
    }

    public GameOutput getOutput() {
        return output;
    }

    public void exit() {
        scanner.close();
        System.exit(55555);
    }

    public Player getPlayer() {
//        System.out.println("got player");
        return player;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void quit() {
//        scanner.close();
        playingGame = false;
    }
}
