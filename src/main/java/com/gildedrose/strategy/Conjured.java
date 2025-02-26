package com.gildedrose.strategy;

import com.gildedrose.Item;

public class Conjured implements UpdateItem {
  @Override
  public void updateItemStrategy(Item item){
    item.quality = Math.max(0, item.quality - 2);
    item.sellIn--;
    if(item.sellIn<0){
      item.quality = Math.max(0, item.quality - 2);
    }
  }
}
