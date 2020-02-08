package com.gildedrose.gildedroseitems;

import com.gildedrose.Item;

public class BackStageGildedRoseItem extends GildedRoseItem
{
    public BackStageGildedRoseItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
    increaseQualityWithSaturation(item);
        if (item.sellIn < 11) {
            increaseQualityWithSaturation(item);
        }

        if (item.sellIn < 6) {
            increaseQualityWithSaturation(item);
        }
        if (item.sellIn < 1){
            item.quality = 0;
        }
    }

}
