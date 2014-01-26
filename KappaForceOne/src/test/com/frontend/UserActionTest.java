/**
 * 
 */
package test.com.frontend;

import static org.junit.Assert.*;

import org.junit.Test;
import com.frontend.UserAction;

/**
 * @author insidiousnoxious
 *
 */
public class UserActionTest {

  @Test
  public void testActionKeyConstructor() {
    UserAction ua = new UserAction('x');
    assertEquals('x',ua.getActionKey());
  }
  
}
