package Unit_28.Demo_05;

import java.awt.*;

/*
PluginFilter - простой интерфейс, используемый для абстрактной
фильтрации изображений.

У него есть только один метод filter (),
который принимает фрейм и исходное изображение и возвращает новое изображение,
которое каким-то образом было отфильтровано.

 */
public interface PlugInFilter {
    Image filter(Frame f, Image in);
}
