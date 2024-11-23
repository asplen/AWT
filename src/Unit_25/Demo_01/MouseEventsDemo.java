package Unit_25.Demo_01;

import java.awt.*;
import java.awt.event.*;

//Демонстрация обработчиков событий мыши
public class MouseEventsDemo extends Frame implements MouseListener, MouseMotionListener {
    String msg = "";
    int mouseX = 0, mouseY = 0;// координаты указателя мыши

    public MouseEventsDemo() {
        addMouseListener(this);
        addMouseMotionListener(this);
        addWindowListener(new MyWindowAdapter());
    }

    // Обработать щелчок кнопкой мыши .
    @Override
    public void mouseClicked(MouseEvent e) {
        msg = msg + " click received";//  получен щелчок
        repaint();

    }

    // Обработать нажатие кнопки мыши .
    @Override
    public void mousePressed(MouseEvent e) {
        // Сохранить координаты.
        mouseX = e.getX();
        mouseY = e.getY();
        msg = " Button down";// Кнопка нажата
        repaint();
    }

    // Обработать отпускание кнопки мыши.
    @Override
    public void mouseReleased(MouseEvent e) {
        // Сохранить координаты.
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "Button Released"; // Кнопка отпущена
        repaint();
    }

    // Обработать наведение на окно указателя мыши .
    @Override
    public void mouseEntered(MouseEvent e) {
        mouseX = 100;
        mouseY = 100;
        msg = "Mouse entered";// Указатель мыши наведен на окно
        repaint();
    }

    // Обработать покидание окна указателем мыши.
    @Override
    public void mouseExited(MouseEvent e) {
        mouseX = 100;
        mouseY = 100;
        msg = "Mouse exited"; // Указатель мыши покинул окно
        repaint();
    }

    // Обработать перетаскивание указателя мыши .
    @Override
    public void mouseDragged(MouseEvent e) {
        // Сохранить координаты.
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "*" + " mouse at " + mouseX + ", " + mouseY; // * курсор мыши находится в позиции
        repaint();
    }

    // Обработать перемещение указателя мыmи .
    @Override
    public void mouseMoved(MouseEvent e) {
        msg = "Moving mouse at " + e.getX() + ", " + e.getY();// Перемещение курсора мыши в
        repaint();
    }

    // Отобразить сообщение в текущей позиции Х, У окна .
    public void paint(Graphics g) {
        g.drawString(msg, mouseX, mouseY);
    }

    public static void main(String[] args) {
        MouseEventsDemo appwin = new MouseEventsDemo();
        appwin.setSize(new Dimension(300, 300));
        appwin.setTitle("MouseEventsDemo");
        appwin.setVisible(true);

    }
}
