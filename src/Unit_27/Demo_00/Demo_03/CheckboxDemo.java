package Unit_27.Demo_00.Demo_03;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/*
 Демонстрация использования флажков
 создаются четыре флажка, первый из которых изначально отмечен.
 Состояние всех флажков отображается. При изменении
 состояния любого флажка отображение состояния обновляется.
 */
public class CheckboxDemo extends Frame implements ItemListener {
    String msg = "";
    Checkbox windows, android, linux, mac;

    public CheckboxDemo() {
        // Использовать поточную компоновку.
        setLayout(new FlowLayout());
        // Создать флажки.
        windows = new Checkbox("Windows ", true);
        android = new Checkbox("Android");
        linux = new Checkbox("Linux");
        mac = new Checkbox("Маc OS ");
        // Добавить флажки во фрейм.
        add(windows);
        add(android);
        add(linux);
        add(mac);
        // Добавить прослушиватели событий элементов.
        windows.addItemListener(this);
        android.addItemListener(this);
        linux.addItemListener(this);
        mac.addItemListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        repaint();
    }

    // Отобразить текущее состояние флажков.
    public void paint(Graphics g) {
        msg = " Current state : ";
        // Текущее состояние
        g.drawString(msg, 20, 120);

        msg = " Windows : " + windows.getState();
        g.drawString(msg, 20, 140);
        msg = " Android : " + android.getState();
        g.drawString(msg, 20, 160);
        msg = " Linux : " + linux.getState();
        g.drawString(msg, 20, 180);
        msg = " Маc OS : " + mac.getState();
        g.drawString(msg, 20, 200);
    }

    public static void main(String[] args) {
        CheckboxDemo demo = new CheckboxDemo();

        demo.setVisible(true);
        demo.setSize(new Dimension(300, 300));
        demo.setTitle("CheckboxDemo");
    }
}

