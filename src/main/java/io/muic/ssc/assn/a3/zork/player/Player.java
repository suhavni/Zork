package io.muic.ssc.assn.a3.zork.player;

import static io.muic.ssc.assn.a3.zork.Game.INSTANCE;

public class Player {
    // The maximum HP a player can have
    private int maxHp;
    // The current HP the player has
    private int hp;

    private int attack;
    private final Inventory inventory;

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
     * changes the HP of the player
     *
     * @param hpAdded amount of HP added/reduced depending on sign
     */
    public void updateHp(int hpAdded) {
        hp += hpAdded;
        if (hp <= 0) { dies(); }
        else if (hp > maxHp) { hp = maxHp; }
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
        INSTANCE.getOutput().println("\u001B[33;7;1m Unfortunately, player has died. \u001B[0m");
        INSTANCE.getOutput().println("Quitting current game session");
        INSTANCE.quit();
         // TODO: Go back to last saved checkpoint vs. end game
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return hp;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getAttack() {
        return attack;
    }

    public void addAttack(int addedAttack) {
        attack += addedAttack;
    }
}
