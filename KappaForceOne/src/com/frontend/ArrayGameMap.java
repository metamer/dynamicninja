package com.frontend;

public class ArrayGameMap implements GameMap {

  private GameMapEntry[][] gameMapArray;
  private int xDim, yDim;
  private GameMapEntry defaultGameMapEntry;
  
  public ArrayGameMap(int width, int height){
   gameMapArray = new GameMapEntry[width][height];
  }
  
  public ArrayGameMap(int width, int height, GameMapEntry defaultGameMapEntry){
    gameMapArray = new GameMapEntry[width][height];
    this.defaultGameMapEntry=defaultGameMapEntry;
   }
  
  @Override
  public int height() {
    return yDim;
  }

  @Override
  public int width() {
    return xDim;
  }

  @Override
  public GameMapEntry getObjectAt(int width, int height) {
    
    //if defaultGameMapEntry is defined and gamemaparray is null, return default
    if(defaultGameMapEntry != null && gameMapArray[width][height] == null ){
      return defaultGameMapEntry;
    }
    
    return gameMapArray[width][height];
  }

  @Override
  public void setObjectAt(int width, int height, GameMapEntry entryToSet) {
    gameMapArray[width][height] = entryToSet;
    
  }

}
