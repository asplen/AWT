package Unit_33.Demo_06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JRadioButtonDemo implements ActionListener {
    JLabel label;

    public JRadioButtonDemo() {
        // Настроить JFrame.
        JFrame frame = new JFrame("JRadioButtonDemo");
        frame.setSize(250, 100);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создать переключатели и добавить их в панель содержимого.
        JRadioButton button1 = new JRadioButton("Button A");
        button1.addActionListener(this);
        frame.add(button1);

        JRadioButton button2 = new JRadioButton("Button B");
        button2.addActionListener(this);
        frame.add(button2);

        JRadioButton button3 = new JRadioButton("Button C");
        button3.addActionListener(this);
        frame.add(button3);

        // Определить группу переключателей.
        ButtonGroup group = new ButtonGroup();
        group.add(button1);
        group.add(button2);
        group.add(button3);

        // Создать метку и добавить ее в панель содержимого.
        label = new JLabel("Select One: ");
        frame.add(label);

        frame.setVisible(true);

    }

    // Обработать выбор кнопок.
    @Override
    public void actionPerformed(ActionEvent e) {
        label.setText("You selected:___ " + e.getActionCommand());
    }

    public static void main(String[] args) {
        // Создать фрейм в потоке диспетчеризации событий.
        SwingUtilities.invokeLater(JRadioButtonDemo::new);
    }
}
