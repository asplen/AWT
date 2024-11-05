package Unit_27.Demo_07;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/*
классическая экранная форма для ввода
имени пользователя и пароля:
 */
public class TextFieldDemo extends Frame implements ActionListener {
    TextField name, pass;

    public TextFieldDemo() {
        setLayout(new FlowLayout());

        // Создать элементы управления.
        Label namep = new Label(" Name : ", Label.RIGHT);//имя
        Label passp = new Label(" Password: ", Label.RIGHT);//пароль
        name = new TextField(12);
        pass = new TextField(8);
        pass.setEchoChar('*');
        // Добавить элементы управления во фрейм.
        add(namep);
        add(name);
        add(passp);
        add(pass);

        // Добавить прослушиватели событий действий.
        name.addActionListener(this);
        pass.addActionListener(this);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    // Пользователь нажал клавишу <Enter>.
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public void paint(Graphics g) {
        g.drawString("Name: " + name.getText(), 20, 100); // Имя
        g.drawString("Selected text in name: " + name.getSelectedText(), 20, 120); // Текст, выбранный в имени
        g.drawString(" Password: " + pass.getText(), 20, 140); // Пароль
    }

    public static void main(String[] args) {
        TextFieldDemo app = new TextFieldDemo();

        app.setSize(new Dimension(380, 180));
        app.setTitle("TextFieldDemo");
        app.setVisible(true);
    }
}
