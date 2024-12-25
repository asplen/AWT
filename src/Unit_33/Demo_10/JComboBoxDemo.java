package Unit_33.Demo_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JComboBoxDemo {
    //Лишние пробелы могут испортить код
    String[] timepieces = {"Hourglass", "Analog", "Digital", "Stopwatch"};

    public JComboBoxDemo() {
        // Настроить JFrame .
        JFrame jfrm = new JFrame(" JComЬBoxDemo");
        jfrm.setLayout(new FlowLayout());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(400, 250);

        // Создать комбинированный список и добавить его в панель содержимого.
        JComboBox<String> jcb = new JComboBox<String>(timepieces);
        jfrm.add(jcb);

        // Создать метку и добавить ее в панель содержимого.
        JLabel jlab = new JLabel(new ImageIcon("src/img/hourglass.png"));
        jfrm.add(jlab);

        // Обработать события выбора.
        jcb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = (String) jcb.getSelectedItem();
                jlab.setIcon(new ImageIcon("src/img/" + s + ".png"));
            }
        });
        // Отобразить фрейм.
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JComboBoxDemo();
            }
        });
    }
}
