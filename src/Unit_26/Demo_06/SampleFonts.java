package Demo_06;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/*
В приведенной программе выводятся образцы стандартных шрифтов.
Каждый раз, когда совершается щелчок кнопкой мыши в окне программы,
выбирается новый шрифт и отображается его имя.
*/
public class SampleFonts extends Frame {
    int next = 0;
    Font f;
    String msg;

    SampleFonts() {
        f = new Font("Dialog ", Font.PLAIN, 12);
        msg = " Dialog ";
        setFont(f);

        addMouseListener(new MyMouseAdapter(this));

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        g.drawString(msg, 20, 60);
    }

    public static void main(String[] args) {
        SampleFonts frame = new SampleFonts();
        frame.setTitle("Sample Fonts");
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
