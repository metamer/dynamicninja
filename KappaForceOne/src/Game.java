import com.ui.*;
import com.runner.*;
public class Game {

  public static void main(String[] args) {
    Runner r = new DummyRunnerForUI();
    r.setTargetUI(new SimpleConsoleUI());
    r.runGame();
  }

}
