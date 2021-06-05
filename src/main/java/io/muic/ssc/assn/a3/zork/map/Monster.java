package io.muic.ssc.assn.a3.zork.map;

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
}
