package io.muic.ssc.assn.a3.zork;

import java.util.HashMap;
import java.util.Map;

public class Player {
    int maxHp;
    int hp;
    int attack;
    int defense;
    int inventorySpaceTaken;
    int inventoryCapacity;

    Map<String, Integer> inventory;

    Game game;

    public Player(Game game) {
        maxHp = 1000;
        hp = maxHp;
        attack = 200;
        defense = 100;
        inventorySpaceTaken = 0;
        inventoryCapacity = 10;
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

    public void updateMaxHp(int percent) {
        maxHp += maxHp*percent/100;
        hp += hp*percent/100;
    }

    public void dies() {
        game.getOutput().println("Unfortunately, player has died.");
        // TODO: Go back to last saved checkpoint vs. end game
    }

    // TODO: update accordingly
    public void addItemToInventory(String item) {
//        System.out.println("in inventory");
        if (inventorySpaceTaken < inventoryCapacity) {
            inventorySpaceTaken++;
            inventory.put(item, inventory.getOrDefault(item, 0) + 1);
        } else {
            game.getOutput().println("You have too many things in your inventory. Please drop somethng.");
        }
    }

    public void printInventory() {
        for (String item : inventory.keySet()) {
            game.getOutput().printf(item, "" + inventory.get(item));
        }
    }

    public boolean carriesItem(String item) {
        return inventory.containsKey(item);
    }

    public void removeItemFromInventory(String item) {
        inventory.put(item, inventory.get(item) - 1);
        if (inventory.get(item) == 0) { inventory.remove(item); }
    }
}
