package io.muic.ssc.assn.a3.zork.player;

import io.muic.ssc.assn.a3.zork.Game;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    // The amount of items in the player's inventory
    int inventorySpaceTaken;
    // The maximum capacity the player can carry
    int inventoryCapacity;

    // The items the player is carrying
    Map<String, Integer> inventory;

    public Inventory() {
        inventoryCapacity = 10;
        inventorySpaceTaken = 0;
        inventory = new HashMap<>();
    }

    public Inventory(Inventory copy) {
        this.inventorySpaceTaken = copy.inventorySpaceTaken;
        this.inventoryCapacity = copy.inventoryCapacity;
        this.inventory = new HashMap<>();
        for (String item : copy.inventory.keySet()) {
            this.inventory.put(item, copy.inventory.get(item));
        }
    }

    /**
     * @param item that has been dropped by the player
     */
    public void removeItemFromInventory(String item) {
        inventory.put(item, inventory.get(item) - 1);
        if (inventory.get(item) == 0) { inventory.remove(item); }
        inventorySpaceTaken --;
    }

    /**
     * @param item item that has been picked up from player
     */
    // TODO: update accordingly
    public void addItemToInventory(String item) {
        if (inventorySpaceTaken < inventoryCapacity) {
            inventorySpaceTaken++;
            inventory.put(item, inventory.getOrDefault(item, 0) + 1);
        } else {
            Game.INSTANCE.getOutput().println("You have too many things in your inventory. Please drop something.");
        }
    }

    public void printInventory() {
        for (String item : inventory.keySet()) {
            Game.INSTANCE.getOutput().printf(item, "" + inventory.get(item));
        }
    }

    public boolean carriesItem(String item) {
        return inventory.containsKey(item);
    }
}
