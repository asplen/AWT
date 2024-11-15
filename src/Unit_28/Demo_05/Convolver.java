package Unit_28.Demo_05;

import java.awt.*;
import java.awt.image.ColorModel;
import java.awt.image.ImageConsumer;
import java.awt.image.MemoryImageSource;

/*
Абстрактный класс Convolver поддерживает базовую обработку фильтра свертки,
реализуя интерфейс ImageConsumer для перемещения исходных
пикселей в массив по имени imgpixels.

Он также создает второй массив с именем newimgpixels для отфильтрованных данных.

Фильтры свертки производят выборку небольшого прямоугольника пикселей вокруг
каждого пикселя изображения, называемого ядром свертки.

Такая область размером 3х3 применяется в демонстрационной программе для
принятия решения о том, как изменить центральный пиксель в этой области.

На заметку! Причина, по которой фильтр не может модифицировать массив imgpixels на месте,
связана с тем, что следующий пиксель в строке развертки может попытаться использовать
первоначальное значение предыдущего пикселя, который мог оказаться только что
отфильтрованным.

Фильтр свертки
 */
abstract class Convolver implements ImageConsumer, PlugInFilter {
    int width, height;
    int[] imgpixels, newimgpixels;
    boolean imageReady = false;

    abstract void convolve(); // Здесь находится фильтр ...

    public Image filter(Frame f, Image in) {
        imageReady = false;
        in.getSource().startProduction(this);
        waitForImage();
        newimgpixels = new int[width * height];
        try {
            convolve();
        } catch (Exception e) {
            System.out.println("Отказ Convolver :" + e);
            e.printStackTrace();
        }
        return f.createImage(new MemoryImageSource(width, height, newimgpixels, 0, width));
    }

    synchronized void waitForImage() {
        try {
            while (!imageReady) wait();
        } catch (Exception e) {
            System.out.println("Interrupted"); // Прервано
        }
    }

    public void setProperties(java.util.Hashtable<?, ?> dummy) {
    }

    public void setColorModel(ColorModel dummy) {
    }

    public void setHints(int dummy) {
    }

    public synchronized void imageComplete(int dummy) {
        imageReady = true;
        notifyAll();
    }


    @Override
    public void setDimensions(int x, int y) {
        width = x;
        height = y;
        imgpixels = new int[x * y];

    }


    public void setPixels(int x1, int y1, int w, int h,
                          ColorModel model, byte[] pixels, int off, int scanSize) {
        int pix, x, y, x2, y2, sx, sy;
        x2 = x1 + w;
        y2 = y1 + h;
        sy = off;
        for (y = y1; y < y2; y++) {
            sx = sy;
            for (x = x1; x < x2; x++) {
                pix = model.getRGB(pixels[sx++]);
                if ((pix & 0xff000000) == 0)
                    pix = 0xffffff;
                imgpixels[y * width + x] = pix;
            }
            sy += scanSize;
        }
    }
}