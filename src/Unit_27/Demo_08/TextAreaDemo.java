package Unit_27.Demo_08;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/*
Демонстрация использования TextArea
 */
public class TextAreaDemo extends Frame {

    public TextAreaDemo() {
        setLayout(new FlowLayout());
        String val =
                """
                         Lorem ipsum dolor sit amet consectetur adipisicing elit. \
                        
                        Animi perferendis tenetur eaque ipsam, quo natus deserunt atque pariatur illum\
                        
                         necessitatibus autem eligendi, dolorum fugiat? Tempore necessitatibus \
                        
                        quisquam ex. Inventore, iusto.\
                        
                        Animi perferendis tenetur eaque ipsam, quo natus deserunt atque pariatur illum\
                        
                         necessitatibus autem eligendi, dolorum fugiat? Tempore necessitatibus \
                        
                        quisquam ex. Inventore, iusto.\
                        
                        Animi perferendis tenetur eaque ipsam, quo natus deserunt atque pariatur illum\
                        
                         necessitatibus autem eligendi, dolorum fugiat? Tempore necessitatibus \
                        
                        quisquam ex. Inventore, iusto.""";

        TextArea text = new TextArea(val, 5, 30);
        add(text);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        TextAreaDemo frame = new TextAreaDemo();

        frame.setTitle("TextArea Demo");
        frame.setSize(new Dimension(300, 220));
        frame.setVisible(true);
    }
}
