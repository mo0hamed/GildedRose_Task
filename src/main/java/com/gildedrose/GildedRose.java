package com.gildedrose;

import com.gildedrose.strategy.AgedBrie;
import com.gildedrose.strategy.Backstage;
import com.gildedrose.strategy.Conjured;
import com.gildedrose.strategy.NormalItem;
import com.gildedrose.strategy.Sulfuras;
import com.gildedrose.strategy.UpdateItem;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private UpdateItem getUpdateItem(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new AgedBrie();
            case "Backstage passes to a TAFKAL80ETC concert":
                return new Backstage();
            case "Sulfuras, Hand of Ragnaros":
                return new Sulfuras();
            case "Conjured Mana Cake":
                return new Conjured();
            default:
                return new NormalItem();
        }
    }

    public void updateQuality() {
        for (Item item : items) {
            UpdateItem Item=getUpdateItem(item);
            Item.updateItemStrategy(item);
        }
    }
    
}