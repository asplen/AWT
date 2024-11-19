package Unit_32.Demo_02;

import javax.swing.*;

public class PaintDemo {
    PaintPanel pp;

    PaintDemo() {
        // Создать контейнер JFrame.
        JFrame jfrm = new JFrame("Paint Demo ");// Демонстрация рисования
        // Установить начальные размеры фрейма.
        jfrm.setSize(200, 150);
        // Закончить работу, когда пользователь закрывает приложение.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Создать панель для: рисования:.
        pp = new PaintPanel();
        // Добавить созданную панель в панель содержимого. Из-за использования
        // стандартной граничной компоновки панель будет автоматически
        // подгоняться, чтобы уместиться в центральной области.
        jfrm.add(pp);
        jfrm.setVisible(true);// Отобразить фрейм.
    }

    public static void main(String[] args) {
        // Создать фрейм в потоке диспетчеризации событий.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PaintDemo();
            }
        });
    }
}
