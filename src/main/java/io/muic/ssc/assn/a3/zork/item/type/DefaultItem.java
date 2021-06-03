package io.muic.ssc.assn.a3.zork.item.type;

import io.muic.ssc.assn.a3.zork.Game;
import io.muic.ssc.assn.a3.zork.item.Item;

public class DefaultItem extends Item {
    @Override
    // TODO: update
    public void useItem(Game game) {
        game.getPlayer().updateMaxHp(10);
    }
}
