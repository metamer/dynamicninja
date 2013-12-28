package com.frontend;

/**
 * Defines elements of a GameMap 
 **/
public class GameMapEntry {
  
  private char symbol;
  private GameMapEntryColor foregroundColor;
  private GameMapEntryColor backgroundColor;
  private GameMapEntryAttribute attribute;
  
  public GameMapEntry(char symbol, GameMapEntryColor foregroundColor,
      GameMapEntryColor backgroundColor, GameMapEntryAttribute attribute){
   this.symbol=symbol;
   this.foregroundColor=foregroundColor;
   this.backgroundColor=backgroundColor;
   this.attribute=attribute;
  }
  
  /*
   * copy constructor
   */
  public GameMapEntry(GameMapEntry other){
   this(other.symbol,other.foregroundColor,other.backgroundColor,other.attribute);
  }
  
  //accessor methods
  public char getSymbol(){
    return symbol;
  }
  
  public GameMapEntryColor getForegroundColor(){
    return foregroundColor;
  }
  

  public GameMapEntryColor getBackgroundColor(){
    return backgroundColor;
  }
  
  public GameMapEntryAttribute getAttribute(){
    return attribute;
  }
  
}
