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
  private CurrentGameMessage currentGameMessage;
  private GameMap gameMap;
  private List<UIStatus> statusMessages;
  
  /*
   * Initialize with an empty List
   */
  public UIState(GameMap gameMap){
    this.gameMap = gameMap;
    this.menuMap = new HashMap<UIMenuType,UIMenu>();
    this.gameMessages = new ArrayList<GameMessage>();
    this.statusMessages = new ArrayList<UIStatus>();
    this.currentGameMessage = new CurrentGameMessage("");
  }
  
  /*
   * Initialize with given list and gameMap
   */
  public UIState(GameMap gameMap, HashMap<UIMenuType,UIMenu> menuList, List<GameMessage> gameMessages, CurrentGameMessage currentGameMessage, List<UIStatus> statusMessages){
    this.menuMap = menuList;
    this.gameMap = gameMap;
    this.gameMessages = gameMessages;
    this.currentGameMessage=currentGameMessage;
    this.statusMessages = statusMessages;
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
   * set the gameMap
   */
  public void setGameMap(GameMap gameMap) {
    this.gameMap = gameMap;
  }
  
  /**
   * @return the gameMessages
   */
  public List<GameMessage> getGameMessages() {
    return gameMessages;
  }
  
  public CurrentGameMessage getCurrentGameMessage(){
    return currentGameMessage;
  }
  
  public void setCurrentGameMessage(CurrentGameMessage currentGameMessage){
    this.currentGameMessage = currentGameMessage;
  }
    
    public List<UIStatus> getStatusMessages() {
        return statusMessages;
      }

}
