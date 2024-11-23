package Unit_25.Demo_02;

import Unit_25.Demo_01.MyWindowAdapter;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
Демонстрация обработчиков событий клавиатуры.
*/
public class SimpleKey extends Frame implements KeyListener {
    String msg = "";
    String keyState = "Press Key";

    public SimpleKey() {
        addKeyListener(this);
        addWindowListener(new MyWindowAdapter());
    }

    // Обработать ввод символа .
    @Override
    public void keyTyped(KeyEvent e) {
        msg += e.getKeyChar();
        repaint();
    }

    // Обработать нажатие клавиши.
    @Override
    public void keyPressed(KeyEvent e) {
        keyState = "Кеу Down"; // клавиша нажата
        repaint();
    }

    // Обработать отпускание клавиши .
    @Override
    public void keyReleased(KeyEvent e) {
        keyState = "Кеу Up";// клавиша отпущена
        repaint();
    }

    // Отобразить результаты нажатых клавиш .
    public void paint (Graphics g) {
        g . drawString (msg, 20, 100);
        g .drawString ( keyState, 20, 50);
    }

    public static void main(String[] args) {
        SimpleKey demo=new SimpleKey();

        demo.setSize(new Dimension(500,300));
        demo.setTitle("Демонстрация обработчиков событий клавиатуры.");
        demo.setVisible(true);
    }
}
