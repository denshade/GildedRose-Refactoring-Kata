package com.gildedrose;

class GildedRose {
    public static final int SATURATIONMAX = 50;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        GildedRoseItemDecorator decorator = new GildedRoseItemDecorator();
        for (Item currentItem : items) {
            GildedRoseItem roseItem = decorator.decorateItem(currentItem);
            roseItem.updateQuality();
            roseItem.updateSellIn();
        }
    }


}