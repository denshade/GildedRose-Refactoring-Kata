package com.gildedrose;

import com.gildedrose.gildedroseitems.GildedRoseItem;
import com.gildedrose.gildedroseitems.GildedRoseItemDecorator;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        GildedRoseItemDecorator decorator = new GildedRoseItemDecorator();
        for (Item currentItem : items) {
            GildedRoseItem roseItem = decorator.decorateItem(currentItem);
            roseItem.update();
        }
    }


}