package io.muic.ssc.assn.a3.zork.item;

import io.muic.ssc.assn.a3.zork.Game;

public class DefaultItem extends Item {
    @Override
    // TODO: update
    public void useItem(Game game) {
        game.getPlayer().updateMaxHp(10);
    }
}
