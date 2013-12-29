package com.frontend;

public interface GameMap {
  
  public int getHeight();

  public int getWidth();
  
  public GameMapEntry getObjectAt(int row, int column);
  
  public void setObjectAt(int row, int column, GameMapEntry entryToSet);
  
}
