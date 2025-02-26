package com.gildedrose.strategy;

import com.gildedrose.Item;

public class Sulfuras implements UpdateItem {
  @Override
  public void updateItemStrategy(Item item){
    item.quality=80;
  }
}
