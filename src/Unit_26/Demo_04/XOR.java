package Demo_04;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
Демонстрация режима с исключающим ИЛИ.

В программе отображается перекрестие, которое отслеживает указатель мыши.
Перекрестие объединяется с содержимым окна посредством
операции исключающего ИЛИ и будет видимым всегда
независимо от цвета содержимого.
 */
public class XOR extends Frame {
    int chsX = 100, chsY = 100;

    public XOR() {
        setTitle("XOR Demo");
        setSize(800, 600);
        setVisible(true);
        // Закрытие окна при нажатии на кнопку закрытия
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        // Обработчик движения мыши
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                chsX = x - 10;
                chsY = y - 10;
                repaint();
            }
        });
    }

    // Использовать режим с исключающим ИЛИ.
    public void paint(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(20, 40, 60, 70);

        g.setColor(Color.blue);
        g.fillRect(110, 40, 60, 70);

        g.setColor(Color.black);
        g.fillRect(200, 40, 60, 70);

        g.setColor(Color.red);
        g.fillRect(60, 120, 160, 110);

        // Объединить перекрестие с содержимым посредством
        // операции исключающего ИЛИ.
        g.setXORMode(Color.black);
        g.drawLine(chsX - 10, chsY, chsX + 10, chsY);// горизонтальная
        g.drawLine(chsX, chsY - 10, chsX, chsY + 10);//вертикальная
        g.setPaintMode();
    }

    public static void main(String[] args) {
        new XOR();
    }
}

