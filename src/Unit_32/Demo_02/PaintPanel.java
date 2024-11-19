package Unit_32.Demo_02;
// Рисование линий внутри панели.

import javax.swing.*;
import java.awt.*;
import java.util.Random;

// Этот класс расширяет JPanel. В нем переопределяется метод
// paintComponent(), чтобы рисовать линии на поверхности панели.
public class PaintPanel extends JPanel {
    Insets ins; // хранит размеры границы панели
    Random rand; // используется для генерации случайных чисел


    // Создать панель.
    PaintPanel() {
        // Разместить рамку вокруг панели.
        setBorder(BorderFactory.createLineBorder(Color.RED, 5));
        rand = new Random();
    }

    // Переопределить метод paintComponent().
    protected void paintComponent(Graphics g) {
        // Всегда первым вызывать метод cуперкласса.
        super.paintComponent(g);
        int x, y, x2, y2;
        // Получить высоту и ширину компонента.
        int height = getHeight();
        int width = getWidth();
        // Получить размеры границы.
        ins = getInsets();
        // Нарисовать десять линий со случайным образом
        // сгенерированными конечными точками.
        for (int i = 0; i < 10; i++) {

            // Получить случайные координаты, определяющие
            // конечные точки каждой линии.
            x = rand.nextInt(width - ins.left);
            y = rand.nextInt(height - ins.bottom);
            x2 = rand.nextInt(width - ins.left);
            y2 = rand.nextInt(height - ins.bottom);
            g.setColor(Color.blue);

            g.drawLine(x, y, x2, y2);// Нарисовать линию.
        }
    }
}