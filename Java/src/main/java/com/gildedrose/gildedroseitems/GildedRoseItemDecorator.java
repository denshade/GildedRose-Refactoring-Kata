package com.gildedrose.gildedroseitems;

import com.gildedrose.Item;

public class GildedRoseItemDecorator
{
    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    public GildedRoseItem decorateItem(Item currentItem) {
        GildedRoseItem roseItem;
        if (isAgedBrie(currentItem))
        {
            roseItem = new BrieGildedRoseItem(currentItem);
        } else if (isLegendary(currentItem))
        {
            roseItem = new LegendaryGildedRoseItem(currentItem);
        } else if (isBackStagePass(currentItem))
        {
            roseItem = new BackStageGildedRoseItem(currentItem);
        } else {
            roseItem = new RegularGildedRoseItem(currentItem);
        }
        return roseItem;
    }

    private boolean isLegendary(Item currentItem) {
        return currentItem.name.equals(HAND_OF_RAGNAROS);
    }

    private boolean isBackStagePass(Item currentItem) {
        return currentItem.name.equals(BACKSTAGE_PASS);
    }

    private boolean isAgedBrie(Item currentItem) {
        return currentItem.name.equals(AGED_BRIE);
    }
}
