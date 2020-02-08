package com.gildedrose;

abstract public class GildedRoseItem
{
    private static final int SATURATIONMAX = 50;
    protected final Item item;

    public GildedRoseItem(Item item) {
        this.item = item;
    }

    abstract void updateQuality();
    void updateSellIn(){
        item.sellIn--;
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
