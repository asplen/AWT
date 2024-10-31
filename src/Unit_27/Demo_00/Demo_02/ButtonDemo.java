package Unit_27.Demo_00.Demo_02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
Демонстрация использования кнопок.

Создаются три кнопки с метками "Yes" (Да), "No" (Нет) и "Undecided" (В раздумьях).
Щелчок на одной из них инициирует отображение сообщения о том, на какой кнопке он был совершен.
В этой версии команда действия кнопки (которой по умолчанию является ее метка)
используется для определения того, на какой кнопке делался щелчок. Для получения метки
необходимо вызвать метод getActionCommand() на объекте
ActionEvent, переданном в actionPerformed().
 */
public class ButtonDemo extends Frame implements ActionListener {
    String msg = "";
    Button yes, no, maybe;

    public ButtonDemo() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Использовать поточную компоновку.
        setLayout(new FlowLayout());

        // Создать несколько кнопок.
        yes = new Button("Yes");
        no = new Button("No");
        maybe = new Button("Undecided");
        // Добавить кнопки во фрейм.
        add(yes);// Да
        add(no);// Нет
        add(maybe);// В раздумьях


        // Добавить прослушиватели событий действий для кнопок.
        yes.addActionListener(this);
        no.addActionListener(this);
        maybe.addActionListener(this);
    }

    // Обработать события действий для кнопок.
    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();

        switch (str) {
            case "Yes" -> msg = "You pressed Yes.";// Щелчок на кнопке Yes
            case "No" -> msg = "You pressed No. ";// Щелчок на кнопке No
            case "Undecided" -> msg = "You pressed Undecided. ";// Щелчок на кнопке Undecided
        }
        repaint();
    }

    public void paint(Graphics g) {
        g.drawString(msg, 20, 100);
    }

    public static void main(String[] args) {
        ButtonDemo dw = new ButtonDemo();

        dw.setVisible(true);
        dw.setSize(250, 150);
        dw.setTitle("ButtonDemo");
    }
}
