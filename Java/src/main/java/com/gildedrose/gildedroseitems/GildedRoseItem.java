package com.gildedrose.gildedroseitems;

import com.gildedrose.Item;

abstract public class GildedRoseItem
{
    private static final int SATURATIONMAX = 50;
    protected final Item item;

    public GildedRoseItem(Item item) {
        this.item = item;
    }

    public abstract void updateQuality();
    public void updateSellIn(){
        item.sellIn--;
    }

    public void update()
    {
        updateQuality();
        updateSellIn();
    }

    protected void decreaseQualityUntilZero(Item currentItem) {
        if (currentItem.quality > 0) {
            currentItem.quality = currentItem.quality - 1;
        }
    }
    protected void increaseQualityWithSaturation(Item currentItem) {
        if (currentItem.quality < SATURATIONMAX) {
            currentItem.quality = currentItem.quality + 1;
        }
    }

    protected boolean itemExpired(Item currentItem) {
        return currentItem.sellIn < 0;
    }


}
