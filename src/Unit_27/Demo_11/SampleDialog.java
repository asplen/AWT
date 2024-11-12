package Unit_27.Demo_11;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// Создать подкласс Dialog.
public class SampleDialog extends Dialog {

    SampleDialog(Frame parent, String title) {
        super(parent, title, false);

        setLayout(new FlowLayout());
        setSize(300, 200);
        add(new Label(" Press this button: ")); // Нажмите на эту кнопку
        Button button;
        add(button = new Button("Cancel"));

        button.addActionListener((ae) -> dispose());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void paint(Graphics g) {
        g.drawString("This is in the Dialog Box", 20, 80);// Строка в диалоговом окне
    }
}


