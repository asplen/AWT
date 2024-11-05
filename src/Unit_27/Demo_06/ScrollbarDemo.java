package Unit_27.Demo_06;

import java.awt.*;
import java.awt.event.*;
/*
Создаются вертикальная и горизонтальная
полосы прокрутки и отображаются их текущие настройки.
При перетаскивании указателя мыши внутри окна координаты каждого события
перетаскивания применяются для обновления полос прокрутки.

В текущей позиции перетаскивания отображается символ звездочки.
 */
public class ScrollbarDemo extends Frame implements AdjustmentListener {
    String msg = "";
    Scrollbar vertical, horizontal;

    public ScrollbarDemo() {
        //Использовать поточную компоновку
        setLayout(new FlowLayout());

        // Создать полосы прокрутки, установить предпочитаемые размеры, добавить полосы прокрутки во фрейм
        vertical = new Scrollbar(Scrollbar.VERTICAL, 0, 1, 0, 200);
        vertical.setPreferredSize(new Dimension(20, 100));
        add(vertical);

        horizontal = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 100);
        horizontal.setPreferredSize(new Dimension(100, 20));
        add(horizontal);

        // Добавить прослушиватели событий корректировки для полос прокрутки.
        vertical.addAdjustmentListener(this);
        horizontal.addAdjustmentListener(this);

        // Добавить прослушиватели событий движения мыши.
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // Обновить полосы прокрутки, чтобы отразить
                // перетаскивание указателя мыши.
                int x = e.getX();
                int y = e.getY();
                vertical.setValue(y);
                horizontal.setValue(x);
                repaint();
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }


    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        repaint();
    }

    // Отобразить текущие значения полос прокрутки.
    public void paint(Graphics g) {
        msg = "Вертикаль: " + vertical.getValue()+
        ", Горизонталь: " + horizontal.getValue();

        g.drawString(msg, 20, 160);

     // Отобразить текущую позицию указателя мыши при перетаскивании.
        g.drawString("*", horizontal.getValue(), vertical.getValue());
    }

    public static void main(String[] args) {
        ScrollbarDemo demo = new ScrollbarDemo();

        demo.setTitle("ScrollbarDemo");
        demo.setSize(new Dimension(300,300));
        demo.setVisible(true);

    }
}
