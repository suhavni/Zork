package io.muic.ssc.assn.a3.zork;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandParserTest {
    @Test
    void testParser() {
        CommandParser commandParser = new CommandParser();
        System.out.println(commandParser.parse("exit helloworld").toString());
        System.out.println(commandParser.parse("exithelloworld").toString());
        System.out.println(commandParser.parse("help").toString());
//        System.out.println(commandParser.parse("").toString());
//        System.out.println(commandParser.parse("shoot").toString());
    }
}