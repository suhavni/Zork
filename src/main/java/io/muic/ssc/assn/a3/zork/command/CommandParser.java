package io.muic.ssc.assn.a3.zork.command;


import java.util.Arrays;
import java.util.List;

public class CommandParser {

    private String matchInputToCommand(String input) {
        for (String command : CommandFactory.getAllCommands()) {
            if (input.startsWith(command)) { return command; }
        }
        return null;
    }

    // "attack with  weapon" => ["attack with", "weapon"]
    // TODO: HANDLE invalid number of arguments
    // TODO: HANDLE invalid commands (NULLPOINTEREXCEPTION)
    public List<String> parse(String stringInput) {
        String cleanedInput = stringInput.trim();
        String command = matchInputToCommand(cleanedInput);
        assert command != null;
        String argString = cleanedInput.replaceFirst(command, "").strip();
        return Arrays.asList(command, argString);
    }
}
