package Unit_27.Demo_09;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/*
 Создается двухуровневая колода карт, которая позволяет пользователю выбрать операционную систему.
 Внутри одной карты отображаются операционные системы на базе Windows, а внутри другой -
 операционные системы Мас OS, Android и Linux.
 */

public class CardLayoutDemo extends Frame {
    Checkbox windows10, windows7, windows8, android, linux, mac;
    Panel osCards;
    CardLayout cardLO;
    Button win, other;

    public CardLayoutDemo() {
        // Использовать поточную компоновку для главного фрейма.
        setLayout(new FlowLayout());

        win = new Button("Windows");
        other = new Button("Other");
        add(win);
        add(other);

        // Обеспечить применение в панели osCards компоновки CardLayout.
        cardLO = new CardLayout();
        osCards = new Panel();
        osCards.setLayout(cardLO);

        windows7 = new Checkbox("Windows 7", true);
        windows8 = new Checkbox("Windows 8");
        windows10 = new Checkbox("Windows 10 ");
        android = new Checkbox("Android");
        linux = new Checkbox("Linux");
        mac = new Checkbox("Mac OS");

        // Добавить в панель флажки для операционных систем семейства Windows.
        Panel winPan = new Panel();
        winPan.add(windows7);
        winPan.add(windows8);
        winPan.add(windows10);

        // Добавить в панель флажки для других операционных систем.
        Panel otherPan = new Panel();
        otherPan.add(android);
        otherPan.add(linux);
        otherPan.add(mac);

        // Добавить панели в панель колоды карт.
        osCards.add(winPan, "Windows");
        osCards.add(otherPan, "Other");

        // Добавить карты в панель главного фрейма.
        add(osCards);

        // Использовать лямбда-выражения для обработки кнопочных событий.
        win.addActionListener((ае) -> cardLO.show(osCards, "Windows"));
        other.addActionListener((ae) -> cardLO.show(osCards, "Other"));

        // Зарегистрировать события нажатия кнопки мыши.
        addMouseListener (new MouseAdapter()  {
            // Совершить проход по панелям.
            public void mousePressed (MouseEvent me){
                cardLO.next(osCards);
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        CardLayoutDemo demo = new CardLayoutDemo();

        demo.setTitle("CardLayoutDemo");
        demo.setVisible(true);
        demo.setSize(new Dimension(300,220));
    }
}
