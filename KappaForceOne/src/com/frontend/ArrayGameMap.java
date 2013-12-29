/**
 * Implementation of GameMap using an Array
 */
package com.frontend;

public class ArrayGameMap implements GameMap {

  private GameMapEntry[][] gameMapArray;
  private int height, width;
  private GameMapEntry defaultGameMapEntry;
  
  /**
   * Initialize new ArrayGameMap with all elements null
   * @param height Height of map
   * @param width Width of map
   */
  public ArrayGameMap(int height, int width){
   gameMapArray = new GameMapEntry[height][width];
   this.height = height;
   this.width = width;
  }
  
  /**
   * Initialize new ArrayGameMap with default
   * @param height Height of map
   * @param width Width of map
   * @param defaultGameMapEntry GameMapEntry object to default to if none stored at location. If this is null, then no default will be set
   */
  public ArrayGameMap(int height, int width, GameMapEntry defaultGameMapEntry){
    this(height,width);
    this.defaultGameMapEntry=defaultGameMapEntry;
   }

  /**
   * Copy constructor for other ArrayGameMaps. Performs deep copy. 
   * Should be more efficient than GameMap copy constructor due to special handling of defaultGameMapEntry
   * @param other ArrayGameMap to deep copy
   */
  public ArrayGameMap(ArrayGameMap other){
    this(other.height,other.width);
    if(other.defaultGameMapEntry != null){
      this.defaultGameMapEntry = new GameMapEntry(other.defaultGameMapEntry);
    }
    
    for(int row = 0; row < height; row++){
      for(int column = 0; column < width; column++){
        //only copy those items where object is not null and default would not be used
        if(other.getObjectAt(row, column) != null &&  !other.useDefaultGameMapEntryAt(row, column)){
          this.setObjectAt(row, column, new GameMapEntry(other.getObjectAt(row,column)));
        }
      }
    }
    
  }
  
  /**
   * Copy constructor for GameMaps. Performs deep copy.
   * @param other GameMap to deep copy
   */
  public ArrayGameMap(GameMap other){
    this(other.getHeight(),other.getWidth());
    for(int row = 0; row < height; row++){
      for(int column = 0; column < width; column++){
        if(other.getObjectAt(row,column) != null){
        this.setObjectAt(row, column, new GameMapEntry(other.getObjectAt(row,column)));
        }
      }
    }
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
    

    if(useDefaultGameMapEntryAt(row,column)){
      return defaultGameMapEntry;
    }
    
    return gameMapArray[row][column];
  }

  @Override
  public void setObjectAt(int row, int column, GameMapEntry entryToSet) {
    gameMapArray[row][column] = entryToSet;
    
  }
  
  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
        return false;
    }
    if (getClass() != obj.getClass()) {
        return false;
    }
    final ArrayGameMap other = (ArrayGameMap) obj;
  
    if (this.getHeight() != other.getHeight()) {
        return false;
    }

    if (this.getWidth() != other.getWidth()) {
        return false;
    }
    
    if ((this.defaultGameMapEntry == null) ? (other.defaultGameMapEntry != null) : !this.defaultGameMapEntry.equals(other.defaultGameMapEntry)) {
      return false;
    }
    
    
    for(int row = 0; row < this.height ; row++){
      for (int column = 0; column< this.width ; column++){
        if ((this.getObjectAt(row, column) == null) ? (other.getObjectAt(row, column) != null) : !this.getObjectAt(row, column).equals(other.getObjectAt(row, column))) {
          return false;
        }
      }
    }
    
    return true;
  }
  
  /**
   * Determine if defaultGameMapEntry should be returned for the input coordinates
   * @param row 
   * @param column
   * @return true if object returned is defaultGameMapEntry
   */
  private boolean useDefaultGameMapEntryAt(int row, int column){
    //if defaultGameMapEntry is defined and gameMapArray is null, use default
    return ( defaultGameMapEntry != null && gameMapArray[row][column] == null );
  }

}
