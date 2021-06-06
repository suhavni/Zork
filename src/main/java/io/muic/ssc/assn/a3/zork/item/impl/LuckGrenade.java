package io.muic.ssc.assn.a3.zork.item.impl;

import io.muic.ssc.assn.a3.zork.item.Weapon;

import java.util.Random;

public class LuckGrenade extends Weapon {

    public LuckGrenade() {
        super();
        Random random = new Random();
        if (random.nextInt(1000) < 999) {
            setAttackBonus(0);
            game.getOutput().println("You got unlucky :(");
        } else {
            setAttackBonus(750);
            game.getOutput().println("You got lucky :)");
        }
    }
}
