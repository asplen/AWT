package Demo_01;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
Демонстрация работы методов вычерчивания
 */
public class GraphicsDemo extends Frame {

    public GraphicsDemo() {
        // Анонимный внутренний класс для обработки событий закрытия окна.
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public void  paint(Graphics g) {
        //вычертить линии
        g.drawLine(20,40,100,90);
        g.drawLine(20,90,100,40);
//        g.drawLine(40,45,250,80);

        // Вычертить прямоугольники.
        g . drawRect(20, 150 , 60 , 50);
        g.fillRect(110, 150 , 60, 50);
        g.drawRoundRect(200, 150 , 60 , 50 , 15 , 15);
        g.fillRoundRect(290 , 150 , 60 , 50, 30, 40);

        // Вычертить эллипсы и окружности.
        g.drawOval(20, 250, 50 , 50);
        g.fillOval(100, 250 , 75, 50);
        g.drawOval(200, 260 , 100, 40);

        // Вычертить многоугольник.
        int[] xPoints = {20, 200 , 20, 200, 20 };
        int[] yPoints = { 450 , 450, 650 , 650 , 450 };
        int num = 5;
        g.drawPolygon(xPoints , yPoints, num);
    }
    public static void main(String[] args) {
        GraphicsDemo frame = new GraphicsDemo();

        frame.setSize(new Dimension(500, 800));
        frame.setTitle("GraphicsDemo_01");
        frame.setVisible(true);
    }
}
