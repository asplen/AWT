package Unit_28.Demo_05;

import java.awt.image.ColorModel;

/*
Фильтр Blur является подклассом Convolver.

Он просматривает каждый пиксель в массиве с исходным изображением
imgpixels и вычисляет среднее значение окружающего пиксель
прямоугольника 3х3, которое становится выходным пикселем в массиве newimgpixels.


 */
public class Blur extends Convolver {


    @Override
    public void convolve() {
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
                        rs += r;
                        gs += g;
                        bs += b;
                    }
                }
                rs /= 9;
                gs /= 9;
                bs /= 9;
                newimgpixels[y * width + x] = (0xff000000 | rs << 16 | gs << 8 | bs);
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


