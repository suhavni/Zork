package io.muic.ssc.assn.a3.zork.map;

import io.muic.ssc.assn.a3.zork.item.Item;

import java.util.HashSet;
import java.util.Set;

public class Room {

    protected Monster monster;
    protected Set<Item> items;
    private String roomName;

    public Room(String roomName) {
        this.items = new HashSet<>();
        this.roomName = roomName;
    }

    public void addMonster(Monster monster) {
        this.monster = monster;
    }

    public void addItem(Item item) {
        items.add(item);
    }


    // TODO: implement this
    public boolean containsItem() { return true; }
}
