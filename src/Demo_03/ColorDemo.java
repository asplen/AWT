package Demo_03;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
Демонстрация работы с цветом.
 */
public class ColorDemo extends Frame {
    ColorDemo() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        Color c1 = new Color(255, 100, 100);//красный
        Color c2 = new Color(100, 255, 100);// зеленый
        Color c3 = new Color(100, 100, 255);//синий

        g.setColor(c1);
        g.drawLine(20, 40, 100, 100);//красный
        g.drawLine(20, 100, 100, 20);

        g.setColor(c2);
        g.drawLine(40, 45, 250, 180);// зеленый
        g.drawLine(75, 90, 400, 400);

        g.setColor(c3);
        g.drawLine(20, 150, 400, 40);//синий
        g.drawLine(25, 290, 80, 19);

        g.setColor(Color.red);
        g.drawOval(20, 40, 50, 50);//овал
        g.fillOval(70, 90, 140, 100);

        g.setColor(Color.blue);
        g.drawOval(190, 40, 90, 60);
        g.drawRect(40, 40, 55, 50);

        g.setColor(Color.cyan);
        g.fillRect(100, 40, 60, 70);
        g.drawRoundRect(190,40,60,60,15,15);
    }

    public static void main(String[] args) {
        ColorDemo app = new ColorDemo();

        app.setSize(new Dimension(340, 260));
        app.setTitle("ColorDemo");
        app.setVisible(true);
    }
}
