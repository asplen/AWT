package Unit_28.Demo_05;

import java.awt.*;

/*
Класс LoadedImage - удобный подкласс Canvas, который ведет себя
надлежащим образом под управлением диспетчера компоновки, потому что
переопределяет методы getPreferredSize () и getMinimumSize ().

Кроме того, у него есть метод set( ), который можно применять для
установки нового объекта Image, подлежащего отображению на холсте.

Именно так отображается отфильтрованное изображение после завершения работы подключаемого фильтра.
 */
public class LoadedImage extends Canvas {
    Image img;

    public LoadedImage(Image i) {
        set(i);
    }

    void set(Image i) {
        img = i;
        repaint();
    }

    public void paint(Graphics g) {
        if (img == null) {
            g.drawString("no image", 10, 30);// изображение отсутствует
        } else {
            g.drawImage(img, 0, 0, this);
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(img.getWidth(this), img.getHeight(this));
    }

    public Dimension getMinimumSize() {
        return getPreferredSize();
    }
}
