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
      GameMapEntryColor backgroundColor, GameMapEntryAttribute attribute) {
    this.symbol = symbol;
    this.foregroundColor = foregroundColor;
    this.backgroundColor = backgroundColor;
    this.attribute = attribute;
  }

  /*
   * copy constructor
   */
  public GameMapEntry(GameMapEntry other) {
    this(other.symbol, other.foregroundColor, other.backgroundColor, other.attribute);
  }

  // accessor methods
  public char getSymbol() {
    return symbol;
  }

  public GameMapEntryColor getForegroundColor() {
    return foregroundColor;
  }

  public GameMapEntryColor getBackgroundColor() {
    return backgroundColor;
  }

  public GameMapEntryAttribute getAttribute() {
    return attribute;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final GameMapEntry other = (GameMapEntry) obj;

    if (this.getSymbol() != other.getSymbol()) {
      return false;
    }

    if (this.getBackgroundColor() != other.getBackgroundColor()) {
      return false;
    }

    if (this.getForegroundColor() != other.getForegroundColor()) {
      return false;
    }

    if (this.getAttribute() != other.getAttribute()) {
      return false;
    }
    return true;
  }

}
