package io.muic.ssc.assn.a3.zork;

public class GameOutput {
    public void println(String message) {
        System.out.println(message);
    }

    public void printf(String arg1, String arg2) {
        System.out.printf("%-10s | %-25s\n", arg1, arg2);
    }
}
