package io.muic.ssc.assn.a3.zork.item.impl;

import io.muic.ssc.assn.a3.zork.item.Item;

public class AttackPotion extends Item {
    @Override
    public boolean useItem() {
        game.getOutput().println("Adding " + 75 + " Attack Power");
        game.getCheckPoint().getPlayer().addAttack(75);
        return true;
    }
}
