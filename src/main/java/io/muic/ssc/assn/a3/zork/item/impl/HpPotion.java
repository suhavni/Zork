package io.muic.ssc.assn.a3.zork.item.impl;

import io.muic.ssc.assn.a3.zork.item.Item;

public class HpPotion extends Item {

    @Override
    public boolean useItem() {
        game.getOutput().println("Restoring " + 555 + " HP");
        game.getCheckPoint().getPlayer().updateHp(555);
        return true;
    }
}
