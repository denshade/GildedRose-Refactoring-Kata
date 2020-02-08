package com.gildedrose;

class GildedRose {
    public static final int SATURATIONMAX = 50;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item currentItem : items) {
            GildedRoseItem roseItem = decorateItem(currentItem);
            roseItem.updateQuality();
            roseItem.updateSellIn();
        }
    }

    private GildedRoseItem decorateItem(Item currentItem) {
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
        return currentItem.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackStagePass(Item currentItem) {
        return currentItem.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie(Item currentItem) {
        return currentItem.name.equals("Aged Brie");
    }
}