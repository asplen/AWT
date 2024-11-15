package Unit_28.Demo_05;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.lang.reflect.*;

/*
ImageFilterDemo - главный класс для примеров фильтров изображений. В
В нем используется стандартный экземпляр BorderLayout с объектом Panel
в позиции South для размещения кнопок,
которые будут представлять каждый фильтр.

Объект Label занимает позицию North и предназначен для
отображения информационных сообщений о ходе фильтрации.

В позиции Center находится изображение
(которое инкапсулировано в подклассе LoadedImage класса Canvas, описанном ниже).

Метод actionPerformed () интересен тем, что применяет метку кнопки
в качестве имени класса фильтра, который он загружает.

Данный метод надежен и выполняет подходящее действие,
если кнопка не соответствует надлежащему классу, реализующему PluginFilter.

Демонстрация использования фильтров изображений.
 */
public class ImageFilterDemo extends Frame implements ActionListener {
    Image img;
    PlugInFilter pif;
    Image fImg;
    Image curImg;
    LoadedImage lim;
    Label lab;
    Button reset;
    // Имена фильтров.
    String[] filters = {"Gray", "Invert", "Contrast", "Blur", "Sharpen"};

    public ImageFilterDemo() {
        Panel p = new Panel();
        add(p, BorderLayout.SOUTH);

        // Создать кнопку Reset (Сброс).
        reset = new Button("Reset");
        reset.addActionListener(this);
        p.add(reset);

        // Добавить кнопки фильтров.
        for (String f : filters) {
            Button b = new Button(f);
            b.addActionListener(this);
            p.add(b);
        }

        // Создать верхнюю кнопку .
        lab = new Label("Выберете фильтр");
        add(lab, BorderLayout.NORTH);

        // Загрузить изображение.
        try {
            File imageFile = new File("Lilies.jpg");
            img = ImageIO.read(imageFile);
        } catch (IOException exception) {
            System.out.println("He удалось загрузить файл изображения.");
            System.exit(0);
        }

        // Получить объект LoadedImage и расположить его по центру.
        lim = new LoadedImage(img);
        add(lim, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String a = "";

        try {
            a = ae.getActionCommand();
            if (a.equals("Reset")) {
                lim.set(img) ;
                lab.setText("Normal");//Нормальное
            } else {
                a = "Unit_28.Demo_05." + a;//правильный путь к фильтрам!
                // Получить выбранный фильтр.
                pif = (PlugInFilter) Class.forName(a).getConstructor().newInstance();
                fImg = pif.filter(this, img);
                lim.set(fImg);
                lab.setText("Filtered : " + a); // Отфильтрованное название
            }
            repaint();
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + a); // Печать информации об ошибке

            lab.setText(a + "   not found");// не найдено
            lim.set(img);
            repaint();
        } catch (InstantiationException exception) {
            lab.setText(" couldn't new " + a);// не удается создать
        } catch (IllegalAccessException e) {
            lab.setText("по access : " + a);// нет доступа
        }catch ( NoSuchMethodException |  InvocationTargetException e){
            lab.setText ("Filter creation error : "+ e); // Ошибка создания фильтра
        }
    }

    public static void main(String[] args) {
        ImageFilterDemo demo = new ImageFilterDemo();

        demo.setVisible(true);
        demo.setSize(new Dimension(420,420));
        demo.setTitle("Image Filter Demo");
    }
}
