package io.muic.ssc.assn.a3.zork.item;

import io.muic.ssc.assn.a3.zork.item.impl.*;

public enum ItemType {
    // TODO: add items
    // TODO: implement this
    SWORD("sword", Sword.class),
    BOW("bow", Bow.class),
    LUCK_GRENADE("luck grenade", LuckGrenade.class),
    ATTACK_POTION("attack potion", AttackPotion.class),
    HP_POTION("hp potion", HpPotion.class),
    STORAGE_SPACE("storage space", StorageSpace.class);

    String item;
    Class<? extends Item> itemClass;

    ItemType(String item, Class<? extends Item> itemClass) {
        this.item = item;
        this.itemClass = itemClass;
    }

    public String getItem() { return item; }
    public Class<? extends Item> getItemClass() { return itemClass; }

}
