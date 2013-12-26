package com.runner;

import com.all.*;
import com.frontend.*;
import com.backend.*;

public interface Runner {
  
  /*
   * Accessor for current UIState
   */
  public UIState getUIState();
  
  /*
   * Accessor for current GameState
   */
  public GameState getGameState();
  
  /*
   * Update GameState based on action
   */
  public void UpdateGameState(GameAction gameAction);
  
  /*
   * Map input userAction to GameAction
   */
  public GameAction MapUserAction(UserAction inputUserAction);

}
