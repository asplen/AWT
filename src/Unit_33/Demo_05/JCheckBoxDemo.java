package Unit_33.Demo_05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JCheckBoxDemo implements ItemListener {
    JLabel label;

    public JCheckBoxDemo() {
        // Настроить JFrame.
        JFrame frame = new JFrame("JCheckBoxDemo");
        frame.setSize(250, 100);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Добавить флажки в панель содержимого.
        JCheckBox checkBox = new JCheckBox("C");
        checkBox.addItemListener(this);
        frame.add(checkBox);

        checkBox = new JCheckBox("C++");
        checkBox.addItemListener(this);
        frame.add(checkBox);

        checkBox = new JCheckBox("Java");
        checkBox.addItemListener(this);
        frame.add(checkBox);

        checkBox = new JCheckBox("Perl");
        checkBox.addItemListener(this);
        frame.add(checkBox);

        // Создать метку и добавить ее в панель содержимого.
        label = new JLabel("Select laпguages");// Выберите языки
        frame.add(label);

        frame.setVisible(true);// Отобразить фрейм.
    }

    // Обработать события элементов для флажков.
    @Override
    public void itemStateChanged(ItemEvent e) {
        JCheckBox checkBox = (JCheckBox) e.getItem();

        if (checkBox.isSelected()) {
            label.setText(checkBox.getText() + " is selected");// отмечен
        } else label.setText(checkBox.getText() + " is cleared");//не отмечен
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JCheckBoxDemo::new);
    }
}
