package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item currentItem : items) {
            if (hasDecreasingQuality(currentItem)) {
                if (currentItem.quality > 0) {
                    if (!isSulfuras(currentItem)) {
                        currentItem.quality = currentItem.quality - 1;
                    }
                }
            } else {
                if (currentItem.quality < 50) {
                    currentItem.quality = currentItem.quality + 1;

                    if (isBackStagePass(currentItem)) {
                        processBackstage(currentItem);
                    }
                }
            }

            if (!isSulfuras(currentItem)) {
                currentItem.sellIn = currentItem.sellIn - 1;
            }

            if (currentItem.sellIn < 0) {
                if (!isAgedBrie(currentItem)) {
                    if (!isBackStagePass(currentItem)) {
                        if (currentItem.quality > 0) {
                            if (!isSulfuras(currentItem)) {
                                currentItem.quality = currentItem.quality - 1;
                            }
                        }
                    } else {
                        currentItem.quality = 0;
                    }
                } else {
                    if (currentItem.quality < 50) {
                        currentItem.quality = currentItem.quality + 1;
                    }
                }
            }
        }
    }

    private boolean hasDecreasingQuality(Item currentItem) {
        return !isAgedBrie(currentItem)
                && !isBackStagePass(currentItem);
    }

    private void processBackstage(Item currentItem) {
        if (currentItem.sellIn < 11) {
            if (currentItem.quality < 50) {
                currentItem.quality = currentItem.quality + 1;
            }
        }

        if (currentItem.sellIn < 6) {
            if (currentItem.quality < 50) {
                currentItem.quality = currentItem.quality + 1;
            }
        }
    }

    private boolean isSulfuras(Item currentItem) {
        return currentItem.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackStagePass(Item currentItem) {
        return currentItem.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie(Item currentItem) {
        return currentItem.name.equals("Aged Brie");
    }
}