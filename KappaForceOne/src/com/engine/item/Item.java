package com.engine.item;

/**
 * Item base class any item should inherit from.
 * 
 * @author Matt
 * 
 */
public class Item {
  // Name of the item.
  private String name;
  // Can something wear it?
  private boolean wearable;
  // Weight of the item
  private double weight;

  public Item(String name, boolean wearable, double weight) {
    this.name = name;
    this.wearable = wearable;
    this.weight = weight;
  }

}
