package jcurses.temp;

import jcurses.event.ActionEvent;
import jcurses.event.ActionListener;
import jcurses.event.ItemEvent;
import jcurses.event.ItemListener;
import jcurses.event.ValueChangedEvent;
import jcurses.event.ValueChangedListener;
import jcurses.event.WindowEvent;
import jcurses.event.WindowListener;
import jcurses.system.CharColor;
import jcurses.widgets.Button;
import jcurses.widgets.FileDialog;
import jcurses.widgets.GridLayoutManager;
import jcurses.widgets.List;
import jcurses.widgets.PasswordField;
import jcurses.widgets.PopUpMenu;
import jcurses.widgets.TextArea;
import jcurses.widgets.Widget;
import jcurses.widgets.WidgetsConstants;
import jcurses.widgets.Window;

public class TestWindow extends Window implements ItemListener, ActionListener,
    ValueChangedListener, WindowListener, WidgetsConstants {

  public static void main(String[] args) throws Exception {
    Window test = new TestWindow(80, 25);
    test.addListener((WindowListener) test);
    test.show();
  }

  private Button buttonOne = null;

  private Button buttonTwo = null;

  private List entryList = null;

  private TextArea _textArea = new TextArea(-1, -1,
      "1111\n2222\n3333\n4444\n\n66666\n77777\n888888\n99999999999999999\n1010100101");

  private PasswordField _pass = new PasswordField();

  public TestWindow(int width, int height) {

    super(width, height, true, "Test");

    buttonOne = new Button("OK");

    buttonOne.setShortCut('o');

    buttonOne.addListener(this);

    buttonTwo = new Button("Cancel");

    buttonTwo.setShortCut('p');

    buttonTwo.addListener(this);

    entryList = new List();

    entryList.add("item1");

    entryList.add("item201234567890123456789");

    entryList.add("item3");

    entryList.add("item4");

    entryList.add("item5");

    entryList.addListener(this);

    entryList.getSelectedItemColors().setColorAttribute(CharColor.BOLD);

    GridLayoutManager manager1 = new GridLayoutManager(2, 5);

    getRootPanel().setLayoutManager(manager1);

    // manager.addWidget(_l1,0,0,1,2,ALIGNMENT_CENTER, ALIGNMENT_CENTER);

    manager1.addWidget(entryList, 0, 0, 1, 4, ALIGNMENT_TOP, ALIGNMENT_CENTER);

    manager1.addWidget(_textArea, 1, 0, 1, 2, ALIGNMENT_CENTER, ALIGNMENT_CENTER);

    manager1.addWidget(_pass, 1, 2, 1, 2, ALIGNMENT_CENTER, ALIGNMENT_CENTER);

    manager1.addWidget(buttonOne, 0, 4, 1, 1, ALIGNMENT_CENTER, ALIGNMENT_CENTER);

    manager1.addWidget(buttonTwo, 1, 4, 1, 1, ALIGNMENT_CENTER, ALIGNMENT_CENTER);

  }

  public void actionPerformed(ActionEvent event) {

    Widget w = event.getSource();

    if (w == buttonOne) {
      FileDialog dial = new FileDialog("File whlen");
      dial.show();

      if (dial.getChoosedFile() != null) {

      }

      _pass.setVisible(!_pass.isVisible());

      pack();

      paint();

    } else {

      PopUpMenu menu = new PopUpMenu(53, 5, "test");

      for (int i = 1; i < 100; i++) {

        if ((i == 35) || (i == 4)) {
          menu.addSeparator();
        } else {
          menu.add("item" + i);
        }

      }

      menu.show();

    }

    // close();

  }

  public void stateChanged(ItemEvent e) {

  }

  public void valueChanged(ValueChangedEvent e) {

  }

  public void windowChanged(WindowEvent event) {

    if (event.getType() == WindowEvent.CLOSING) {

      event.getSourceWindow().close();

    }

  }

}
