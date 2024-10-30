package Demo_07;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
в программе отображается
имя, семейство, размер и начертание
выбранного в данный момент шрифта:
 */
public class FontInfo extends Frame {
    public FontInfo() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        Font f = g.getFont();
        String fontName = f.getName();
        String fontFamily = f.getFamily();
        int fontSize = f.getSize();
        int fontStyle = f.getStyle();
// Семейство
        String msg = "Family: " + fontName;
// Шрифт
        msg += ", Font : " + fontFamily;
// Размер Начертание
        msg += ", Size : " + fontSize + ", Style : ";
// Полужирное
        if ((fontStyle & Font.BOLD) == Font.BOLD)
            msg += "Bold ";
// Курсивное
        if ((fontStyle & Font.ITALIC) == Font.ITALIC)
            msg += "Italic ";
// Обычное
        if ((fontStyle & Font.PLAIN) == Font.PLAIN)
            msg += " Plain ";

        g.drawString(msg, 10, 60);
    }

    public static void main(String[] args) {
        FontInfo frame = new FontInfo();
        frame.setVisible(true);
        frame.setTitle("Font Info");
        frame.setSize(300, 100);
    }
}
