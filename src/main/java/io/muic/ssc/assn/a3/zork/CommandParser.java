package io.muic.ssc.assn.a3.zork;

import java.util.Arrays;
import java.util.List;

public class CommandParser {
    // "attack with  weapon" => ["attack with", "weapon"]
    public List<String> parse(String stringInput) {
        String[] strings = stringInput.trim().split(" ");
        return Arrays.asList(strings);
    }
}
