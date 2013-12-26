/**
 * 
 */
package com.frontend;

import java.util.ArrayList;
import java.util.List;

/**
 * @author insidiousnoxious
 *
 */
public class UIState {
  
  private List<UIMenu> menuList; 
  private GameMap gameMap;
  
  /*
   * Initialize with an empty List
   */
  public UIState(GameMap gameMap){
    this.gameMap = gameMap;
    this.menuList = new ArrayList<UIMenu>();
  }
  
  /*
   * Initialize with given list and gameMap
   */
  public UIState(List<UIMenu> menuList, GameMap gameMap){
    this.menuList = menuList;
    this.gameMap = gameMap;
  }
  
  /**
   * @return the menuList
   */
  public List<UIMenu> getMenuList() {
    return menuList;
  }
  /**
   * @return the gameMap
   */
  public GameMap getGameMap() {
    return gameMap;
  }
  
  

}
