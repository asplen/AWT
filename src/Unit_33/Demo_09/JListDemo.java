package Unit_33.Demo_09;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class JListDemo {
    // Создать список городов.
    String[] cities = {"New York", "Chicago ", "Houston ",
            "Denver", "Los Angeles", "Seattle",
            "London ", "Paris", "New Delhi",
            "Hong Kong ", "Tokyo", "Sydney"};

    public JListDemo() {
        // Настроить JFrame .
        JFrame jfrm = new JFrame("JListDemo");
        jfrm.setLayout(new FlowLayout());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(200, 200);
        // Создать JList.
        JList<String> jlst = new JList<String>(cities);

        // Установить режим выбора списка в одиночный выбор.
        jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // Добавить список в прокручиваемую панель.
        JScrollPane jscrlp = new JScrollPane(jlst);
        // Установить предпочитаемые размеры прокручиваемой панели.
        jscrlp.setPreferredSize(new Dimension(120, 90));
        // Создать метку, которая будет отображать выбор.
        JLabel jlab = new JLabel("Choose а City"); //Выберите город

        // Добавить прослушиватель событий выбора для списка.
        jlst.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent le) {
                // Получить индекс измененного элемента.
                int idx = jlst.getSelectedIndex();
                // Если элемент был выбран, тогда отобразить выбор.
                if (idx != -1) {
                    jlab.setText("Current selection : " + cities[idx]);// текущий выбор
                } else {
                    jlab.setText("Choose а Citу");// в противном случае запросить выбор заново.
                }
            }
        });
        // Добавить список и метку в панель содержимого.
        jfrm.add(jscrlp);
        jfrm.add(jlab);
        // Отобразить фрейм.
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JListDemo::new);
    }
}
