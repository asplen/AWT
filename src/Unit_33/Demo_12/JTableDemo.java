package Unit_33.Demo_12;

import javax.swing.*;

//Демонстрация использования JTable.
public class JTableDemo {
    // Инициализировать заголовки колонок.
    String[] colHeads = {"Name", "Extension", "ID#"};

    // Инициализировать данные.
    Object[][] data = {
            {"Gail", "4567", "865"},
            {"Ken", "7566", "555"},
            {"Viviane", "5634", "587"},
            {"Melanie", "7345", "922"},
            {"Anne", "1237 ", "333"},
            {"John", "5656", "314"},
            {"Matt", "5672", "217"},
            {"Claire", "6741", "444"},
            {"Erwin", "9023", "519"},
            {"Ellen", "1134 ", "532"},
            {"Jennifer", "5689", "112"},
            {"Ed", "9030", "133"},
            {"Helen", "6751", "145"}
    };

    public JTableDemo() {
        // Настроить JFrame. Использовать стандартную компоновку BorderLayout.
        JFrame jfrm = new JFrame("JTableDemo ");
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(300, 300);

        // Создать таблицу.
        JTable table = new JTable(data, colHeads);

        // Добавить таблицу в панель прокрутки.
        JScrollPane jsp = new JScrollPane(table);

        // Добавить панель прокрутки в панель содержимого.
        jfrm.add(jsp);

        // Отобразить фрейм.
        jfrm.setVisible(true);
    }
    public static void main(String[] args) {
        // Создать фрейм в потоке диспетчеризации событий.
        SwingUtilities.invokeLater(JTableDemo::new);
    }
}
