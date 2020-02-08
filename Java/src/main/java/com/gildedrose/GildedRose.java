package com.gildedrose;

class GildedRose {
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