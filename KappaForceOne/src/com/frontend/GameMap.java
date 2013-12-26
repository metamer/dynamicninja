package com.frontend;

public interface GameMap {
  
  public int height();

  public int width();
  
  public GameMapEntry getObjectAt(int width, int height);
  
}
