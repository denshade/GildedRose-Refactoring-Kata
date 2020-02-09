package com.gildedrose.gildedroseitems;

import com.gildedrose.Item;

abstract public class GildedRoseItem
{
    private static final int SATURATIONMAX = 50;
    protected final Item item;

    /**
     *
     * @param item item to be considered as a gilder rose item. Must not have name == null
     */
    public GildedRoseItem(Item item) {
        if (item.name == null){
            throw new IllegalArgumentException("Name must not be empty");
        }
        if (item.quality > SATURATIONMAX){
            throw new IllegalArgumentException("item quality must not be bigger than " + SATURATIONMAX + " actual: " + item.quality);
        }
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
