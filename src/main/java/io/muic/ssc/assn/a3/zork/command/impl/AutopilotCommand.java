package io.muic.ssc.assn.a3.zork.command.impl;

import io.muic.ssc.assn.a3.zork.command.Command;
import io.muic.ssc.assn.a3.zork.command.CommandType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.util.concurrent.TimeUnit.SECONDS;

public class AutopilotCommand extends Command {
    @Override
    public void execute(String arg) {
        try {
            File file = new File(arg);
            game.getOutput().println("\u001B[33mRunning game on autopilot using file at PATH: \n" + file.getAbsolutePath() + "\u001B[0m");
            Scanner scanner = new Scanner(file);
            String input;
            CommandType latestCommand = null;
            while (latestCommand == null || !latestCommand.equals(CommandType.QUIT)) {
                SECONDS.sleep(1);
                input = scanner.nextLine();
                game.getOutput().println("\n\u001B[32m>>> " + input + "\u001B[0m");
                latestCommand = game.runHelper(input);
            }
        } catch (FileNotFoundException | InterruptedException e) {
            game.getOutput().println("Sorry, file not found");
        }
    }
}
