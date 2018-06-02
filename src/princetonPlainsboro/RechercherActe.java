/*
 * Created by JFormDesigner on Sat Jun 02 12:43:08 CEST 2018
 */

package princetonPlainsboro;

import java.awt.*;
import javax.swing.*;

/**
 * @author Armelle
 */
public class RechercherActe extends JPanel {
    public RechercherActe() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Armelle
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        textField2 = new JTextField();
        button1 = new JButton();
        label4 = new JLabel();
        textField3 = new JTextField();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(null);

        //---- label1 ----
        label1.setText("Rechercher un acte");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 24));
        add(label1);
        label1.setBounds(new Rectangle(new Point(185, 5), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("Code associ\u00e9 \u00e0 son coefficient (exemple K12) ");
        add(label2);
        label2.setBounds(new Rectangle(new Point(60, 80), label2.getPreferredSize()));
        add(textField1);
        textField1.setBounds(55, 105, 225, 25);

        //---- label3 ----
        label3.setText("Type de consultation");
        add(label3);
        label3.setBounds(new Rectangle(new Point(60, 145), label3.getPreferredSize()));
        add(textField2);
        textField2.setBounds(55, 170, 170, 25);

        //---- button1 ----
        button1.setText("Valider");
        add(button1);
        button1.setBounds(new Rectangle(new Point(340, 100), button1.getPreferredSize()));

        //---- label4 ----
        label4.setText("Co\u00fbt");
        add(label4);
        label4.setBounds(new Rectangle(new Point(60, 215), label4.getPreferredSize()));
        add(textField3);
        textField3.setBounds(55, 235, 165, 25);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < getComponentCount(); i++) {
                Rectangle bounds = getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            setMinimumSize(preferredSize);
            setPreferredSize(preferredSize);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Armelle
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label3;
    private JTextField textField2;
    private JButton button1;
    private JLabel label4;
    private JTextField textField3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
