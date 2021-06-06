package io.muic.ssc.assn.a3.zork.item.impl;

import io.muic.ssc.assn.a3.zork.item.Item;

public class AttackPotion extends Item {
    @Override
    public boolean useItem() {
        game.getOutput().println("Restoring " + 555 + " HP");
        game.getCheckPoint().getPlayer().addAttack(75);
        return true;
    }
}
