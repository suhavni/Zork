package io.muic.ssc.assn.a3.zork;


import io.muic.ssc.assn.a3.zork.command.CommandFactory;
import io.muic.ssc.assn.a3.zork.command.CommandParser;
import io.muic.ssc.assn.a3.zork.command.CommandType;
import io.muic.ssc.assn.a3.zork.room.Room;

import java.util.List;
import java.util.Scanner;

public enum Game {
    INSTANCE;

    private GameOutput output;
    private Player player;
    private Room currentRoom;
    private boolean playingGame;
    private Scanner scanner = new Scanner(System.in);

    Game() {
        output = new GameOutput();
        playingGame = false;
    }

    public void play(String mapName) {
        playingGame = true;
        // TODO: FIX this
        player = new Player();
        currentRoom = new Room() {

        };
        // TODO: MAP
    }

    public void run() {
        CommandParser parser = new CommandParser();
        String input;
        List<String> words;
        CommandType command;
        while (true) {
            input = scanner.nextLine();
            words = parser.parse(input, playingGame);
            try {
                command = CommandFactory.getCommandType(words.get(0));
                command.getCommandInstance().execute(words.subList(1, words.size()));
            } catch (NullPointerException e) {
                output.println("Command does not exist");
            }
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
        return player;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void quit() {
//        scanner.close();
        playingGame = false;
    }

    public boolean isPlayingGame() { return playingGame; }
}
