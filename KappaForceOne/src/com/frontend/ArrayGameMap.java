package com.frontend;

public class ArrayGameMap implements GameMap {

  private GameMapEntry[][] gameMapArray;
  private int xDim, yDim;
  
  public ArrayGameMap(int width, int height){
   gameMapArray = new GameMapEntry[width][height];
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
    return gameMapArray[width][height];
  }

}
