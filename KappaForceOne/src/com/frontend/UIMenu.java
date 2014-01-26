/**
 * 
 */
package com.frontend;

import com.all.util.Tree;

/**
 * @author insidiousnoxious
 * Represents menus available through the UI
 */
public class UIMenu {
  
  private String name;
  Tree<UIMenuItem> menuItems; 
  public UIMenu(String name){
    this.name=name;
    menuItems= new Tree<UIMenuItem>();
  }
  
  //accessor methods
  
  public String getName(){
    return name;
  }

}
