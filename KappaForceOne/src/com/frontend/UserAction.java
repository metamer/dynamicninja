/**
 * 
 */
package com.frontend;

/**
 * @author insidiousnoxious
 * Represents actions that users can perform
 */
public class UserAction {
  
  /**
   * Char representing key user has pressed
   */
  private char actionKey;
  
  public UserAction(char actionKey){
    this.actionKey = actionKey;
  }
  
  public char getActionKey(){
    return actionKey;
  }

}
