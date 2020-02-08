package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void updateQualityLowersBothValuesRegularItem()
    {
        Item[] items = new Item[] { new Item("foo", 3, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void QualityNeverNegative()
    {
        Item[] items = new Item[] { new Item("foo", 3, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void AgedBrieIncreasesQuality()
    {
        Item[] items = new Item[] { new Item("Aged Brie", 3, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);
    }

    @Test
    void AgedBrieQualityNeverHigherThan50()
    {
        Item[] items = new Item[] { new Item("Aged Brie", 3, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void LegendaryItemNeverHasToBeSoldDecreasesQuality()
    {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 3, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].sellIn);
        assertEquals(30, app.items[0].quality);
    }


    @Test
    void sellDatePassedQualityDegradesTwiceAsFast()
    {
        Item[] items = new Item[] { new Item("foo", -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void BackstagePasses()
    {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 12, 10),//Increases in quality like brie
                new Item("Backstage passes to a TAFKAL80ETC concert", 8, 10), //Quality increases by 2 when there are 10 days
                new Item("Backstage passes to a TAFKAL80ETC concert", 4, 10), // by 3 when there are 5 days
                new Item("Backstage passes to a TAFKAL80ETC concert", -1, 10) //Quality drops to 0 after the concert
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
        assertEquals(12, app.items[1].quality);
        assertEquals(13, app.items[2].quality);
        assertEquals(0, app.items[3].quality);
    }

    @Test
    void conjuredItemsDegradeQualityTwiceAsFast()
    {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 3, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }
}
