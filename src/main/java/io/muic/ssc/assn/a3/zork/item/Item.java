package io.muic.ssc.assn.a3.zork.item;

import io.muic.ssc.assn.a3.zork.Game;

// TODO: IMPLEMENT this
public abstract class Item {
    protected Game game = Game.INSTANCE;
    public abstract void useItem();
}
