package Unit_27.Demo_02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/*
Распознавание объектов Button.

В данной версии программы при добавлении кнопки во фрейм ссылка на
нее сохраняется в массиве (метод add () возвращает ссылку
на добавляемую кнопку)
Внутри метода actionPerformed () с применением
этого массива выясняется, на какой кнопке был совершен щелчок.
В простых программах распознавать кнопки обычно легче по их меткам.
Однако если планируется изменение меток внутри кнопок во время
выполнения или в программе используются кнопки с одинаковыми метками, то
может оказаться проще определить, на какой кнопке был произведен щелчок, с
применением ссылки на ее объект.
Кроме того, строку с командой действия
кнопки можно установить в значение, отличающееся от ее метки, с помощью
метода setActionCommand (), который изменяет строку с командой
действия, но не влияет на строку, используемую для метки кнопки.
Таким образом, установка строки с командой действия позволяет различать команду
действия и метку кнопки.
 */
public class ButtonList extends Frame implements ActionListener {
    String msg = "";
    Button[] buttons = new Button[3];

    public ButtonList() {
        // Использовать поточную компоновку.
        setLayout(new FlowLayout());
        // Создать несколько кнопок.
        Button yes = new Button("Yes");
        Button no = new Button("No");
        Button maybe = new Button("Undecided");

        // Сохранить ссылки на добавленные кнопки.
        buttons[0] = (Button) add(yes);
        buttons[1] = (Button) add(no);
        buttons[2] = (Button) add(maybe);

        // Зарегистрировать прослушиватели для получения событий действий.
        for (int i = 0; i < 3; i++) {
            buttons[i].addActionListener(this);
        }

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // Обработать события действий для кнопок.
    public void actionPerformed(ActionEvent e) {
        for (Button button : buttons) {
            if (e.getSource() == button) {
                msg = "You pressed " + button.getLabel();
                // Щелчок на кнопке ...
            }
        }
        repaint();
    }

    public void paint(Graphics g) {
        g.drawString(msg, 20, 100);
    }

    public static void main(String[] args) {
        ButtonList b = new ButtonList();

        b.setVisible(true);
        b.setTitle("Button List");
        b.setSize(250, 150);
    }
}
