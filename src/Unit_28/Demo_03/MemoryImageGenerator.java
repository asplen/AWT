package Unit_28.Demo_03;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.MemoryImageSource;

/*
Создается объект MemoryImageSource с использованием вариации
простого алгоритма (побитового исключающего ИЛИ координат Х и У каждого пикселя)

 Создание изображения в памяти.

Данные для нового объекта MemoryImageSource создаются в конструкторе.
Для хранения значений пикселей предусмотрен массив целых чисел, а
сами данные генерируются во вложенных циклах for, где значения r, g и Ь
сдвигаются, представляя пиксель в массиве pixels. Наконец, вызывается
метод createImage (), которому в качестве параметра передается новый
экземпляр MemoryImageSource, созданный из низкоуровневых данных пикселей.
 */
public class MemoryImageGenerator extends Frame {
    Image img;
    int w = 512;
    int h = 512;

    public MemoryImageGenerator() {
        int[] pixels = new int[w * h];
        int i = 0;

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int r = (x ^ y) & 0xff;
                int g = (x * 2 ^ y * 2) & 0xff;
                int b = (x * 4 ^ y * 4) & 0xff;
                pixels [i++] = (255 << 24) | ( r <<16) | (g << 8 ) | b;
            }
        }
        img = createImage (new MemoryImageSource(w, h, pixels , 0, w) );

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public void paint(Graphics g) {
        g.drawImage(img, getInsets ( ) .left, getInsets () . top, null);
    }

    public static void main(String[] args) {
        MemoryImageGenerator demo = new MemoryImageGenerator();

        demo.setVisible(true);
        demo.setTitle("Memory Image Generator");
        demo.setSize(new Dimension(512, 512));
    }
}
