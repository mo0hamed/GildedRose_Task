package com.gildedrose.strategy;

import com.gildedrose.Item;

public class Backstage implements UpdateItem{
  @Override
  public void updateItemStrategy(Item item){
    if(item.sellIn>=11&&item.quality<50){
      item.quality++;
    }else if (item.sellIn<11&&item.sellIn>=6&&item.quality<50){
      item.quality=Math.min(50,item.quality+2);
    }else{
      item.quality=Math.min(50,item.quality+3);
    }
    item.sellIn--;
    if(item.sellIn<0)
      item.quality=0;
  }
}
