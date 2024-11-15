package Unit_28.Demo_05;

import java.awt.*;
import java.awt.image.FilteredImageSource;
import java.awt.image.RGBImageFilter;

/*
Фильтр GrayScale является подклассом RGBImageFilter, т.е. объект
Grayscale можно передавать в качестве параметра типа ImageFilter
конструктору FilteredImageSource.
В нем потребуется лишь переопределить метод filterRGB (),
чтобы изменить входные значения цвета.

Метод filterRGB() принимает значения красной, зеленой и синей составляющих и
вычисляет яркость пикселя с использованием коэффициента преобразования
цвета в яркость, принятого NTSC.

Затем он просто возвращает серый пиксель с такой же яркостью, как у исходного цвета.

Фильтр яркости.
 */
public class Gray extends RGBImageFilter implements PlugInFilter {

    public Gray() {
    }

    @Override
    public Image filter(Frame f, Image in) {
        return f.createImage(new FilteredImageSource(in.getSource(), this));
    }

    @Override
    public int filterRGB(int x, int y, int rgb) {
        int r = (rgb >> 16) & 0xff;
        int g = (rgb >> 8) & 0xff;
        int b = rgb & 0xff;
        int k = (int) (.56 * g + .33 * r + .11 * b);
        return (0xff000000 | k << 16 | k << 8 | k);
    }
}
