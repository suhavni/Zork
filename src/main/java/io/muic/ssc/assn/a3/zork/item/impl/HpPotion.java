package io.muic.ssc.assn.a3.zork.item.impl;

import io.muic.ssc.assn.a3.zork.item.Item;

public class HpPotion extends Item {

    @Override
    public boolean useItem() {
        game.getOutput().println("Adding 5% to Max HP");
        game.getCheckPoint().getPlayer().updateMaxHp(5);
        return true;
    }
}
