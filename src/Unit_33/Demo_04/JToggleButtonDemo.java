package Unit_33.Demo_04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

// Демонстрация использования JToggleButton.
public class JToggleButtonDemo {
    public JToggleButtonDemo() {
        // Настроить JFrame.
        JFrame frame = new JFrame("JToggleButtonDemo");
        frame.setSize(400, 100);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //создать метку
        JLabel label = new JLabel("Нажми на кнопку.");// Кнопка выключена
        //создать переключатель
        JToggleButton toggleButton = new JToggleButton("я_Кнопка");

        // Добавить прослушиватель событий элементов для переключателя.
        toggleButton.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (toggleButton.isSelected()) {
                    toggleButton.setText("включена");// Кнопка включена
                } else toggleButton.setText("выключена.");// Кнопка выключена
            }
        });

        // Добавить переключатель и метку в панель содержимого
        frame.add(label);
        frame.add(toggleButton);

        frame.setVisible(true);// Отобразить фрейм.
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JToggleButtonDemo::new);
    }
}
