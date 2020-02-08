package com.gildedrose.gildedroseitems;

import com.gildedrose.Item;

public class BrieGildedRoseItem extends GildedRoseItem
{
    public BrieGildedRoseItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        increaseQualityWithSaturation(item);
    }

}
