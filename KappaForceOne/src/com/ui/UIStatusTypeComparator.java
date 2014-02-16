/**
 * 
 */
package com.ui;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import com.frontend.UIStatusType;

/**
 * @author insidiousnoxious
 * Comparator which determines order in which to show menus
 */
public class UIStatusTypeComparator implements Comparator<UIStatusType> {
  
    /**
     * Ranking of menu types. Lower numbers take priority 
     */
    private static final Map<UIStatusType, Integer> RANKING_MAP = new HashMap<UIStatusType,Integer>(){/**
         * 
         */
        private static final long serialVersionUID = -2643873043570407154L;

    {
        put(UIStatusType.VITAL, 1);
        put(UIStatusType.STAT, 2);
        put(UIStatusType.EFFECT, 3);
    }};

    
    /**
     * implements compare. Unranked UIMenuTypes take last position
     */
    @Override
    public int compare(UIStatusType o1, UIStatusType o2) {
        
      Integer i1 = RANKING_MAP.get(o1);
        Integer i2 = RANKING_MAP.get(o2);
        
        
        i1 = i1 == null ? Integer.MAX_VALUE : i1;
        i2 = i2 == null ? Integer.MAX_VALUE : i2;
        
        return (i1 > i2 ? 1 : (i1 == i2 ? 0 : -1));
    }
  
}
