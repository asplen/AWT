package Unit_32.Demo_00;

import javax.swing.*;

/*
 Простое приложение Swing .
 */
public class SwingDemo {
    SwingDemo() {
        // Создать контейнер JFrame.
        JFrame jfrm = new JFrame("A Simple Swing Application");
        // начальные размеры фрейма.
        jfrm.setSize(600, 150);
        // Прекратить работу, когда пользователь закрывает приложение.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jfrm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//        jfrm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//        jfrm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Создать текстовую метку.
        JLabel jlab = new JLabel(" Swing позволяет строить мощные графические пользовательские интерфейсы");
        // Swing позволяет строить мощные графические пользовательские интерфейсы
        //  метку в панель содержимого.
        jfrm.add(jlab);
//        JLabel label2 = new JLabel(" Вторая СТРОКА! ");
//        jlab = label2;
//        jfrm.add(jlab);
        // Отобразить фрейм.
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
// Создать фрейм в потоке диспетчеризации событий.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SwingDemo();
            }
        });
    }
}
