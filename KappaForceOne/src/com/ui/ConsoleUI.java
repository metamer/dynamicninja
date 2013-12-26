/**
 * 
 */
package com.ui;

import com.frontend.GameMap;
import com.frontend.UIState;
import com.frontend.UserAction;

/**
 * @author insidiousnoxious
 *
 */
public class ConsoleUI implements UI {

  /* (non-Javadoc)
   * @see com.ui.UI#drawCurrentState()
   */
  @Override
  public void drawUIState(UIState uiState) {
    
    GameMap gm = uiState.getGameMap();
    
    for(int row = 0 ; row < gm.getHeight() ; row++){
      for(int col = 0 ; col < gm.getWidth() ; col++){
        System.console().writer().print(gm.getObjectAt(row, col).getSymbol());
      }
      System.console().writer().println("");
    }
    throw new UnsupportedOperationException();

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
