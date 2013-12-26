package com.frontend;

/*
 * Defines elements of a GameMap 
 */
public class GameMapEntry {
  
  public char symbol;
  public GameMapEntryColor color;
  public GameMapEntryAttribute attribute;
  
  public GameMapEntry(char symbol, GameMapEntryColor color, GameMapEntryAttribute attribute){
   this.symbol=symbol;
   this.color=color;
   this.attribute=attribute;
  }
  
  /*
   * copy constructor
   */
  public GameMapEntry(GameMapEntry other){
   this.symbol=other.symbol;
   this.color=other.color;
   this.attribute=other.attribute;
  }
  
}
