package io.muic.ssc.assn.a3.zork.map;

import io.muic.ssc.assn.a3.zork.Game;

public class Monster {
    private int hp;
    private int attack;

    public Monster(int hp, int attack) {
        this.hp = hp;
        this.attack = attack;
    }

    public void reduceHp(int power) {
        hp -= power;
    }

    public void printStats() {
        Game.INSTANCE.getOutput().println("\u001B[34mMONSTER STATS\u001B[0m");
        Game.INSTANCE.getOutput().printf("HP:", ""+hp);
        Game.INSTANCE.getOutput().printf("Attack Power", ""+attack);
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }
}
