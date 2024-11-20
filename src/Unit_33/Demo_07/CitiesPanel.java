package Unit_33.Demo_07;

import javax.swing.*;
import java.awt.*;

// Класс для вкладки "Cities"
public class CitiesPanel extends JPanel {
    public CitiesPanel() {
//        setLayout(new FlowLayout()); // Устанавливаем FlowLayout

        // Добавляем кнопки с названиями городов
        JButton button1 = new JButton("New York");
        JButton button2 = new JButton("Los Angeles");
        JButton button3 = new JButton("Chicago");
        JButton button4 = new JButton("Houston");

        add(button1);
        add(button2);
        add(button3);
        add(button4);
    }
}
