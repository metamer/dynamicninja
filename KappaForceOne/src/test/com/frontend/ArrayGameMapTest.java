/**
 * 
 */
package test.com.frontend;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.frontend.ArrayGameMap;
import com.frontend.GameMap;
import com.frontend.GameMapEntry;
import com.frontend.GameMapEntryAttribute;
import com.frontend.GameMapEntryColor;

/**
 * @author insidiousnoxious
 *
 */
public class ArrayGameMapTest {

  private ArrayGameMap agm, agmd, agmNull;
  private GameMapEntry gme;
  
  @Before
  public void setUp(){
    gme = new GameMapEntry('x',GameMapEntryColor.BLUE, GameMapEntryColor.BLACK, GameMapEntryAttribute.BOLD);
    agm = new ArrayGameMap(15,44);
    agmd = new ArrayGameMap(15,44,gme);
    agmNull = null;
  }
  
  @Test
  public void testEqualsWithoutDefault() {
    ArrayGameMap agm2 = new ArrayGameMap(15,44);
    ArrayGameMap agm3 = new ArrayGameMap(15,44,null);
    ArrayGameMap agm4 = new ArrayGameMap(15,10);
    ArrayGameMap agm5 = new ArrayGameMap(50,44);
    
    assertEquals(agm, agm2);
    assertEquals(agm, agm3);
    assertNotEquals(agm, agm4);
    assertNotEquals(agm, agm5);
    assertNotEquals(agm, agmd);
    
  }
  
  @Test
  public void testEqualsWithDefault() {
    ArrayGameMap agm2 = new ArrayGameMap(15,44,gme);
    ArrayGameMap agm3 = new ArrayGameMap(15,44,null);
    ArrayGameMap agm4 = new ArrayGameMap(15,10,gme);
    ArrayGameMap agm5 = new ArrayGameMap(50,44,gme);
    
    assertEquals(agmd, agm2);
    assertNotEquals(agmd, agm3);
    assertNotEquals(agmd, agm4);
    assertNotEquals(agmd, agm5);
    assertNotEquals(agmd, agm);
    
  }
  
  @Test
  public void testEqualsSpecialCasesWithoutDefault(){
    assertEquals(agm,agm);
    assertNotEquals(agm,agmNull);
    
  }
  
  @Test
  public void testEqualsSpecialCasesWithDefault(){
    assertEquals(agmd,agmd);
    assertNotEquals(agmd,agmNull);
  }
  
  @Test
  public void testCopyConstructorForInterface(){
    ArrayGameMap agmCopy = new ArrayGameMap((GameMap)agm);
    assertEquals(agm, agmCopy);
    assertNotSame(agm,agmCopy);
    
    //copied map will not have default set
    ArrayGameMap agmdCopy = new ArrayGameMap((GameMap)agmd);
    assertNotEquals(agmd, agmdCopy);
    assertNotEquals(agm, agmdCopy);
  }
  
  @Test
  public void testCopyConstructorForClass(){
    ArrayGameMap agmCopy = new ArrayGameMap(agm);
    assertEquals(agm, agmCopy);
    assertNotSame(agm, agmCopy);
    
    //copied map will have default set
    ArrayGameMap agmdCopy = new ArrayGameMap(agmd);
    assertEquals(agmd, agmdCopy);
    assertNotSame(agmd, agmdCopy);
    
    assertNotEquals(agm, agmdCopy);
  }

}
