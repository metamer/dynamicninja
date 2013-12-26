/**
 * 
 */
package com.all;

/**
 * @author insidiousnoxious
 *
 */
public class GameMessage {
  
  private String messageText;
  private GameMessageType messageType;

  public GameMessage(String messageText, GameMessageType messageType){
    this.messageText = messageText;
    this.messageType = messageType;
  }
  
  /**
   * @return the messageText
   */
  public String getMessageText() {
    return messageText;
  }
  
  /**
   * @return the messageType
   */
  public GameMessageType getMessageType() {
    return messageType;
  }
  
}
