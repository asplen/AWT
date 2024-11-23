package Unit_25.Demo_02;

import Unit_25.Demo_01.MyWindowAdapter;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventsDemo extends Frame implements KeyListener {
    String msg = "";
    String keyState = "Press key";

    public KeyEventsDemo() {
        addKeyListener(this);
        addWindowListener(new MyWindowAdapter());
    }

    // Обработать ввод символа.
    @Override
    public void keyTyped(KeyEvent e) {
        msg += e.getKeyChar();
        repaint();
    }

    // Обработать нажатие клавиши .
    @Override
    public void keyPressed(KeyEvent e) {
        keyState = "Кеу Down "; // клавиша нажата

        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_F1:
                msg += "<F1>";
                break;
            case KeyEvent.VK_F2:
                msg += " <F2>";
                break;
            case KeyEvent.VK_F3:
                msg += "<FЗ>";
                break;
            case KeyEvent.VK_PAGE_DOWN:
                msg += "<PgDn>";
                break;
            case KeyEvent.VK_PAGE_UP:
                msg += "<PgUp> ";
                break;
            case KeyEvent.VK_LEFT:
                msg += " <Left Arrow> ";// стрелка влево
                break;
            case KeyEvent.VK_RIGHT:
                msg += "<Right Arrow>";// стрелка вправо
                break;
        }
        repaint();
    }

    // Обработать отпускание клавиши .
    @Override
    public void keyReleased(KeyEvent e) {
        keyState = "Кеу Up"; // клавиша отпущена
        repaint();
    }

    // Отобразить результаты нажатых клавиш.
    public void paint(Graphics g) {
        g.drawString(msg, 20, 100);
        g.drawString(keyState, 20, 50);
    }

    public static void main(String[] args) {
        KeyEventsDemo demo=new KeyEventsDemo();

        demo.setSize(new Dimension(500,300));
        demo.setTitle("KeyEventsDemo");
        demo.setVisible(true);
    }
}
