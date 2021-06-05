package io.muic.ssc.assn.a3.zork.command.impl;

import io.muic.ssc.assn.a3.zork.command.Command;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AutopilotCommand extends Command {
    @Override
    public void execute(String arg) {
        try {
            File file = new File(arg);
            System.out.println(file.getAbsolutePath());
            Scanner scanner = new Scanner(file);
            String latestCommand = "";
            while (!latestCommand.equals("quit")) {
                latestCommand = game.runHelper(scanner);
            }
        } catch (FileNotFoundException e) {
            game.getOutput().println("Sorry, file not found");
        }
    }
}
