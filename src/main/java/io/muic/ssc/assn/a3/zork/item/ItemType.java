package io.muic.ssc.assn.a3.zork.item;

import io.muic.ssc.assn.a3.zork.item.impl.DefaultItem;

import java.lang.reflect.InvocationTargetException;

public enum ItemType {
    // TODO: add items
    // TODO: implement this
    DEFAULT(null, DefaultItem.class);

    String item;
    Item itemInstance;

    ItemType(String item, Class<? extends Item> itemClass) {
        this.item = item;
        try {
            itemInstance = itemClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public String getItem() { return item; }
    public Item getItemInstance() { return itemInstance; }

}
