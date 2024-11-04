package Unit_27.Demo_03;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/*
    Демонстрация группы флажков.
 Используются флажки, входящие в группу:
 (флажки теперь имеют круглую форму)
 */
public class CheckBoxGroup extends Frame implements ItemListener {
    String msg = "";
    Checkbox windows, android, linux, mac;
    CheckboxGroup cbg;

    public CheckBoxGroup() {
        // Использовать поточную компоновку.
        setLayout(new FlowLayout());
        // Создать группу флажков.
        cbg = new CheckboxGroup();
        // Создать флажки и включить их в группу.
        windows = new Checkbox("Windows", cbg, true);
        android = new Checkbox("Android", cbg, false);
        linux = new Checkbox("Linux", cbg, false);
        mac = new Checkbox("Маc OS", cbg, false);
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
        msg += cbg.getSelectedCheckbox().getLabel();
        g.drawString(msg, 20, 120);
    }

    public static void main(String[] args) {
        CheckBoxGroup demo = new CheckBoxGroup();

        demo.setVisible(true);
        demo.setTitle("CheckBoxGroup demo");
        demo.setSize(new Dimension(300, 300));
    }
}
