package com.gildedrose.gildedroseitems;

import com.gildedrose.Item;

public class ConjuredRoseItem extends GildedRoseItem
{
    public ConjuredRoseItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        decreaseQualityUntilZero(item);
        decreaseQualityUntilZero(item);
    }
}
