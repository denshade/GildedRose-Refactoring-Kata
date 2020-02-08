package com.gildedrose;

public class RegularGildedRoseItem extends GildedRoseItem {
    public RegularGildedRoseItem(Item item) {
        super(item);
    }

    /**
     * 	- All items have a SellIn value which denotes the number of days we have to sell the item
     * 	- All items have a Quality value which denotes how valuable the item is
     * 	- At the end of each day our system lowers both values for every item
     *
     * Once the sell by date has passed, Quality degrades twice as fast
     */
    @Override
    void updateQuality() {
        decreaseQualityUntilZero(item);
        if (itemExpired(item)) {
            decreaseQualityUntilZero(item);
        }

    }

}
