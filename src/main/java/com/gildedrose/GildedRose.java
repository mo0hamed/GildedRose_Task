package com.gildedrose;

import com.gildedrose.strategy.Aged_brie;
import com.gildedrose.strategy.Backstage;
import com.gildedrose.strategy.Conjured;
import com.gildedrose.strategy.Normal_Item;
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
                return new Aged_brie();
            case "Backstage passes to a TAFKAL80ETC concert":
                return new Backstage();
            case "Sulfuras, Hand of Ragnaros":
                return new Sulfuras();
            case "Conjured Mana Cake":
                return new Conjured();
            default:
                return new Normal_Item();
        }
    }

    public void updateQuality() {
        for (Item item : items) {
            UpdateItem Item=getUpdateItem(item);
            Item.updateItemStrategy(item);
        }
    }
    
}