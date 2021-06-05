package io.muic.ssc.assn.a3.zork.item;

import java.util.HashMap;
import java.util.Map;

// TODO: complete
public class ItemFactory {
    // TODO: update this
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
