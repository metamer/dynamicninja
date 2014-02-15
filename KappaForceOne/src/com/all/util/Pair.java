/**
 * 
 */
package com.all.util;

import com.frontend.GameMapEntry;

/**
 * @author insidiousnoxious
 *
 */
public class Pair<X,Y> {
    public final X x;
    public final Y y;
    
    public Pair(X x, Y y){
        this.x=x;
        this.y=y;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null)
            return false;
        if (getClass() != obj.getClass()) {
            return false;
          }
        @SuppressWarnings("unchecked")
        final Pair<X,Y> other = (Pair<X,Y>) obj;
        
        if( (this.x == null && other.x == null  || this.x.equals(other.x))
                && (this.y == null && other.y == null  || this.y.equals(other.y))){
            return true;
        }
        
        
        return false;
        
    }
    
    @Override
    public int hashCode(){
        int xHash = x == null ? 0 : x.hashCode();
        int yHash = y == null ? 0 : y.hashCode();
        return xHash + yHash;
    }

}
