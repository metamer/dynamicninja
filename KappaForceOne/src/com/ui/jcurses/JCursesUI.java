package com.ui.jcurses;

import com.all.CurrentGameMessage;
import com.all.GameMessage;
import com.frontend.GameMap;
import com.frontend.GameMapEntry;
import com.frontend.GameMapEntryColor;
import com.frontend.UIMenuType;
import com.frontend.UIState;
import com.frontend.UserAction;
import com.frontend.UIMenu;
import com.ui.UI;
import com.ui.UIMenuTypeComparator;

import jcurses.system.*;
import jcurses.widgets.*;
import jcurses.util.*;
import jcurses.event.*;

import java.awt.Rectangle;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class JCursesUI extends Window implements UI {

  private List messageList = null, currentMessageList= null;
  private final int MESSAGE_LIMIT = 5;
  
  private java.util.List<Button> menuList;
  private Map<Button,UIMenuType> buttonToMenuTypeMap = new HashMap<Button,UIMenuType>();
  BorderPanel buttonPanel, gameMapPanel;
  
  private final static CharColor shortCutColor = new CharColor(CharColor.RED,CharColor.BLACK);

  
  private static final Map<GameMapEntryColor, Short> COLOR_MAP = new HashMap<GameMapEntryColor,Short>(){{
    put(GameMapEntryColor.BLUE, CharColor.BLUE);
    put(GameMapEntryColor.CYAN, CharColor.CYAN);
    put(GameMapEntryColor.GREEN, CharColor.GREEN);
    put(GameMapEntryColor.MAGENTA, CharColor.MAGENTA);
    put(GameMapEntryColor.RED, CharColor.RED);
    put(GameMapEntryColor.YELLOW, CharColor.YELLOW);
    put(GameMapEntryColor.WHITE, CharColor.WHITE);
    put(GameMapEntryColor.BLACK, CharColor.BLACK);
}};
  
  public JCursesUI(int width, int height){
    super(width,height, true, "Game");
        
    GridLayoutManager mainWindowManager = new GridLayoutManager(10,10);
    getRootPanel().setLayoutManager(mainWindowManager);

    buttonPanel = new BorderPanel();
    messageList = new List(MESSAGE_LIMIT);
    messageList.setTitle("Messages");
    
    currentMessageList = new List(MESSAGE_LIMIT);
    currentMessageList.setTitle("Current Message");
    
    gameMapPanel = new BorderPanel(80,20);

    mainWindowManager.addWidget(buttonPanel, 0,0,10,1, WidgetsConstants.ALIGNMENT_TOP, WidgetsConstants.ALIGNMENT_LEFT);
    mainWindowManager.addWidget(gameMapPanel, 0,1,5,9, WidgetsConstants.ALIGNMENT_CENTER, WidgetsConstants.ALIGNMENT_CENTER);
    mainWindowManager.addWidget(messageList, 5,1,5,3, WidgetsConstants.ALIGNMENT_TOP, WidgetsConstants.ALIGNMENT_LEFT);
    mainWindowManager.addWidget(currentMessageList, 5,4,5,5, WidgetsConstants.ALIGNMENT_TOP, WidgetsConstants.ALIGNMENT_LEFT);
    

    this.pack();
    this.show();
    
  }

  @Override
  public void drawUIState(UIState uiState) {
    // TODO Auto-generated method stub
    

    populateMenus(uiState.getMenuMap());
    populateMessageList(uiState.getGameMessages());
    populateCurrentMessage(uiState.getCurrentGameMessage());
    populateGameMap(uiState.getGameMap());
    this.pack();
    this.repaint();
  }

  @Override
  public UserAction getUserAction() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setUIState(UIState uiState) {
    // TODO Auto-generated method stub

  }
  
  private void populateCurrentMessage(CurrentGameMessage currentGameMessage) {
    currentMessageList.clear();
    for(String s : currentGameMessage.getMessageText().split(String.format("%s",System.getProperty("line.separator")))){
      currentMessageList.add(s);
    }
    
  }

  private void populateMenus(Map<UIMenuType,UIMenu> menuMap){
    
    menuList = new ArrayList<Button>();

    buttonToMenuTypeMap = new HashMap<Button,UIMenuType>();
    java.util.List<UIMenuType> availableMenuTypes = new ArrayList<UIMenuType>(menuMap.keySet());
    Collections.sort(availableMenuTypes, new UIMenuTypeComparator());
    for( UIMenuType umt : availableMenuTypes){
      UIMenu val = menuMap.get(umt);
      if(val != null){
        Button b = new Button(val.getName());
        
        if(val.getHotkey() != null){
          b.setShortCut(val.getHotkey());
          //b.setShortCutColors(shortCutColor);
        }
        
        buttonToMenuTypeMap.put(b,umt);
        menuList.add(b);
      }
    }
    
    GridLayoutManager gm = new GridLayoutManager(menuList.size(),1);
    buttonPanel.setLayoutManager(gm);

    int i = 0;
    for(Button b : menuList){
      if(b != null){
        gm.addWidget(b, i, 0, 1, 1,WidgetsConstants.ALIGNMENT_TOP,WidgetsConstants.ALIGNMENT_LEFT);
        i++;
      }
    }
  }
  
  private void populateMessageList(java.util.List<GameMessage> lgm){
       
    messageList.clear();
    
    int addedMessages=0;
    for(int i = lgm.size() - 1; i >= 0 ; i--){
      if(lgm.get(i) != null){
        messageList.add(lgm.get(i).getMessageText());
        addedMessages++;
      }
      if(addedMessages >= MESSAGE_LIMIT){
        break;
      }
    }
    
    
  }
  
  private void populateGameMap(GameMap gmap){
    int mapHeight = gmap.getHeight();
    int mapWidth = gmap.getWidth();
    DefaultLayoutManager gm = new DefaultLayoutManager();
      
    gameMapPanel.setLayoutManager(gm);
    
    for(int row = 0 ; row < mapHeight ; row++){
      for(int col = 0 ; col < mapWidth ; col++){
        GameMapEntry gme = gmap.getObjectAt(row, col);
        
        Label l = new Label(Character.toString(gme.getSymbol()),new CharColor(COLOR_MAP.get(gme.getForegroundColor()),COLOR_MAP.get(gme.getBackgroundColor())));
        gm.addWidget(l, col, row, 1, 1, WidgetsConstants.ALIGNMENT_TOP, WidgetsConstants.ALIGNMENT_TOP);
        
      }
    }
    
  }

}

