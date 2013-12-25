package com.frontend;

public class ArrayGameMap implements GameMap {

  private GameMapObject[][] gameMapArray;
  private int xDim, yDim;
  
  public ArrayGameMap(int width, int height){
   gameMapArray = new GameMapObject[width][height];
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
  public GameMapObject getObjectAt(int x, int y) {
    
    return gameMapArray[x][y];
  }

}
