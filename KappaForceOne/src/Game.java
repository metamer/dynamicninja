import com.ui.UI;
import com.ui.jcurses.JCursesUI;
import com.runner.Runner;
import com.runner.DummyRunnerForUI;;
public class Game {

  public static void main(String[] args) {
    Runner r = new DummyRunnerForUI();
    UI jcui = new JCursesUI(80,24);
    r.setTargetUI(jcui);
    r.runGame();
  }

}
