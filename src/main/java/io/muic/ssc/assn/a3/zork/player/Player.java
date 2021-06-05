package io.muic.ssc.assn.a3.zork.player;

import io.muic.ssc.assn.a3.zork.Game;

import java.util.HashMap;
import java.util.Map;

public class Player {
    // The maximum HP a player can have
    private int maxHp;
    // The current HP the player has
    private int hp;
    // The attack power of the player
    private int attack;

    private Inventory inventory;
    // The singleton instance of the game
    Game game = Game.INSTANCE;

    /**
     * Initializing the Player
     */
    public Player() {
        maxHp = 1000;
        hp = maxHp;
        attack = 200;
        inventory = new Inventory();
    }

    /**
     * Constructing a new Player instance by copying the given Player instance.
     * Used when saving or loading a checkpoint
     *
     * @param player the player that is being copied
     */
    public Player(Player player) {
        this.maxHp = player.getMaxHp();
        this.hp = player.hp;
        this.attack = player.attack;
        this.inventory = new Inventory(player.inventory);
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

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
