package Unit_27.Demo_11;

import java.awt.*;
import java.awt.event.*;

public class MenuDemo extends Frame {
    String msg = "";
    CheckboxMenuItem debug, test;

    public MenuDemo() {
        // Создать панель меню и добавить ее во фрейм.
        MenuBar menuBar = new MenuBar();
        setMenuBar(menuBar);

        // Создать пункты меню.
        Menu file = new Menu("File");// Файл
        MenuItem item1, item2, item3, item4, item5;
        file.add(item1 = new MenuItem("New"));// Создать
        file.add(item2 = new MenuItem("Open"));// Открыть
        file.add(item3 = new MenuItem("Close"));// Закрыть
        file.add(item4 = new MenuItem("----"));
        file.add(item5 = new MenuItem("Quit"));// Выйти

        menuBar.add(file);

        MenuItem item6, item7, item8, item9;

        Menu edit = new Menu("Edit");// Правка
        edit.add(item6 = new MenuItem("Cut"));// Вырезать
        edit.add(item7 = new MenuItem("Copy"));// Скопировать
        edit.add(item8 = new MenuItem("Paste "));// Вставить
        edit.add(item9 = new MenuItem("---"));
        Menu sub = new Menu("Special");// Сервис
        MenuItem item10, item11, item12;
        sub.add(item10 = new MenuItem("First"));// Первый
        sub.add(item11 = new MenuItem("Second"));// Второй
        sub.add(item12 = new MenuItem("Third"));// Третий
        edit.add(sub);
        // Создать переключаемые пункты меню.
        debug = new CheckboxMenuItem("Debug");// Отладка
        edit.add(debug);
        test = new CheckboxMenuItem("Testing");// Тестирование
        edit.add(test);

        menuBar.add(edit);

        // Создать объект для обработки событий действий и элементов.
        MyMenuHandler handler = new MyMenuHandler();
        // Зарегистрировать для получения этих событий.
        item1.addActionListener(handler);
        item2.addActionListener(handler);
        item3.addActionListener(handler);
        item4.addActionListener(handler);
        item6.addActionListener(handler);
        item7.addActionListener(handler);
        item8.addActionListener(handler);
        item9.addActionListener(handler);
        item10.addActionListener(handler);
        item11.addActionListener(handler);
        item12.addActionListener(handler);
        debug.addItemListener(handler);
        test.addItemListener(handler);

        // Использовать лямбда-выражение для обработки выбора пункта Quit.
        item5.addActionListener((ае) -> System.exit(0));
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        g.drawString(msg, 10, 220);
        if (debug.getState()) g.drawString("Debug is on.", 10, 240);// Пункт Debug отмечен.
        else g.drawString("Debug is off.", 10, 240);// Пункт Debug не отмечен.
        if (test.getState()) g.drawString("Testing is on.", 10, 260);// // Пункт Testing отмечен.
        else g.drawString("Testing is off.", 10, 260); // Пункт Testing не отмечен
    }

    // Внутренний класс для обработки событий действий и элементов в меню.
    public class MyMenuHandler implements ActionListener, ItemListener {

        // Обработать события действий.
        @Override
        public void actionPerformed(ActionEvent e) {
            msg = "You selected "; // Выбран пункт меню

            String arg = e.getActionCommand();
            switch (arg) {
                case "New" -> msg += "New.";
                case "Open" -> msg += "Open.";
                case "Close" -> msg += "Close.";
                case "Edit" -> msg += "Edit.";
                case "Cut" -> msg += "Cut.";
                case "Copy" -> msg += "Сору.";
                case "Paste" -> msg += "Paste.";
                case "First" -> msg += "First.";
                case "Second" -> msg += "Second.";
                case "Third" -> msg += "Third.";
                case "Debug" -> msg += "Debug.";
                case "Testing" -> msg += "Testing .";
            }
            repaint();
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            repaint();
        }
    }

    public static void main(String[] args) {
        MenuDemo demo = new MenuDemo();

        demo.setVisible(true);
        demo.setSize(new Dimension(250, 300));
        demo.setTitle("Menu Demo");
    }
}
