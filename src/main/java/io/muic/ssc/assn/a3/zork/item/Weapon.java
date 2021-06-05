package io.muic.ssc.assn.a3.zork.item;

public class Weapon extends Item {
    int attackBonus;

    public int getAttackBonus() {
        return attackBonus;
    }

    @Override
    public void useItem() {
        game.getOutput().println("Sorry, this item does not have any special drop ability");
    }

    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }
}
