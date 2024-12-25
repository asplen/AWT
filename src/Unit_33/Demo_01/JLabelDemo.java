package Unit_33.Demo_01;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class JLabelDemo {
    public JLabelDemo() {
        JFrame frame = new JFrame("JLabelDemo");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize (400, 400);

        ImageIcon ii = new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/hourglass.png")));// Создать значок.

        // Создать метку.
        JLabel j1 = new JLabel ( "Hourglass", ii, JLabel . CENTER) ;

        frame.add (j1) ;// Добавить метку в панель содержимого.

        frame.setVisible (true); ;// Отобразить фрейм.
    }

    public static void main(String[] args) {
        // Создать фрейм в потоке диспетчеризации событий.

//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new JLabelDemo();
//            }
//        });

//        SwingUtilities.invokeLater(() -> new JLabelDemo());//краткая запись!

        SwingUtilities.invokeLater(JLabelDemo::new);//краткая запись!
    }
}
