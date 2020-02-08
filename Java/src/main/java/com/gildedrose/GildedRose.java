package com.gildedrose;

class GildedRose {
    public static final int SATURATIONMAX = 50;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item currentItem : items) {
            if (hasDecreasingQuality(currentItem)) {
                if (!isLegendary(currentItem)) {
                    decreaseQualityUntilZero(currentItem);
                }
            } else {
                    increaseQualityWithSaturation(currentItem);
                    if (isBackStagePass(currentItem)) {
                        processBackstage(currentItem);
                    }
            }

            if (!isLegendary(currentItem)) {
                currentItem.sellIn = currentItem.sellIn - 1;
            }

            if (itemExpired(currentItem)) {
                if (!isAgedBrie(currentItem)) {
                    if (!isBackStagePass(currentItem)) {
                        if (!isLegendary(currentItem)) {
                            decreaseQualityUntilZero(currentItem);
                        }
                    } else {
                        currentItem.quality = 0;
                    }
                } else {
                    increaseQualityWithSaturation(currentItem);
                }
            }
        }
    }

    private boolean itemExpired(Item currentItem) {
        return currentItem.sellIn < 0;
    }

    private void decreaseQualityUntilZero(Item currentItem) {
        if (currentItem.quality > 0) {
            currentItem.quality = currentItem.quality - 1;
        }
    }

    private boolean hasDecreasingQuality(Item currentItem) {
        return !isAgedBrie(currentItem)
                && !isBackStagePass(currentItem);
    }

    private void processBackstage(Item currentItem) {
        if (currentItem.sellIn < 11) {
            increaseQualityWithSaturation(currentItem);
        }

        if (currentItem.sellIn < 6) {
            increaseQualityWithSaturation(currentItem);
        }
    }

    private void increaseQualityWithSaturation(Item currentItem) {
        if (currentItem.quality < SATURATIONMAX) {
            currentItem.quality = currentItem.quality + 1;
        }
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