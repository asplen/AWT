package Unit_27.Demo_01;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/*
создаются метки, которые добавляются к объекту Frame
 */
public class LabelDemo extends Frame {

    public LabelDemo() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Использовать поточную компоновку.
        setLayout(new FlowLayout());

        Label one = new Label("One");
        Label two = new Label("Two");
        Label three = new Label("Three");
        Label four = new Label("Можно изменить размер окна и посмотреть на результат! ЭТОТ ТЕКСТ не разбивается и помещается в одну строку ");

        // Добавить метки во фрейм.
        add(one);
        add(two);
        add(three);
        add(four);
    }


    public static void main(String[] args) {
        LabelDemo w = new LabelDemo();

        w.setVisible(true);
        w.setSize(300, 100);
        w.setTitle("LabelDemo");
    }
}
