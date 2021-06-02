package io.muic.ssc.assn.a3.zork;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
