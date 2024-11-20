package Unit_33.Demo_03;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class JButtonDemo implements ActionListener {
    JLabel label;

    JButtonDemo() {
        JFrame frame = new JFrame("JButton Demo");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 450);

        //добавить кнопки в панель содержимого
        ImageIcon hourglass = new ImageIcon(Objects.requireNonNull(getClass().getResource("hourglass.png")));// Создать значок.
        JButton jb = new JButton(hourglass);
        jb.setActionCommand("   Hourglass");// песочные часы
        jb.addActionListener( this);
        frame.add(jb);

        ImageIcon analog = new ImageIcon(Objects.requireNonNull(getClass().getResource("analog.png")));// Создать значок.
        jb = new JButton(analog);
        jb.setActionCommand("   Analog Clock");// стрелочные часы
        jb.addActionListener( this);
        frame.add(jb);

        ImageIcon digital = new ImageIcon(Objects.requireNonNull(getClass().getResource("digital.png")));// Создать значок.
        jb = new JButton(digital);
        jb.setActionCommand("   Digital Clock");//  цифровые часы
        jb.addActionListener(this);
        frame.add(jb);

        ImageIcon stopwatch = new ImageIcon(Objects.requireNonNull(getClass().getResource("stopwatch.png")));// Создать значок.
        jb = new JButton(stopwatch);
        jb.setActionCommand("   Stopwatch");//  секундомер
        jb.addActionListener( this);
        frame.add(jb);

        // Создать метку и добавить ее в панель содержимого.
        label = new JLabel("Choose а Timepiece");// Выберите часы

        frame.add(label);
        // Отобразить фрейм.
        frame.setVisible(true);
    }

    // Обработать события кнопок.
    public void actionPerformed(ActionEvent e) {
        label.setText("You selected :" + e.getActionCommand()); // Вы выбрали

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JButtonDemo::new);//краткая запись!

    }
}
