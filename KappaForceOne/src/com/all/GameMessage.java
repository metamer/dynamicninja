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
  private MessageType messageType;

  public GameMessage(String messageText, MessageType messageType){
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
  public MessageType getMessageType() {
    return messageType;
  }
  
}
