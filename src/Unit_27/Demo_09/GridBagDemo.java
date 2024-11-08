package Unit_27.Demo_09;

import java.awt.*;
import java.awt.event.*;
/*
В созданной компоновке флажки для операционных систем расположены
в сетке 2х2. Каждая ячейка имеет горизонтальное заполнение, равное 200.
Каждый компонент слева немного смещен (на 6 единиц).
Вес колонки установлен в 1, что приводит к равномерному распределению дополнительного
пространства по горизонтали между колонками.
В первой строке используется стандартный вес, равный О,
а во второй строке - вес 1. Таким образом,
любое дополнительное пространство по вертикали добавляется ко второй
строке.
 */
public class GridBagDemo extends Frame implements ItemListener {
    String msg = "";
    Checkbox windows, android, linux, mac;


    public GridBagDemo() {
        // Использовать GridBagLayout .
        GridBagLayout gbag = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbag);
        // Определить флажки.
        windows = new Checkbox("Windows ", true);
        android = new Checkbox("Android");
        linux = new Checkbox("Linux");
        mac = new Checkbox("Маc OS");
        // Определить гибкую сеточную компоновку.
        // Использовать стандартный вес строки, равный О, для первой строки.
        gbc.weightx = 1.0; // вес колонки, равный 1
        gbc.ipadx = 200; // заполнение на 200 единиц
        gbc.insets = new Insets(0, 6, 0, 0); // вставка немного слева

        gbc.anchor = GridBagConstraints.NORTHEAST;
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbag.setConstraints(windows, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbag.setConstraints(android, gbc);

        // Назначить второй строке вес, равный 1.
        gbc.weighty = 1.0;
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbag.setConstraints(linux, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbag.setConstraints(mac, gbc);

        // Добавить компоненты.
        add(windows);
        add(android);
        add(linux);
        add(mac);

        // Зарегистрировать прослушиватели для получения событий элементов.
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

    // Перерисовывать в случае изменения состояния какого-то флажка.
    @Override
    public void itemStateChanged(ItemEvent e) {
        repaint();
    }

    // Отобразить текущее состояние флажков.
    public void paint(Graphics g) {
        msg = "Current state: ";
        // Текущее состояние
        g.drawString(msg, 20, 100);
        msg = " Windows : " + windows.getState();
        g.drawString(msg, 30, 120);
        msg = " Android: " + android.getState();
        g.drawString(msg, 30, 140);
        msg = " Linux: " + linux.getState();
        g.drawString(msg, 30, 160);
        msg = " Маc OS : " + mac.getState();
        g.drawString(msg, 30, 180);
    }

    public static void main(String[] args) {
        GridBagDemo demo = new GridBagDemo();

        demo.setSize(new Dimension(300, 200));
        demo.setTitle("GridBagDemo");
        demo.setVisible(true);
    }
}





