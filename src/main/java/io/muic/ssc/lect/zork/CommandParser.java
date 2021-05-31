package io.muic.ssc.lect.zork;

import java.util.Arrays;
import java.util.List;

public class CommandParser {
    public List<String> parse(String stringInput) {
        String[] strings = stringInput.split(" ");
        return Arrays.asList(strings);
    }
}
