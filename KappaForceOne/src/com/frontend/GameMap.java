package com.frontend;

public interface GameMap {
  
  public int height();

  public int width();
  
  public GameMapObject getObjectAt(int width, int height);
  
}
