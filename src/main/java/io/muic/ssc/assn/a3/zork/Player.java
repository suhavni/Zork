package io.muic.ssc.assn.a3.zork;

public class Player {
    int maxHp;
    int hp;
    int attack;
    int defense;

    Game game;

    public Player(Game game) {
        maxHp = 1000;
        hp = maxHp;
        attack = 200;
        defense = 100;
        this.game = game;
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
}
