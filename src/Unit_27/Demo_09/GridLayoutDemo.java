package Unit_27.Demo_09;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/*
создается сетка 4х4, которая заполняется
15 кнопками с пометкой каждой кнопки своим индексом
 */
public class GridLayoutDemo extends Frame {
    static final int n = 4;

    public GridLayoutDemo() {
        // Использовать GridLayout .
        setLayout(new GridLayout(n, n));
        setFont(new Font("SansSerif", Font.BOLD, 24));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k = i * n + j;
                if (k > 0)
                    add(new Button("" + k));
            }
        }
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        GridLayoutDemo demo = new GridLayoutDemo();

        demo.setVisible(true);
        demo.setTitle("Grid Layout Demo");
        demo.setSize(new Dimension(300, 300));
    }
}