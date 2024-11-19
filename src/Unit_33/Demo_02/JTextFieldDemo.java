package Unit_33.Demo_02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Демонстрация использования JTextField .
public class JTextFieldDemo {
    public JTextFieldDemo() {
        JFrame frame = new JFrame("JTextFieldDemo");//настроить JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(260, 120);

        JTextField textField = new JTextField(15);// Добавить текстовое поле в панель содержимого.
        frame.add(textField);

        JLabel label = new JLabel();
        frame.add(label);// Добавить метку.

        // Обработать события действий.
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText(textField.getText());
            }
        });
        frame.setVisible(true);// Отобразить фрейм.
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JTextFieldDemo::new);//краткая запись!
        //вместо
// Создать фрейм в потоке диспетчеризации событий .
//        SwingUtilities.invokeLater(
//                new Runnable() {
//                    public void run() {
//                        new JTextFieldDemo();
//                    }
//                }
//        );
    }
}