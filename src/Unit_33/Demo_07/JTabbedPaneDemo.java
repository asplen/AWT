package Unit_33.Demo_07;

import javax.swing.*;

public class JTabbedPaneDemo {
    public JTabbedPaneDemo() {
        // Настроить JFrame.
        JFrame frame = new JFrame("JTabbedPaneDemo");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создать панель с вкладками.
        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Cities", new CitiesPanel());
        tabbedPane.addTab("Colors", new ColorsPanel());
        tabbedPane.addTab("Flavors", new FlavorsPanel());

        frame.add(tabbedPane);

        frame.setVisible(true);// Отобразить фрейм

        // Создать панели(CitiesPanel, ColorsPanel, FlavorsPanel),
        // которые будут добавлены в панель с вкладками.
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JTabbedPaneDemo::new);
    }
}