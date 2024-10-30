package Demo_08;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/*
Демонстрация многострочного вывода текста.
Многострочный вывод текста в окно, также отображается несколько предложений в одной строке.
Обратите внимание на переменные curX и curY, которые отслеживают текущую позицию вывода текста.
 */
public class MultiLine extends Frame {
    int curX = 20, curY = 40; // текущая позиция

    MultiLine() {
        Font f = new Font("SansSerif", Font.PLAIN, 12);
        setFont(f);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        nextLine("This is оп line one. ", g);
        nextLine("This is оп line two. ", g);
        sameLine("This is оп same line. ", g);
        sameLine("This, too. ", g);
        nextLine("This is on line three. ", g);
        curX = 20;
        curY = 40; //сбрасывать координаты при каждом перерисовывании
    }

    // Перейти на следующую.
    void nextLine(String s, Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        curY += fm.getHeight(); // перейти на следующую строку
        curX = 20;
        g.drawString(s, curX, curY);
        curX += fm.stringWidth(s); // перейти в конец строки
    }

    // Отобразить в той же строке.
    void sameLine(String s, Graphics g) {
        FontMetrics fm = g.getFontMetrics();

        g.drawString(s, curX, curY);
        curX += fm.stringWidth(s); // перейти в конец строки
    }

    public static void main(String[] args) {
        Frame f = new MultiLine();

        f.setTitle("MultiLine");
        f.setSize(new Dimension(600, 300));
        f.setVisible(true);
    }
}
