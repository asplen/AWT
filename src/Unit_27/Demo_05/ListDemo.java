package Unit_27.Demo_05;

import java.awt.*;
import java.awt.event.*;
/*
В показанном далее примере элементы управления Choice
 из предыдущего раздела преобразуются в компоненты List
  - один с множественным выбором
  - другой с одиночным выбором:

 */
public class ListDemo extends Frame implements ActionListener {
    List os, browser;
    String msg = "";

    public ListDemo() {
        // Использовать поточную компоновку.
        setLayout(new FlowLayout());
        // Создать список с множественным выбором.
        os = new List(4, true);
        // Создать список с одиночным выбором.
        browser = new List(4);

        // Добавить элементы в список os.
        os.add("Windows");
        os.add("Android");
        os.add("Linux");
        os.add("Mac OS");

        // Добавить элементы в список browser.
        browser.add("Edge");
        browser.add("Firefox");
        browser.add("Chrome");

        // Установить начальный выбор.
        os.select(1);
        os.select(0);
        os.select(2);

        browser.select(1);
        browser.select(0);
        browser.select(2);
        // Добавить списки во фрейм.
        add(os);
        add(browser);

        // Добавить прослушиватели событий действий.
        os.addActionListener(this);
        browser.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Перерисовка окна для обновления отображаемого текста
        repaint();
    }


    // Отобразить элементы, выбранные в текущий момент.
    public void paint(Graphics g) {
        //Текущая операционная система
        msg = "Current OS: ";
        int[] idx = os.getSelectedIndexes(); // Получаем индексы выбранных элементов
        for (int j : idx) {
            msg += os.getItem(j) + "   "; // Добавляем выбранные ОС
        }
        g.drawString(msg, 20, 120);
        // Текущий браузер
        msg = "Current Browser: " + browser.getSelectedItem() + "   ";

        // Выводим сообщение на экран
        g.drawString(msg, 20, 140);

    }

    public static void main(String[] args) {
        ListDemo demo = new ListDemo();

        demo.setVisible(true);
        demo.setSize(new Dimension(300, 300));
        demo.setTitle("ListDemo");
    }
}
