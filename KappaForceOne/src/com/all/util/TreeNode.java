/**
 * 
 */
package com.all.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author insidiousnoxious
 *
 */
public class TreeNode<T> {
  private T data;
  TreeNode<T> parent;
  List<TreeNode<T>> children;
  

  public TreeNode(){
    this.setData(null);
    children = new ArrayList<TreeNode<T>>();
    this.parent = null;
  }
  
  public TreeNode(T data){
    this.setData(data);
    children = new ArrayList<TreeNode<T>>();
    this.parent = null;
  }
   
  public void removeChild(TreeNode<T> tn){
    
    if(tn== null || tn.parent != this){
      return;
    }
    
    if(children.contains(tn)){
      children.remove(tn);
      tn.parent = null;
    }
    
  }
  
  public void clearChildren(){
    List<TreeNode<T>> temp = children;
    children = new ArrayList<TreeNode<T>>();
    for( TreeNode<T> child : temp){
      child.parent = null;     
    }
  }
  
  public void addChild(TreeNode<T> tn){
    if(tn== null){
      return;
    }
    children.add(tn);
    tn.parent=this;
  }
  
  public void setParent(TreeNode<T> tn){
    parent = tn;
  }

  /**
   * @return the data
   */
  public T getData() {
    return data;
  }

  /**
   * @param set the data to set
   */
  public void setData(T data) {
    this.data = data;
  }
  
  
}
