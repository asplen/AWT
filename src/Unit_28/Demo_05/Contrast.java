package Unit_28.Demo_05;

import java.awt.*;
import java.awt.image.FilteredImageSource;
import java.awt.image.RGBImageFilter;

/*
Фильтр Contrast очень похож на Grayscale за исключением того, что
переопределенная в нем версия метода filterRGB () немного сложнее.

Алгоритм, который он использует для повышения контрастности, принимает
значения красной, зеленой и синей составляющих по отдельности и умножает
их на 1.2, если их яркость выше 128.
Если же яркость ниже 128, тогда они делятся на 1.2.
Увеличенные значения должным образом фиксируются на уровне 255 с помощью
метода multclamp ().

  Фильтр контрастности.

 */
public class Contrast extends RGBImageFilter implements PlugInFilter {
    double gain = 1.2;

    public Contrast() {
    }

    @Override
    public int filterRGB(int x, int y, int rgb) {
        int r = cont((rgb >> 16) & 0xff);
        int g = cont((rgb >> 8) & 0xff);
        int b = cont(rgb & 0xff);
        return (0xff000000 | r << 16 | g << 8 | b);
    }

    private int cont(int in) {
        return (in < 128) ? (int) (in / gain) : multclamp(in, gain);
    }

    private int multclamp(int in, double factor) {
        in = (int) (in * factor);
        return in > 255 ? 255 : in;
    }

    @Override
    public Image filter(Frame f, Image in) {
        return f.createImage(new FilteredImageSource(in.getSource(), this));
    }
}
