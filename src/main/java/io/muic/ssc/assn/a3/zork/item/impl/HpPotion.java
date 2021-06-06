package io.muic.ssc.assn.a3.zork.item.impl;

import io.muic.ssc.assn.a3.zork.item.Item;

public class HpPotion extends Item {
    @Override
    // TODO: update
    public boolean useItem() {
        game.getOutput().println("Restoring " + 300 + " HP");
        game.getCheckPoint().getPlayer().updateHp(300);
        return true;
    }
}
