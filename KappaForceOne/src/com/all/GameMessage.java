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
    if(messageText == null || messageType == null) 
      throw new IllegalArgumentException("messageType and messageText cannot be null");
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
  
  /**
   * Adapted from http://stackoverflow.com/questions/8180430/how-to-override-equals-method-in-java
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
        return false;
    }
    if (getClass() != obj.getClass()) {
        return false;
    }
    final GameMessage other = (GameMessage) obj;
    if ((this.getMessageText() == null) ? (other.getMessageText() != null) : !this.getMessageText().equals(other.getMessageText())) {
        return false;
    }
    if (this.getMessageType() != other.getMessageType()) {
        return false;
    }
    return true;
  }
}
