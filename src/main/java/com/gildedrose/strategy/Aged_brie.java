package com.gildedrose.strategy;

import com.gildedrose.Item;

public class Aged_brie implements UpdateItem{
  
  @Override
  public void updateItemStrategy (Item item){
    if(item.quality<50){
      item.quality ++;
    }
    item.sellIn--;
    if (item.sellIn < 0 && item.quality < 50) {
      item.quality++;
  }
  }

}
