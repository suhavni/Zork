package io.muic.ssc.assn.a3.zork.command;


import java.util.Arrays;
import java.util.List;

public class CommandParser {
    private String matchInputToCommand(String input, boolean isDuringGame) {
        for (String command : CommandFactory.getAvailableCommands(isDuringGame)) {
            if (input.startsWith(command)) { return command; }
        }
        return null;
    }

    // "attack with  weapon" => ["attack with", "weapon"]
    // TODO: HANDLE invalid number of arguments
    // TODO: HANDLE invalid commands (NULLPOINTEREXCEPTION)
    public List<String> parse(String stringInput, boolean isDuringGame) {
        String cleanedInput = stringInput.trim();
        try {
            String command = matchInputToCommand(cleanedInput, isDuringGame);
            assert command != null;
            String argString = cleanedInput.replaceFirst(command, "").strip();
            return Arrays.asList(command, argString);
        } catch (NullPointerException e) {
            return null;
        }
    }
}
