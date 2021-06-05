package io.muic.ssc.assn.a3.zork.map;

import io.muic.ssc.assn.a3.zork.Game;

public class Monster {
    int hp;
    int attack;

    public Monster(int hp, int attack) {
        this.hp = hp;
        this.attack = attack;
    }

    public void reduceHp(int power) {
        hp -= power;
    }

    public void printStats() {
        Game.INSTANCE.getOutput().println("MONSTER STATS");
        Game.INSTANCE.getOutput().printf("HP:", ""+hp);
        Game.INSTANCE.getOutput().printf("Attack Power", ""+attack);
    }
}
