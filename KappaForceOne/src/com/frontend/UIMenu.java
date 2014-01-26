/**
 * 
 */
package com.frontend;

import com.all.util.Tree;
import com.all.util.TreeNode;

/**
 * @author insidiousnoxious
 * Represents menus available through the UI
 */
public class UIMenu {
  
  Tree<UIMenuItem> menuItems; 

  public UIMenu(String name){
    menuItems= new Tree<UIMenuItem>();
    menuItems.setRoot((new TreeNode<UIMenuItem>()));
    menuItems.getRoot().setData(new UIMenuItem(name));
  }
  
  //accessor methods
  
  public String getName(){
    if(menuItems.getRoot().getData() == null){
      return null;
    }
    
    return menuItems.getRoot().getData().getName();
    
  }

}
