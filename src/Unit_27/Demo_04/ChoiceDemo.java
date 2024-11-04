package Unit_27.Demo_04;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/*
Создания двух меню Choice.
Одно позволяет выбрать операционную систему, а другое - браузер.

Демонстрация использования меню типа Choice.
 */
public class ChoiceDemo extends Frame implements ItemListener {
    Choice os, browser;
    String msg = "";


    public ChoiceDemo() {
        // Использовать поточную компоновку.
        setLayout(new FlowLayout());
        // Создать списки выбор.
        os = new Choice();
        browser = new Choice();
        // Добавить элементы в список os.
        os.add("Windows");
        os.add("Android");
        os.add("Linux");
        os.add("Mac OS");
        // Добавить элементы в список browser.
        browser.add("Edge");
        browser.add("Firefox");
        browser.add("Chrome");
        //Добавить списки выбора во фрейм.
        add(os);
        add(browser);
        //Добавить прослушиватели событий элементов.
        os.addItemListener(this);
        browser.addItemListener(this);

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

    // Отобразить элементы, выбранные в текущий момент.
    public void paint(Graphics g) {
        msg = "Current OS: ";
        // Текущая операционная система
        msg += os.getSelectedItem();
        g.drawString(msg, 20, 120);
        msg = "Current Browser: ";
        // Текущий брауэер
        msg += browser.getSelectedItem();
        g.drawString(msg, 20, 140);
    }

    public static void main(String[] args) {
        ChoiceDemo demo = new ChoiceDemo();

        demo.setVisible(true);
        demo.setTitle("Choice Demo");
        demo.setSize(new Dimension(240,180));

    }
}
