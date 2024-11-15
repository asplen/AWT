package Unit_28.Demo_05;

import java.awt.*;
import java.awt.image.FilteredImageSource;
import java.awt.image.RGBImageFilter;

/*
Фильтр Invert тоже довольно прост.
Он разделяет значение цвета на красную, зеленую и синюю составляющие,
после чего инвертирует их, вычитая из 255.

Инвертированные величины упаковываются обратно в значение
пикселя и возвращаются.

Фильтр инвертирования цветов.
 */
public class Invert  extends RGBImageFilter implements PlugInFilter{
    public Invert( ) {}

    @Override
    public int filterRGB(int x, int y, int rgb) {
        int r = 0xff - (rgb >> 16) & 0xff;
        int g = 0xff - ( rgb >> 8) & 0xff;
        int b = 0xff - rgb & 0xff;
        return (0xff000000 | r << 16 | g << 8 | b);
    }

    public Image filter (Frame f, Image in) {
        return f. createImage( new FilteredImageSource( in. getSource(), this ) );
    }


}
