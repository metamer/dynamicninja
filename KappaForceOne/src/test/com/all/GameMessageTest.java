/**
 * 
 */
package test.com.all;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import com.all.GameMessage;
import com.all.GameMessageType;

/**
 * @author insidiousnoxious
 *
 */
public class GameMessageTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  
  @Test
  public void testNullConstructor() throws IllegalArgumentException {
    thrown.expect(IllegalArgumentException.class);
    GameMessage gm= new GameMessage(null,null);    
  }
  
  @Test
  public void testNullMessageText() throws IllegalArgumentException {
    thrown.expect(IllegalArgumentException.class);
    GameMessage gm= new GameMessage(null,GameMessageType.NOTIFICATION);
  }
  
  @Test
  public void testNullMessageType() throws IllegalArgumentException {
    thrown.expect(IllegalArgumentException.class);
    GameMessage gm = new GameMessage("Message 1",null);
  }
  
  @Test
  public void testStandard(){
    GameMessage gm = new GameMessage("Message 1",GameMessageType.NOTIFICATION);
    assertEquals("Message text is not equal to text passed to constructor","Message 1",gm.getMessageText());
    assertEquals("Message type is not equal to type passed to constructor",GameMessageType.NOTIFICATION,gm.getMessageType());
  }
  
  @Test
  public void testEmptyMessage(){
    GameMessage gm = new GameMessage("",GameMessageType.SYSTEM);
    assertEquals("Message text is not equal to text passed to constructor","",gm.getMessageText());
    assertEquals("Message type is not equal to type passed to constructor",GameMessageType.SYSTEM,gm.getMessageType());
  }
  
  @Test
  public void testEquals(){
    GameMessage gm1, gm2, gm3, gm4, gm5;
    GameMessage gmNull= null;
    gm1 = new GameMessage("Message X",GameMessageType.SYSTEM);
    gm2 = new GameMessage("Message X",GameMessageType.SYSTEM);
    gm3 = new GameMessage("Message Y",GameMessageType.SYSTEM);
    gm4 = new GameMessage("Message X",GameMessageType.NOTIFICATION);
    gm5 = new GameMessage("Message Y",GameMessageType.NOTIFICATION);
    
    assertTrue("Equals does not match same object",gm1.equals(gm1));
    assertTrue("Equals does not match messages with same text and type",gm1.equals(gm2));
    assertFalse("Equals matches objects with different message texts", gm1.equals(gm3));
    assertFalse("Equals matches objects with different message types", gm1.equals(gm4));
    assertFalse("Equals matches objects with different message texts and types", gm1.equals(gm5));
    assertFalse("Equals matches non-null obj with null obj",gm1.equals(gmNull));
  }
}
