package Unit_33.Demo_07;

import javax.swing.*;

public class FlavorsPanel extends JPanel {
    public FlavorsPanel() {
        JComboBox<String> comboBox = new JComboBox<String> () ;
        comboBox.addItem(" Vanilla");
        comboBox.addItem(" Chocolate");
        comboBox.addItem(" Strawberry");

        add(comboBox);
    }
}
