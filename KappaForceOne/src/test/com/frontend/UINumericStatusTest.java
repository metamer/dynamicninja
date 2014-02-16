/**
 * 
 */
package test.com.frontend;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import com.frontend.UINumericStatus;

/**
 * @author insidiousnoxious
 *
 */
public class UINumericStatusTest {

    UINumericStatus withMax, withoutMax, nullStrings;
    
    @Before
    public void setUp() {
        withMax = new UINumericStatus("Happy Points", "HPY", "How happy you are", -50, 135, true);
        withoutMax = new UINumericStatus("Sad Points", "SP", "How sad you are", 110, 120, false);
        nullStrings = new UINumericStatus(null, null, null, 110, 200, true);
    }

    @Test
    public void testToString() {
        assertEquals("HPY:-50/135", withMax.toString());
        assertEquals("SP:110",withoutMax.toString());
        assertEquals(":110/200",nullStrings.toString());
    }

}
