package io.muic.ssc.assn.a3.zork.item.impl;

import io.muic.ssc.assn.a3.zork.item.Item;

public class StorageSpace extends Item {

    @Override
    public boolean useItem() {
        game.getCheckPoint().getPlayer().getInventory().updateInventoryCapacity();
        return true;
    }
}
