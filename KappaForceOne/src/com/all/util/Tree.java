/**
 * 
 */
package com.all.util;

/**
 * @author insidiousnoxious
 *
 */
public class Tree<T> {

  TreeNode<T> root;
  
  public Tree(){
    root = null;
  }
  
  public Tree(TreeNode<T> root){
    this.root = root; 
  }
  
  //copy constructor not implemented since it will depend on T (if T can be deep copied)
}
