package Unit_32.Demo_01;

import javax.swing.*;
//Пакет java.awt необходим т.к. содержит класс FlowLayout, который поддерживает стандартный
// диспетчер потоковой компоновки, применяемый для размещения компонентов внутри фрейма
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Обработка события в nрограмме Swing .
public class EventDemo {
    JLabel jLabel;

    EventDemo() {
        JFrame frame = new JFrame("An Event Example");// Пример обработки события
        // Задать диспетчер компоновки FlowLayout.
        frame.setLayout(new FlowLayout());
        // Установить начальные размеры фрейма.
        frame.setSize(220, 90);
        // Закончить работу, когда пользователь закрывает приложение.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Создать две кнопки.
        JButton jButtonA = new JButton("Alpha");
        JButton jButtonB = new JButton(" Beta");
        // Добавить прослушиватель событий действий для кнопки Alpha.
        //В классе JВutton также есть метод removeActionListener (), позволяющий удалить прослушиватель, но
        //в программе он не применяется.
        jButtonA.addActionListener(new ActionListener() {
            //в интерфейсе ActionListener определен только один метод: actionPerformed ()
            public void actionPerformed(ActionEvent ae) {
                jLabel.setText("Alpha was pressed . ");// Нажата кнопка Alpha
            }
        });
//        jButtonA.addActionListener((e) -> jLabel.setText("Alpha was pressed . "));

        //Для предоставления обработчиков событий двух кнопок используются
        //анонимные внутренние классы.
        // При каждом нажатии кнопки строка в метке
        //jLabel изменяется, чтобы отразить, какая кнопка была нажата.
        jButtonB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                jLabel.setText(" Beta was pressed . ");// Нажата кнопка Beta
            }
        });

        // Добавить кнопки в панель содержимого.
        frame.add(jButtonA);
        frame.add(jButtonB);

        // Создать текстовую метку.
        jLabel = new JLabel("Press а button . ");
        // Добавить метку в панель содержимого.
        frame.add(jLabel);
        // Отобразить фрейм.
        frame.setVisible(true);
    }
//Если в результате возникновения события необходимо выполнить что-то,
//требующее много времени, то придется
//задействовать отдельный поток.
    public static void main(String[] args) {
        // Создать фрейм в потоке диспетчеризации событий.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EventDemo();
            }
        });

//        SwingUtilities.invokeLater(() -> new EventDemo());//краткая запись!

    }
}
