package Demo_05;

import java.awt.event.*;
import java.awt.*;

/*
программа, демонстрирующая получение названий доступных семейств шрифтов:
 */
public class ShowFonts extends Frame {
    String msg = " First five fonts : ";// Первые пять шрифтов
    GraphicsEnvironment ge;

    public ShowFonts() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Получить графическую среду
        ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

        // Получить список шрифтов.
        String[] fontList = ge.getAvailableFontFamilyNames();

        // Создать строку с именами первых пяти шрифтов.
        for (int i = 0; (i < 5) && (i < fontList.length); i++) {
            msg += fontList [i] +" | ";
        }
    }

    public void paint(Graphics g) {
        g.drawString(msg, 10, 60);
    }

    public static void main(String[] args) {
        ShowFonts frame = new ShowFonts();
        frame.setTitle("Show Fonts");
        frame.setSize(new Dimension(500, 100));
        frame.setVisible(true);
    }
}
