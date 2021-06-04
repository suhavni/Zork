package io.muic.ssc.assn.a3.zork.item.impl;

import io.muic.ssc.assn.a3.zork.item.Item;

public class DefaultItem extends Item {
    @Override
    // TODO: update
    public void useItem() {
        game.getCheckPoint().getPlayer().updateMaxHp(10);
    }
}
