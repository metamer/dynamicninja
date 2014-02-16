/**
 * 
 */
package test.com.frontend;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.frontend.ArrayGameMap;
import com.frontend.GameMapEntry;
import com.frontend.GameMapEntryAttribute;
import com.frontend.GameMapEntryColor;
import com.frontend.UIStatus;

/**
 * @author insidiousnoxious
 *
 */
public class UIStatusTest {
    
    UIStatus uis, uisTitleOnly, uisNull;
    
    @Before
    public void setUp(){
        uis = new UIStatus("Hit Points", "Hp", "Represents health of entity");
        uisTitleOnly = new UIStatus("Rage", null, null);
        uisNull = new UIStatus(null, null, null);
    }
    
    /**
     * Test method for {@link com.frontend.UIStatus#UIStatus(java.lang.String, java.lang.String, java.lang.String)}.
     */
    @Test
    public void testUIStatus() {
        assertEquals("Hit Points",uis.title);
        assertEquals("Hp",uis.abbreviation);
        assertEquals("Represents health of entity",uis.description);
    }
    
    @Test
    public void testUIStatusNulls() {
        
        assertNull(uisNull.title);
        assertNull(uisNull.abbreviation);
        assertNull(uisNull.description);
    }

    /**
     * Test method for {@link com.frontend.UIStatus#toString()}.
     */
    @Test
    public void testToString() {
        assertEquals("Hp",uis.toString());
    }
    
    /**
     * Test method for {@link com.frontend.UIStatus#toString()}.
     */
    @Test
    public void testToStringTitleOnly() {
        assertEquals("Rage",uisTitleOnly.toString());
    }
    
    /**
     * Test method for {@link com.frontend.UIStatus#toString()}.
     */
    @Test
    public void testToStringNulls() {
        assertEquals("",uisNull.toString());
    }

}
