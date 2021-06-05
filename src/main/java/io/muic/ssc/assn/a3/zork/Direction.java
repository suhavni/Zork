package io.muic.ssc.assn.a3.zork;

public enum Direction {
    NORTH("north"),
    SOUTH("south"),
    EAST("east"),
    WEST("west");

    String inputDir;

    Direction(String inputDir) {
        this.inputDir = inputDir;
    }

    public String getInputDir() {
        return inputDir;
    }
}
