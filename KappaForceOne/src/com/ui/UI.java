package com.ui;

import com.frontend.*;
import com.all.*;

/*
 * Runner interacts with classes that implement UI to request the next user action and to update the display 
 */
public interface UI {
  
  /*
   * Draw the currently set UIState 
   */
  public void drawCurrentState();
  
  /*
   * Get action from user
   */
  public UserAction getUserAction();
  
  /*
   * Set UI state to @uiState
   * drawCurrentState() should be called after this to update the UI
   */
  public void setUIState(UIState uiState);

}
