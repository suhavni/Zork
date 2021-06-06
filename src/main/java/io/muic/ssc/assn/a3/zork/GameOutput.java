package io.muic.ssc.assn.a3.zork;

public class GameOutput {
    /**
     * Outputs the given message
     *
     * @param message message that needs to be outputted
     */
    public void println(String message) {
        System.out.println(message);
    }

    /**
     * Formatted Output (used in help and info)
     *
     * @param arg1 left column
     * @param arg2 right column
     */
    public void printf(String arg1, String arg2) {
        System.out.printf("%-15s | %-25s\n", arg1, arg2);
    }

    public void print(String message) {
        System.out.print(message);
    }
}
