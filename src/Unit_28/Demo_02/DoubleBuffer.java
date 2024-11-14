package Unit_28.Demo_02;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
Пример рисования изображения,
сопряженного с высокими затратами времени, который иллюстрирует
эффект от двойной буферизации, касающийся восприятия времени рисования:

Несмотря на относительную простоту, программа DoubleBuffer
имеет сложный метод paint (), который окрашивает фон в синий цвет,
выводит на нем красный муаровый узор, поверх рисует текст черного цвета и,
наконец, вычерчивает желтый круг с координатами центра mx, my.

Кроме того, для отслеживания положения указателя мыши переопределяются
методы mouseMoved () и mouseDragged (), которые идентичны за исключением
установки булевской переменной flicker.
В методе mouseMoved ()
переменная flicker устанавливается в true, а в методе mouseDragged () - в false.
В итоге метод repaint () вызывается со значением flicker, равным true,
когда указатель мыши перемещается (но никакая кнопка мыши не нажата),
и false, когда указатель мыши перетаскивается при любой нажатой кнопке.
 */
public class DoubleBuffer extends Frame {
    int gap = 3;
    int mx, my;
    boolean flicker = true;
    Image buffer = null;
    int w = 400, h = 400;

    public DoubleBuffer() {
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                mx = e.getX();
                my = e.getY();
                flicker = false;
                repaint();
            }

            public void mouseMoved(MouseEvent e) {
                mx = e.getX();
                my = e.getY();
                flicker = true;
                repaint();
            }
        });
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        Graphics screengc = null;
        if (!flicker) {
            screengc = g;
            g = buffer.getGraphics();
        }

        g.setColor(Color.blue);
        g.fillRect(0, 0, w, h);

        g.setColor(Color.red);

        for (int i = 0; i < w; i += gap)
            g.drawLine(i, 0, w - i, h);


        for (int i = 0; i < h; i += gap)
            g.drawLine(0, i, w, h - i);

        g.setColor(Color.black);
        g.drawString(" Press mouse button to double buffer", 10, h / 2);// Нажмите кнопку мыши, чтобы удвоить буфер

        g.setColor(Color.yellow);
        g.fillOval(mx - gap, my - gap, gap * 2 + 1, gap * 2 + 1);

        if (!flicker) {
            screengc.drawImage(buffer, 0, 0, null);
        }
    }

    public void update(Graphics g) {
        paint(g);
    }

    public static void main(String[] args) {
        DoubleBuffer frame = new DoubleBuffer();

        frame.setVisible(true);
        frame.setTitle("DoubleBuffer");
        frame.setSize(new Dimension(400, 400));

        //создать внеэкранный буфер
        frame.buffer = frame.createImage(frame.w, frame.h);
    }
}
