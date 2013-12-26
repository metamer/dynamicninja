/**
 * 
 */
package com.frontend;

import com.all.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author insidiousnoxious
 *
 */
public class UIState {
  
  private List<UIMenu> menuList;
  private List<GameMessage> gameMessages;
  private GameMap gameMap;
  
  /*
   * Initialize with an empty List
   */
  public UIState(GameMap gameMap){
    this.gameMap = gameMap;
    this.menuList = new ArrayList<UIMenu>();
    this.gameMessages = new ArrayList<GameMessage>();
  }
  
  /*
   * Initialize with given list and gameMap
   */
  public UIState(GameMap gameMap, List<UIMenu> menuList, List<GameMessage> gameMessages){
    this.menuList = menuList;
    this.gameMap = gameMap;
    this.gameMessages = gameMessages;
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
  
  /**
   * @return the gameMessages
   */
  public List<GameMessage> getGameMessages() {
    return gameMessages;
  }
  

}
