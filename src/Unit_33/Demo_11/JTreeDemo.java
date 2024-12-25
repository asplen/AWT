package Unit_33.Demo_11;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

// Демонстрация использования JTree
public class JTreeDemo {
    public JTreeDemo() {
        // Настроить JFrame. Использовать стандартную компоновку BorderLayout.
        JFrame jfrm = new JFrame(" JTreeDemo");
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(300, 250);

        //Создать верхний узел дерева.
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Options");

        // Создать поддерево "А"
        DefaultMutableTreeNode a = new DefaultMutableTreeNode("A");
        DefaultMutableTreeNode a1 = new DefaultMutableTreeNode("A1");
        DefaultMutableTreeNode a2 = new DefaultMutableTreeNode("A2");
        DefaultMutableTreeNode a3 = new DefaultMutableTreeNode("A3");
        top.add(a);
        a.add(a1);
        a.add(a2);
        a.add(a3);

        // Создать поддерево "B"
        DefaultMutableTreeNode b = new DefaultMutableTreeNode("B");
        DefaultMutableTreeNode b1 = new DefaultMutableTreeNode("B1");
        DefaultMutableTreeNode b2 = new DefaultMutableTreeNode("B2");
        top.add(b);
        b.add(b1);
        b.add(b2);

        // Создать поддерево для B1
        DefaultMutableTreeNode tb1 = new DefaultMutableTreeNode("B1_1");
        DefaultMutableTreeNode tb2 = new DefaultMutableTreeNode("B1_2");
        b1.add(tb1);
        b1.add(tb2);

        // Создать дерево.
        JTree tree = new JTree(top);

        // Добавить дерево в панель прокрутки.
        JScrollPane jsp = new JScrollPane(tree);

        // Добавить панель прокрутки в панель содержимого.
        jfrm.add(jsp);

        // Добавить метку в панель содержимого.
        JLabel label = new JLabel();
        jfrm.add(label, BorderLayout.SOUTH);

        // Обработать события выбора в дереве.
        //Строка, представленная в текстовом поле, описывает путь от верхнего
        //узла дерева до выбранного узла.
        tree.addTreeSelectionListener(tse -> label.setText("Selection is " + tse.getPath()));

        // Отобразить фрейм
        jfrm.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(JTreeDemo::new);
    }
}