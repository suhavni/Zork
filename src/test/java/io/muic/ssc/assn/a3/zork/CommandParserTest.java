package io.muic.ssc.assn.a3.zork;

import io.muic.ssc.assn.a3.zork.command.CommandParser;
import org.junit.jupiter.api.Test;

class CommandParserTest {
    @Test
    void testParser() {
        CommandParser commandParser = new CommandParser();
        System.out.println(commandParser.parse("exit helloworld").toString());
        System.out.println(commandParser.parse("exithelloworld").toString());
        System.out.println(commandParser.parse("help hello world hello").toString());
//        System.out.println(commandParser.parse("").toString());
//        System.out.println(commandParser.parse("shoot").toString());
    }
}