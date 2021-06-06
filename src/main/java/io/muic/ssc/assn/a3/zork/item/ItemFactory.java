package io.muic.ssc.assn.a3.zork.item;

import java.util.HashMap;
import java.util.Map;

public class ItemFactory {
    private static final Map<String, ItemType> ITEM_LOOKUP = new HashMap<>();

    static {{
        for (ItemType itemType : ItemType.values()) {
            ITEM_LOOKUP.put(itemType.getItem(), itemType);
        }
    }}

    public static ItemType getItemType(String item) {
        return ITEM_LOOKUP.getOrDefault(item, null);
    }
}
