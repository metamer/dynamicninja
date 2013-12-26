package com.frontend;

/*
 * Defines elements of a GameMap 
 */
public class GameMapEntry {
  
  private char symbol;
  private GameMapEntryColor color;
  private GameMapEntryAttribute attribute;
  
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
  
  //accessor methods
  
  public char getSymbol(){
    return symbol;
  }
  
  public GameMapEntryColor getColor(){
    return color;
  }
  
  public GameMapEntryAttribute getAttribute(){
    return attribute;
  }
  
}
