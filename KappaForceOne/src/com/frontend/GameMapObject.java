package com.frontend;

/*
 * Defines elements of a GameMap 
 */
public class GameMapObject {
  
  public char symbol;
  public GameMapObjectColor color;
  public GameMapObjectAttribute attribute;
  
  public GameMapObject(char symbol, GameMapObjectColor color, GameMapObjectAttribute attribute){
   this.symbol=symbol;
   this.color=color;
   this.attribute=attribute;
  }
  
  /*
   * copy constructor
   */
  public GameMapObject(GameMapObject other){
   this.symbol=other.symbol;
   this.color=other.color;
   this.attribute=other.attribute;
  }
  
}
