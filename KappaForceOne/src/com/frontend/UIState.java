/**
 * 
 */
package com.frontend;

import com.all.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author insidiousnoxious
 * State that is passed from Runner to UI
 */
public class UIState {
  
  private Map<UIMenuType,UIMenu> menuMap;
  private List<GameMessage> gameMessages;
  private GameMap gameMap;
  
  /*
   * Initialize with an empty List
   */
  public UIState(GameMap gameMap){
    this.gameMap = gameMap;
    this.menuMap = new HashMap<UIMenuType,UIMenu>();
    this.gameMessages = new ArrayList<GameMessage>();
  }
  
  /*
   * Initialize with given list and gameMap
   */
  public UIState(GameMap gameMap, HashMap<UIMenuType,UIMenu> menuList, List<GameMessage> gameMessages){
    this.menuMap = menuList;
    this.gameMap = gameMap;
    this.gameMessages = gameMessages;
  }
  
  /**
   * @return the menuMap
   */
  public Map<UIMenuType,UIMenu> getMenuMap() {
    return menuMap;
  }
  
  public void addMenu(UIMenuType umt, UIMenu um){
    menuMap.put(umt, um);    
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
