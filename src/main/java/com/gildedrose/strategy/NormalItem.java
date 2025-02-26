package com.gildedrose.strategy;

import com.gildedrose.Item;

public class NormalItem implements UpdateItem{
  
  @Override
  public void updateItemStrategy(Item item){
    if(item.quality>0){
      item.quality--;
      item.sellIn--;
      if(item.sellIn<0) 
        item.quality=Math.max(0,--item.quality);
      }
  }
}
