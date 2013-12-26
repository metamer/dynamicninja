package com.frontend;

public class ArrayGameMap implements GameMap {

  private GameMapEntry[][] gameMapArray;
  private int height, width;
  private GameMapEntry defaultGameMapEntry;
  
  public ArrayGameMap(int height, int width){
   gameMapArray = new GameMapEntry[height][width];
   this.height = height;
   this.width = width;
  }
  
  public ArrayGameMap(int height, int width, GameMapEntry defaultGameMapEntry){
    this(height,width);
    this.defaultGameMapEntry=defaultGameMapEntry;
   }
  
  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public GameMapEntry getObjectAt(int row, int column) {
    
    //if defaultGameMapEntry is defined and gamemaparray is null, return default
    if(defaultGameMapEntry != null && gameMapArray[row][column] == null ){
      return defaultGameMapEntry;
    }
    
    return gameMapArray[row][column];
  }

  @Override
  public void setObjectAt(int row, int column, GameMapEntry entryToSet) {
    gameMapArray[row][column] = entryToSet;
    
  }

}
