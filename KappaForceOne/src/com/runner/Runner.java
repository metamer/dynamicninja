package com.runner;

import com.all.*;
import com.engine.Engine;
import com.frontend.*;
import com.ui.UI;
import com.backend.*;

public interface Runner {
  
  
  /*
   * Run game. This should be called after runner is set up to run the game
   */
  public void runGame();
  
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
  
  /*
   * link to target UI
   */
  public void setTargetUI(UI ui);
  
  /*
   * link to target UI
   */
  public void setTargetEngine(Engine engine);

}
