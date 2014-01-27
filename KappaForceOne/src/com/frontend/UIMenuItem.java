/**
 * 
 */
package com.frontend;

/**
 * @author insidiousnoxious
 *
 */
public class UIMenuItem {
  private String name;
  private Character hotkey;
  public UIMenuItem(String name){
    this.name = name;
    hotkey=null;
  }
  
  public UIMenuItem(String name, char hotkey){
    this.name = name;
    this.hotkey=hotkey;
  }
  
  //accessor methods
  
  public String getName(){
    return name;
  }
  
  public Character getHotkey(){
    return hotkey;
  }

  public void setHotkey(Character hotkey) {
    this.hotkey=hotkey;
  }
}
