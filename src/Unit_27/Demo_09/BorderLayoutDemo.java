package Unit_27.Demo_09;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
 Демонстрация использования BorderLayout.
 */
public class BorderLayoutDemo extends Frame {
    public BorderLayoutDemo() {
        // В данном случае BorderLayout применяется по умолчанию.

        // Установить фоновый цвет, чтобы вставки было легко заметить.
        setBackground(Color.cyan);

        setLayout ( new BorderLayout () );

        // Это располагается вверху.
        add(new Button("This is across the top."), BorderLayout.NORTH);
        // Здесь может находиться нижний колонтитул.
        add(new Label("The footer message might go here . "), BorderLayout.SOUTH);
        // Это располагается справа
        add(new Button("Right"), BorderLayout.EAST);
        // Это располагается слева
        add(new Button("Left"), BorderLayout.WEST);

        String msg = "The reasonable man adapts " +
                "himself to the world;\n" +
                "the unreasonable one persists iп " +
                "tryiпg to adapt the world to himself .\n" +
                "Therefore all progress depends " +
                "\" on the unreasonable man." +
                "\" - George Bernard Shaw";
// Рациональный человек приспосабливается к миру,
// безрассудный же упорно пытается приспособить мир к себе.
// Поэтому весь прогресс зависит от безрассудных людей.
// - Джордж Бернард Шоу
        add(new TextArea(msg), BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Переопределить метод getInsets() , чтобы добавить значения вставок.

        }
    // Переопределить метод getInsets() , чтобы добавить значения вставок.
    public Insets getInsets() {
        return new Insets(40, 20, 10, 20);
    }

    public static void main(String[] args) {
        BorderLayoutDemo demo = new BorderLayoutDemo();

        demo.setVisible(true);
        demo.setSize(new Dimension(300, 220));
        demo.setTitle("BorderLayoutDemo");
    }
}
