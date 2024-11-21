package Unit_33.Demo_08;

import javax.swing.*;
import java.awt.*;

public class JScrollPaneDemo {
    public JScrollPaneDemo() {
        JFrame frame = new JFrame("JScrollPaneDemo");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создать панель и добавить к ней 400 кнопок.
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(20, 20));
        int b = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                jp.add(new JButton("Button " + b));
                ++b;
            }
        }
        // Создать панель прокрутки.
        JScrollPane jScrollPane = new JScrollPane(jp);

        // Добавить панель прокрутки в панель содержимого.
        // Из-за применения стандартной компоновки панель
        // прокрутки добавится в центральную область.
        frame.add(jScrollPane, BorderLayout.CENTER);
        // Отобразить фрейм.
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JScrollPaneDemo::new);
    }
}
