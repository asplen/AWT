package Unit_33.Demo_07;

import javax.swing.*;
import java.awt.*;

// Класс для вкладки "Colors"
class ColorsPanel extends JPanel {
    public ColorsPanel() {
        // Добавляем флажки с названиями цветов
        JCheckBox checkBox1 = new JCheckBox("Red");
        JCheckBox checkBox2 = new JCheckBox("Blue");
        JCheckBox checkBox3 = new JCheckBox("Green");

        add(checkBox1);
        add(checkBox2);
        add(checkBox3);
    }
}
