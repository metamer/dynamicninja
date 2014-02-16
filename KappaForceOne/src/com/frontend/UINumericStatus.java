/**
 * 
 */
package com.frontend;

/**
 * @author insidiousnoxious
 *
 */
public class UINumericStatus extends UIStatus {

    boolean displayMax;
    int current;
    int max;
    
    /**
     * @param title
     * @param abbreviation
     * @param description
     * @param current current value of status
     * @param max max value of status
     */
    public UINumericStatus(String title, String abbreviation, String description, int current, int max, boolean displayMax) {
        super(title, abbreviation, description);
        this.current=current;
        this.max=max;
        this.displayMax = displayMax;
    }
    
    @Override
    public String toString(){
        
        StringBuilder sb = new StringBuilder(super.toString());

        sb.append(":");
        sb.append(current);
        if(displayMax){
            sb.append("/");
            sb.append(max);
        }
        
        return sb.toString();
    }

}

