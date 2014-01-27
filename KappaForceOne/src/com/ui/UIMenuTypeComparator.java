/**
 * 
 */
package com.ui;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import com.frontend.UIMenuType;

/**
 * @author insidiousnoxious
 * Comparator which determines order in which to show menus
 */
public class UIMenuTypeComparator implements Comparator<UIMenuType> {
  
    /**
     * Ranking of menu types. Lower numbers take priority 
     */
    private static final Map<UIMenuType, Integer> RANKING_MAP = new HashMap<UIMenuType,Integer>(){{
        put(UIMenuType.SYSTEM, 1);
        put(UIMenuType.ACTIONS, 2);
        put(UIMenuType.INVENTORY, 3);
        put(UIMenuType.COMBAT, 4);
    }};

    
    /**
     * implements compare. Unranked UIMenuTypes take last position
     */
    public int compare(UIMenuType o1, UIMenuType o2) {
        
      Integer i1 = RANKING_MAP.get(o1);
        Integer i2 = RANKING_MAP.get(o2);
        
        
        i1 = i1 == null ? Integer.MAX_VALUE : i1;
        i2 = i2 == null ? Integer.MAX_VALUE : i2;
        
        return (i1 > i2 ? 1 : (i1 == i2 ? 0 : -1));
    }
  
}
