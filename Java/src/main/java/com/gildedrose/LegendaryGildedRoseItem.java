package com.gildedrose;

public class LegendaryGildedRoseItem extends GildedRoseItem {
    public LegendaryGildedRoseItem(Item item) {
        super(item);
    }

    /**
     *  "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
     */
    @Override
    void updateQuality() {
        //do nothing.
    }

    @Override
    void updateSellIn() {
        //do nothing.
    }
}
