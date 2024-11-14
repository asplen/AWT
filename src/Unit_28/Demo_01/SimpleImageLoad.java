package Unit_28.Demo_01;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

/*
Загружается и отображается одиночное изображение. Вместо
файла Lilies.jpg можно указать любое предпочитаемое изображение
(при условии, что оно находится в том же каталоге, что и программа)
 */
public class SimpleImageLoad extends Frame {
    Image img;

    public SimpleImageLoad() {
        try {
            File imageFile = new File("Lilies.jpg");//находится в том же каталоге, что и программа
            // Загрузить изображение.
            img = ImageIO.read(imageFile);
        } catch (IOException ехс) {
            System.out.println("He удалось Загрузить файл изображения. ");
            System.exit(0);
        }

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        g.drawImage(img, getInsets().left, getInsets().top, null);
    }

    public static void main(String[] args) {
        SimpleImageLoad demo = new SimpleImageLoad();

        demo.setSize(new Dimension(400, 365));
        demo.setVisible(true);
        demo.setTitle("Simple Image Load");
//        demo.repaint();
    }
}
