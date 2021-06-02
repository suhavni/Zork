package io.muic.ssc.assn.a3.zork;

import io.muic.ssc.assn.a3.zork.Command.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CommandParser {

    private List<String> allCommandsSortedByLength = new ArrayList<>();
    {
        allCommandsSortedByLength.addAll(CommandFactory.getAllCommands());
        allCommandsSortedByLength.sort((cmd1, cmd2) -> cmd2.length() - cmd1.length());
    }

    private String matchInputToCommand(String input) {
        for (String command : allCommandsSortedByLength) {
            if (input.startsWith(command)) { return command; }
        }
        return null;
    }

    // "attack with  weapon" => ["attack with", "weapon"]
    public List<String> parse(String stringInput) {
        String cleanedInput = stringInput.trim();
        String command = matchInputToCommand(cleanedInput);
        Command commandInstance = CommandFactory.getCommandInstance(command);
        System.out.println(command + " " + commandInstance.numArgs());
        assert command != null;
        String argString = cleanedInput.replaceFirst(command, "").strip();
        return Arrays.asList(command, argString);
    }
}
