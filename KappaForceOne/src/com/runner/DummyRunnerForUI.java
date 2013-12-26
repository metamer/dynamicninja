/**
 * 
 */
package com.runner;

import java.util.List;

import com.backend.*;
import com.frontend.*;
import com.all.*;

/**
 * @author insidiousnoxious
 *
 */
public class DummyRunnerForUI implements Runner {
  
  private static UIState GenerateTestUIState(){
    GameMapEntry defaultGme = new GameMapEntry(' ',GameMapEntryColor.BLACK, GameMapEntryColor.BLACK, GameMapEntryAttribute.NORMAL);
    GameMap gm = new ArrayGameMap(5, 5, defaultGme);
    
    gm.setObjectAt(0,0, new GameMapEntry('J',GameMapEntryColor.BLUE, GameMapEntryColor.BLACK, GameMapEntryAttribute.BOLD));
    gm.setObjectAt(0,1, new GameMapEntry('U',GameMapEntryColor.CYAN, GameMapEntryColor.BLACK, GameMapEntryAttribute.NORMAL));
    gm.setObjectAt(0,2, new GameMapEntry('S',GameMapEntryColor.GREEN, GameMapEntryColor.BLACK, GameMapEntryAttribute.REVERSE));
    gm.setObjectAt(0,3, new GameMapEntry('T',GameMapEntryColor.RED, GameMapEntryColor.BLACK, GameMapEntryAttribute.REVERSE));
    gm.setObjectAt(1,1, new GameMapEntry('A',GameMapEntryColor.BLUE, GameMapEntryColor.CYAN, GameMapEntryAttribute.NORMAL));
    gm.setObjectAt(3,0, new GameMapEntry('T',GameMapEntryColor.BLUE, GameMapEntryColor.WHITE, GameMapEntryAttribute.BOLD));
    gm.setObjectAt(3,1, new GameMapEntry('E',GameMapEntryColor.BLUE, GameMapEntryColor.YELLOW, GameMapEntryAttribute.NORMAL));
    gm.setObjectAt(3,2, new GameMapEntry('S',GameMapEntryColor.BLACK, GameMapEntryColor.YELLOW, GameMapEntryAttribute.NORMAL));
    gm.setObjectAt(3,3, new GameMapEntry('T',GameMapEntryColor.GREEN, GameMapEntryColor.RED, GameMapEntryAttribute.NORMAL));
    gm.setObjectAt(3,4, new GameMapEntry('!',GameMapEntryColor.BLUE, GameMapEntryColor.MAGENTA, GameMapEntryAttribute.BOLD));
    
    UIState uiState = new UIState(gm);
    
    List<UIMenu> gml = uiState.getMenuList();
    gml.add(new UIMenu("FirstMenu"));
    gml.add(new UIMenu("MenuSecond"));
    gml.add(new UIMenu("MenuTheIII"));
    
    List<GameMessage> gms = uiState.getGameMessages();
    
    gms.add(new GameMessage("This is a dummy runner for the UI",GameMessageType.NOTIFICATION));
    gms.add(new GameMessage("It is dark in here!",GameMessageType.WARNING));
    gms.add(new GameMessage("You have been eaten by a grue!",GameMessageType.COMBAT));
    
    return uiState;
  }
  
  public DummyRunnerForUI(){  
  }
  
  /* (non-Javadoc)
   * @see com.runner.Runner#getUIState()
   */
  @Override
  public UIState getUIState() {
    return GenerateTestUIState();
  }

  /* (non-Javadoc)
   * @see com.runner.Runner#getGameState()
   */
  @Override
  public GameState getGameState() {
    throw new UnsupportedOperationException();
  }

  /* (non-Javadoc)
   * @see com.runner.Runner#UpdateGameState(com.backend.GameAction)
   */
  @Override
  public void UpdateGameState(GameAction gameAction) {
    throw new UnsupportedOperationException();
  }

  /* (non-Javadoc)
   * @see com.runner.Runner#MapUserAction(com.frontend.UserAction)
   */
  @Override
  public GameAction MapUserAction(UserAction inputUserAction) {
    throw new UnsupportedOperationException();
  }

}
