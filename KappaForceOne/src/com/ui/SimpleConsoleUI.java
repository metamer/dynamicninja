/**
 * 
 */
package com.ui;

import java.util.List;

import com.all.GameMessage;
import com.frontend.*;

/**
 * @author insidiousnoxious
 *
 */
public class SimpleConsoleUI implements UI {

  /* (non-Javadoc)
   * @see com.ui.UI#drawCurrentState()
   */
  @Override
  public void drawUIState(UIState uiState) {
    
    GameMap gm = uiState.getGameMap();
    
    boolean isFirst = true;
    
    for( UIMenuType key : uiState.getMenuList().keySet()){
      UIMenu uim = uiState.getMenuList().get(key);
        if(!isFirst){
          System.out.print(",");
        }
        else{
          isFirst = false;
        }
        System.out.print(uim.getName());
    }
    
    System.out.println();
    
    for(int row = 0 ; row < gm.getHeight() ; row++){
      for(int col = 0 ; col < gm.getWidth() ; col++){
        System.out.print(gm.getObjectAt(row, col).getSymbol());
      }
      System.out.println();
    }
    
    List<GameMessage> lgm = uiState.getGameMessages(); 
    
    for(int i = 0 ; i< lgm.size() ; i++  ){
      int listIndex =lgm.size() -  i - 1;
      System.out.println("Message " + (listIndex+1) + ":" + lgm.get(listIndex).getMessageText());
    }
  }

  /* (non-Javadoc)
   * @see com.ui.UI#getUserAction()
   */
  @Override
  public UserAction getUserAction() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException();
  }

  /* (non-Javadoc)
   * @see com.ui.UI#setUIState(com.frontend.UIState)
   */
  @Override
  public void setUIState(UIState uiState) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException();
  }

}
