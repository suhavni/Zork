package io.muic.ssc.assn.a3.zork;

import java.util.HashMap;
import java.util.Map;

public class Player {
    // The maximum HP a player can have
    int maxHp;
    // The current HP the player has
    int hp;
    // The attack power of the player
    int attack;
    // The amount of items in the player's inventory
    int inventorySpaceTaken;
    // The maximum capacity the player can carry
    int inventoryCapacity;

    // The items the player is carrying
    Map<String, Integer> inventory;
    // The singleton instance of the game
    Game game = Game.INSTANCE;

    /**
     * Initializing the Player
     */
    public Player() {
        maxHp = 1000;
        hp = maxHp;
        attack = 200;
        inventorySpaceTaken = 0;
        inventoryCapacity = 10;
        inventory = new HashMap<>();
    }

    /**
     * Constructing a new Player instance by copying the given Player instance.
     * Used when saving or loading a checkpoint
     *
     * @param player the player that is being copied
     */
    public Player(Player player) {
        this.game = player.game;
        this.maxHp = player.maxHp;
        this.hp = player.hp;
        this.attack = player.attack;
        this.inventorySpaceTaken = player.inventorySpaceTaken;
        this.inventoryCapacity = player.inventoryCapacity;
        this.inventory = new HashMap<>();
        for (String item : player.inventory.keySet()) {
            this.inventory.put(item, player.inventory.get(item));
        }

    }

    /**
     * Decreases the HP of the player
     *
     * @param hpReduction amount of HP reduced
     */
    public void decreaseHp(int hpReduction) {
        hp -= hpReduction;
        if (hp <= 0) { dies(); }
    }

    /**
     * Update the Max HP of the player
     *
     * @param percent the percent of increase scaled from current HP and Max HP
     */
    public void updateMaxHp(int percent) {
        maxHp += maxHp*percent/100;
        hp += hp*percent/100;
    }

    /**
     * Player loses the game -> death
     */
    public void dies() {
        game.getOutput().println("Unfortunately, player has died.");
        game.quit();
         // TODO: Go back to last saved checkpoint vs. end game
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
            game.getOutput().println("You have too many things in your inventory. Please drop something.");
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

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public void printInventory() {
        for (String item : inventory.keySet()) {
            game.getOutput().printf(item, "" + inventory.get(item));
        }
    }

    public boolean carriesItem(String item) {
        return inventory.containsKey(item);
    }
}
