package io.muic.ssc.assn.a3.zork;

import io.muic.ssc.assn.a3.zork.item.Item;

import java.util.HashMap;
import java.util.Map;

public class Player {
    int maxHp;
    int hp;
    int attack;
    int defense;

    Map<String, Integer> inventory;

    Game game;

    public Player(Game game) {
        maxHp = 1000;
        hp = maxHp;
        attack = 200;
        defense = 100;
        this.game = game;
        inventory = new HashMap<>();
    }

    public int getMaxHp() { return maxHp; }
    public int getHp() { return hp; }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public void decreaseHp(int hpReduction) {
        hp -= hpReduction;
        if (hp <= 0) { dies(); }
    }

    public void dies() {
        game.getOutput().println("Unfortunately, player has died.");
        // TODO: Go back to last saved checkpoint vs. end game
    }

    // TODO: update accordingly
    public void addItemToInventory(String item) {
//        System.out.println("in inventory");
        inventory.put(item, inventory.getOrDefault(item, 0) + 1);
    }

    public void printInventory() {
        for (String item : inventory.keySet()) {
            game.getOutput().printf(item, "" + inventory.get(item));
        }
    }
}
