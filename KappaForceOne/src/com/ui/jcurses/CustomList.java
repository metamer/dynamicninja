/**
 * 
 */
package com.ui.jcurses;

import jcurses.widgets.List;

/**
 * @author insidiousnoxious
 *
 */
public class CustomList extends List {

    /**
     * 
     */
    public CustomList() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param arg0
     */
    public CustomList(int arg0) {
        super(arg0);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param arg0
     * @param arg1
     */
    public CustomList(int arg0, boolean arg1) {
        super(arg0, arg1);
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void doRepaint(){
        super.doRepaint();
    }

}
