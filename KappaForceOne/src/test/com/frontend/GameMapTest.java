package test.com.frontend;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.frontend.ArrayGameMap;
import com.frontend.GameMap;
import com.frontend.GameMapEntry;
import com.frontend.GameMapEntryAttribute;
import com.frontend.GameMapEntryColor;

@RunWith(Parameterized.class)
public class GameMapTest {

  public GameMap gm;
  
  public GameMapTest(GameMap gm) {
    this.gm = gm;
  }
  
  @Parameterized.Parameters
  public static Collection<Object[]> instancesToTest() {
      return Arrays.asList(
                  new Object[]{new ArrayGameMap(10,15)},
                  new Object[]{new ArrayGameMap(10,15)} //placeholder replace with any other GameMap implementation eclipse does not build if there is only one entry in array
      );
  }
  
  
  /**
   * reset to initialized (all positions null)
   */
  @Before
  public void tearDown(){
    for(int i = 0; i < gm.getHeight() ; i++){
      for(int j = 0; j < gm.getWidth() ; j++){
        gm.setObjectAt(i, j, null);
      }
    }
  }
  
  
  @Test
  public void testgetHeight() {
      assertEquals(10,gm.getHeight());
  }
  
  @Test
  public void testgetWidth() {
      assertEquals(15,gm.getWidth());
  }
  
  @Test
  public void testgetSetObjectAllSame() {
    final GameMapEntry gme = new GameMapEntry('x', GameMapEntryColor.CYAN, GameMapEntryColor.GREEN, GameMapEntryAttribute.NORMAL);
    
    for(int i = 0; i < gm.getHeight() ; i++){
      for(int j = 0; j < gm.getWidth() ; j++){
        assertNull(gm.getObjectAt(i,j));
        gm.setObjectAt(i, j, gme);
      }
    }
    
    for(int i = 0; i < gm.getHeight() ; i++){
      for(int j = 0; j < gm.getWidth() ; j++){       
        assertEquals(
          new GameMapEntry('x', GameMapEntryColor.CYAN, GameMapEntryColor.GREEN, GameMapEntryAttribute.NORMAL),
          gm.getObjectAt(i, j)
        );
      }
    }
  }
  
  @Test
  public void testgetSetObjectAllNull() {
    final GameMapEntry gme = new GameMapEntry('x', GameMapEntryColor.CYAN, GameMapEntryColor.GREEN, GameMapEntryAttribute.NORMAL);
    
    for(int i = 0; i < gm.getHeight() ; i++){
      for(int j = 0; j < gm.getWidth() ; j++){
        assertNull(gm.getObjectAt(i,j));
        gm.setObjectAt(i, j, gme); //first set to gme
        gm.setObjectAt(i, j, null); //then set to null
      }
    }
    
    for(int i = 0; i < gm.getHeight() ; i++){
      for(int j = 0; j < gm.getWidth() ; j++){       
        assertSame(null, gm.getObjectAt(i, j));
      }
    }
  }
  
  @Test
  public void testgetSetObjectVariousChars() {

    for(int i = 0; i < gm.getHeight() ; i++){
      for(int j = 0; j < gm.getWidth() ; j++){
        assertNull(gm.getObjectAt(i,j));
        final GameMapEntry gme = new GameMapEntry((char)(i*15 + j + 'a'), GameMapEntryColor.CYAN, GameMapEntryColor.GREEN, GameMapEntryAttribute.NORMAL);
        gm.setObjectAt(i, j, gme); 
      }
    }
    
    for(int i = 0; i < gm.getHeight() ; i++){
      for(int j = 0; j < gm.getWidth() ; j++){       
        assertEquals(new GameMapEntry((char)(i*15 + j + 'a'), GameMapEntryColor.CYAN, GameMapEntryColor.GREEN, GameMapEntryAttribute.NORMAL), gm.getObjectAt(i, j));
      }
    }
  }
  
}
