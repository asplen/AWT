package Unit_28.Demo_05;

import java.awt.image.ColorModel;

/*
Фильтр Sharpen также является подклассом Convolver и (в какой-то степени)
противоположностью Blur.

Он проходит через каждый пиксель в массиве с исходным изображением
imgpixels и вычисляет среднее значение окружающего его прямоугольника 3х3,
не считая центральный пиксель.

К соответствующему выходному пикселю в newimgpixels добавляется разница
между центральным пикселем и окружающим средним значением.

По существу, если пиксель на 30 единиц ярче своего окружения, тогда он делается
ярче еще на 30 единиц. Если же пиксель на 10 единиц темнее, то он делается
темнее еще на 10 единиц. В итоге резкие края выделяются, а гладкие области
остаются без изменений.
 */
public class Sharpen extends Convolver {

    private final int clamp(int c) {
        return (c > 255 ? 255 : (Math.max(c, 0)));
    }

    @Override
    void convolve() {
        int r0 = 0, g0 = 0, b0 = 0;

        for (int y = 1; y < height - 1; y++) {
            for (int x = 1; x < width - 1; x++) {
                int rs = 0;
                int gs = 0;
                int bs = 0;

                for (int k = -1; k <= 1; k++) {
                    for (int j = -1; j <= 1; j++) {
                        int rgb = imgpixels[(y + k) * width + x + j];
                        int r = (rgb >> 16) & 0xff;
                        int g = (rgb >> 8) & 0xff;
                        int b = rgb & 0xff;

                        if (j == 0 && k == 0) {
                            r0 = r;
                            g0 = g;
                            b0 = b;
                        } else {
                            rs += r;
                            gs += g;
                            bs += b;
                        }
                    }
                }
                rs >>= 3;
                gs >>= 3;
                bs >>= 3;
                newimgpixels[y * width + x] = (0xff000000
                        | clamp(r0 + r0 - rs) << 16
                        | clamp(g0 + g0 - gs) << 8
                        | clamp(b0 + b0 - bs));
            }
        }
    }

    @Override
    public void setPixels(int x1, int y1, int w, int h, ColorModel model, int[] pixels, int off, int scanSize) {
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
