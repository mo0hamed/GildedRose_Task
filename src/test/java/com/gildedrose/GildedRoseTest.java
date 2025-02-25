package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

private static final String AGED_BRIE = "Aged Brie";
private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
private static final String NORMAL_ITEM = "Normal item";

////////////////////////////////////Aged_Brie/////////////////////////////////////////////
    @Test
    void assertThatAgedQualityNeverMoreThan50() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 10, 50),new Item(AGED_BRIE, 10, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(50, app.items[1].quality);
    }

    @Test
    void assertThatAgedQualityIncreasingByOne() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 10, 0),new Item(AGED_BRIE, 10, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
        assertEquals(2, app.items[1].quality);
    }

    @Test
    void assertThatIfAgedSellInEqualZeroQualityIncreaseTwiceAndSellInWillBeNegative() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }

////////////////////////////////////Backstage passes to a TAFKAL80ETC concert/////////////////////////////////////////////
    @Test
    void assertThatBackstageQualityNeverMoreThan50() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 10, 50),new Item(BACKSTAGE_PASSES, 10, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(50, app.items[1].quality);
    }
    
    @Test
    void assertThatBackstageSellInAlwaysDecreasesByOne() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 11, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
    }

    @Test
    void assertThatBackstageQualityIncreasingOnceWhenSellInGreaterThan11() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 11, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }
    
    @Test
    void assertThatBackstageIncreasingTwiceInQualityWhenSellInLessThan11AndGreaterThan6AndSellInDecreasesByOne() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 9, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void assertThatBackstageIncreasingTwiceInQualityWhenSellInEqual6AndSellInDecreasesByOne() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 6, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void assertThatBackstageIncreasingThreeTimesInQualityWhenSellInLessThan6AndSellInDecreasesByOne() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 5, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);
    }

    @Test
    void assertThatIfBackstageSellInEqualZeroThenQualityWillBeZeroAndSellInWillBeNegative() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

////////////////////////////////////Sulfuras, Hand of Ragnaros/////////////////////////////////////////////
    @Test
    void assertThatIfSulfurasIsLegendaryItem() {
        Item[] items = new Item[] { new Item(SULFURAS, 0, 0),new Item(SULFURAS, 0, 50),new Item(SULFURAS, 20, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
        assertEquals(0, app.items[1].sellIn);
        assertEquals(50, app.items[1].quality);
        assertEquals(20, app.items[2].sellIn);
        assertEquals(30, app.items[2].quality);
    }

////////////////////////////////////Normal_item/////////////////////////////////////////////
    @Test
    void assertThatNormalItemQualityNeverNegative() {
        Item[] items = new Item[] { new Item(NORMAL_ITEM, 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
    
    @Test
    void assertThatNormalItemQualityAlwaysDecreaseByOneIfSellInGreaterThanZero() {
        Item[] items = new Item[] { new Item(NORMAL_ITEM, 1, 50), new Item(NORMAL_ITEM, 2, 0), new Item(NORMAL_ITEM, 3, 1), new Item(NORMAL_ITEM, 3, 7)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(49, app.items[0].quality);
        assertEquals(0, app.items[1].quality);
        assertEquals(0, app.items[2].quality);
        assertEquals(6, app.items[3].quality);
    }

    @Test
    void assertThatNormalItemQualityAlwaysDecreaseTwiceIfSellInEqualZero() {
        Item[] items = new Item[] { new Item(NORMAL_ITEM, 0, 50), new Item(NORMAL_ITEM, 0, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(48, app.items[0].quality);
        assertEquals(3, app.items[1].quality);
    }

    @Test
    void assertThatNormalItemSellInAlwaysDecreaseByOne() {
        Item[] items = new Item[] { new Item(NORMAL_ITEM, 0, 50), new Item(NORMAL_ITEM, 3, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(2, app.items[1].sellIn);
    }



}
