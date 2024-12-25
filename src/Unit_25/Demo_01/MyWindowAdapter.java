package Unit_25.Demo_01;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindowAdapter extends WindowAdapter {

// При щелчке на кнопке закрытия закрыть окно и завершить программу.
    public void windowClosing(WindowEvent we) {
        System.exit(0);
    }
}
