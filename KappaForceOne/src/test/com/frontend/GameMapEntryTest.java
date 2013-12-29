/**
 * 
 */
package test.com.frontend;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.frontend.GameMapEntry;
import com.frontend.GameMapEntryAttribute;
import com.frontend.GameMapEntryColor;

/**
 * @author insidiousnoxious
 *
 */
public class GameMapEntryTest {

  private GameMapEntry gme ;
  
  @Rule
  public ExpectedException thrown = ExpectedException.none();
  
  @Before
  public void setUp(){
    gme= new GameMapEntry('x',GameMapEntryColor.BLUE, GameMapEntryColor.BLACK, 
        GameMapEntryAttribute.NORMAL);
  }
  
  @Test
  public void testEquals(){
    GameMapEntry gme1 =new GameMapEntry('x',GameMapEntryColor.BLUE, GameMapEntryColor.BLACK, 
        GameMapEntryAttribute.NORMAL); 
    GameMapEntry gme2 =new GameMapEntry('y',GameMapEntryColor.BLUE, GameMapEntryColor.BLACK, 
        GameMapEntryAttribute.NORMAL); 
    GameMapEntry gme3 =new GameMapEntry('x',GameMapEntryColor.BLACK, GameMapEntryColor.BLACK, 
        GameMapEntryAttribute.NORMAL);
    GameMapEntry gme4 =new GameMapEntry('x',GameMapEntryColor.BLUE, GameMapEntryColor.BLUE, 
        GameMapEntryAttribute.NORMAL);
    GameMapEntry gme5 =new GameMapEntry('x',GameMapEntryColor.BLUE, GameMapEntryColor.BLACK, 
        GameMapEntryAttribute.BOLD);
    
    assertEquals(gme, gme1);
    assertNotEquals(gme, gme2);
    assertNotEquals(gme, gme3);
    assertNotEquals(gme, gme4);
    assertNotEquals(gme, gme5);
    
  }
  
  @Test
  public void testNullForegroundColor() throws IllegalArgumentException {
    thrown.expect(IllegalArgumentException.class);
    GameMapEntry gmeNull = new GameMapEntry('q',null,GameMapEntryColor.WHITE,GameMapEntryAttribute.BOLD);    
  }
  
  @Test
  public void testNullBackgroundColor() throws IllegalArgumentException {
    thrown.expect(IllegalArgumentException.class);
    GameMapEntry gmeNull = new GameMapEntry('q',GameMapEntryColor.CYAN,null,GameMapEntryAttribute.BOLD);    
  }
  
  @Test
  public void testNullAttribute() throws IllegalArgumentException {
    thrown.expect(IllegalArgumentException.class);
    GameMapEntry gmeNull = new GameMapEntry('q',GameMapEntryColor.CYAN,GameMapEntryColor.WHITE,null);    
  }
  
  @Test
  public void testEqualsSpecialCases(){
    GameMapEntry gmeNull = null;
    assertEquals(gme, gme);
    assertNotEquals(gme, gmeNull);
    
  }
  
  @Test
  public void testCopyConstructor() {
    GameMapEntry other = new GameMapEntry(gme);
    assertEquals(gme, other);
    assertNotSame(gme, other);
  }
  
  @Test
  public void testGetSymbol(){
    assertEquals('x',gme.getSymbol());
  }

  @Test
  public void testGetForegroundColor(){
    assertEquals(GameMapEntryColor.BLUE,gme.getForegroundColor());
  }
  
  @Test
  public void testGetBackgroundColor(){
    assertEquals(GameMapEntryColor.BLACK,gme.getBackgroundColor());
  }
  
  @Test
  public void testGetAttribute(){
    assertEquals(GameMapEntryAttribute.NORMAL,gme.getAttribute());
  }

}
