package com.gildedrose.gildedroseitems;

import com.gildedrose.Item;

public class LegendaryGildedRoseItem extends GildedRoseItem {
    public LegendaryGildedRoseItem(Item item) {
        super(item);
    }

    /**
     *  "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
     */
    @Override
    public void updateQuality() {
        //do nothing.
    }

    @Override
    public void updateSellIn() {
        //do nothing.
    }
}
