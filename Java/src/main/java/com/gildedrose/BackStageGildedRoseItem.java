package com.gildedrose;

public class BackStageGildedRoseItem extends GildedRoseItem
{
    public BackStageGildedRoseItem(Item item) {
        super(item);
    }

    @Override
    void updateQuality() {
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
