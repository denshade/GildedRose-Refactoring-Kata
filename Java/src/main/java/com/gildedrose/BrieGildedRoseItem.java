package com.gildedrose;

public class BrieGildedRoseItem extends GildedRoseItem
{
    public BrieGildedRoseItem(Item item) {
        super(item);
    }

    @Override
    void updateQuality() {
        increaseQualityWithSaturation(item);
    }

}
