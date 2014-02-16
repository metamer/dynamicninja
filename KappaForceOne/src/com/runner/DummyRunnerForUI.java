/**
 * 
 */
package com.runner;

import java.util.List;

import com.backend.*;
import com.engine.Engine;
import com.frontend.*;
import com.ui.UI;
import com.all.*;

/**
 * @author insidiousnoxious
 *
 */
public class DummyRunnerForUI implements Runner {
  
  private UI ui;
  private int counter = 0;
  
  
  private static UIState GenerateTestUIState(int i ){
    GameMapEntry defaultGme = new GameMapEntry(' ',GameMapEntryColor.BLACK, GameMapEntryColor.BLACK, GameMapEntryAttribute.NORMAL);
    GameMap gm = new ArrayGameMap(15,35, defaultGme);
    
    int heightOffset = i % 2;
    int widthOffset =  i % 35;
    
    
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
    gm.setObjectAt(gm.getHeight()-1 - heightOffset, gm.getWidth()-1 - widthOffset, new GameMapEntry('@',GameMapEntryColor.WHITE, GameMapEntryColor.BLACK, GameMapEntryAttribute.NORMAL));
    
    UIState uiState = new UIState(gm);
    
    
    uiState.addMenu(UIMenuType.INVENTORY, new UIMenu("Junk",'J'));
    uiState.addMenu(UIMenuType.ACTIONS, new UIMenu("Actions", 'A'));
    uiState.addMenu(UIMenuType.SYSTEM, new UIMenu("System",'S'));
    uiState.addMenu(UIMenuType.COMBAT, new UIMenu("Fight!",'F'));
    
    List<GameMessage> gms = uiState.getGameMessages();
    
    gms.add(new GameMessage("This is a dummy runner for the UI!!!",GameMessageType.NOTIFICATION));
    gms.add(new GameMessage("It is dark in here!",GameMessageType.WARNING));
    gms.add(new GameMessage("You have been eaten by a grue!",GameMessageType.COMBAT));
    
    uiState.setCurrentGameMessage(new CurrentGameMessage(String.format("You are in a creature's stomach.%sWhat do you do?",System.getProperty("line.separator"))));
    
    uiState.getStatusMessages().add(new UINumericStatus("Hit Points", "HP", null, UIStatusType.VITAL, 100, 100, true));
    uiState.getStatusMessages().add(new UINumericStatus("Magic Points", "MP", null, UIStatusType.VITAL, 19, 20, true));
    uiState.getStatusMessages().add(new UINumericStatus("Speed", "Spd", null, UIStatusType.VITAL,10,0,false));
    
    uiState.getStatusMessages().add(new UINumericStatus("Strength", "Str", null, UIStatusType.STAT,10,0,false));
    uiState.getStatusMessages().add(new UINumericStatus("Dex", "Dex", null, UIStatusType.STAT,4,0,false));
    uiState.getStatusMessages().add(new UINumericStatus("Intelligence", "Int", null, UIStatusType.STAT,500,0,false));
    uiState.getStatusMessages().add(new UINumericStatus("Charisma", "Cha", null, UIStatusType.STAT,0,0,false));
    
    uiState.getStatusMessages().add(new UIStatus("Bored", "Brd", null, UIStatusType.EFFECT));
    uiState.getStatusMessages().add(new UIStatus("Drowsy", "Drs", null, UIStatusType.EFFECT));
    uiState.getStatusMessages().add(new UIStatus("Fatigued", "Ftg", null, UIStatusType.EFFECT));
    
    return uiState;
  }
  
  public DummyRunnerForUI(){
      counter = 0;
  }
  
  /* (non-Javadoc)
   * @see com.runner.Runner#runGame()
   */
  @Override
  public void runGame(){
      while(counter <=50){
          ui.setUIState(getUIState());
          ui.drawUIState();
          counter ++;
          try{
              Thread.sleep(1000);
          }catch(InterruptedException e){           
          }
      }
  }
  
  /* (non-Javadoc)
   * @see com.runner.Runner#getUIState()
   */
  @Override
  public UIState getUIState() {
    return GenerateTestUIState(counter);
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

  @Override
  public void setTargetUI(UI ui) {
   this.ui=ui;
  }

  @Override
  public void setTargetEngine(Engine engine) {
    throw new UnsupportedOperationException();
  }

}
