package io.muic.ssc.assn.a3.zork;


import io.muic.ssc.assn.a3.zork.command.CommandFactory;
import io.muic.ssc.assn.a3.zork.command.CommandParser;
import io.muic.ssc.assn.a3.zork.command.CommandType;
import io.muic.ssc.assn.a3.zork.room.Room;

import java.util.*;

public enum Game {
    INSTANCE;

    private GameOutput output;
    private boolean playingGame;
    private Scanner scanner = new Scanner(System.in);
    CheckPoint checkPoint;
    Map<String, CheckPoint> savedCheckPoints;

    Game() {
        output = new GameOutput();
        playingGame = false;
    }

    public void play(String mapName) {
        playingGame = true;
        savedCheckPoints = new HashMap<>();
        // TODO: FIX this
        checkPoint = new CheckPoint(mapName);
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

    public CheckPoint getCheckPoint() {
        return checkPoint;
    }

    public void quit() {
//        scanner.close();
        playingGame = false;
    }

    public boolean isPlayingGame() { return playingGame; }

    public void save(String checkPointName) {
        savedCheckPoints.put(checkPointName, new CheckPoint(checkPoint));
    }

    public void load(String checkPointName) {
        if (savedCheckPoints.containsKey(checkPointName)) {
            checkPoint = new CheckPoint(savedCheckPoints.get(checkPointName));
        } else {
            output.println("No such checkpoint found");
        }
    }

    public Set<String> getSavedCheckPoints() { return savedCheckPoints.keySet(); }
}
