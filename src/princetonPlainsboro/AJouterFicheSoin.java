/*
 * Created by JFormDesigner on Sat Jun 02 13:05:10 CEST 2018
 */

package princetonPlainsboro;

import java.awt.*;
import javax.swing.*;

/**
 * @author Armelle
 */
public class AJouterFicheSoin extends JPanel {
    public AJouterFicheSoin() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Armelle
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        textField4 = new JTextField();
        textField5 = new JTextField();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        textField6 = new JTextField();
        textField7 = new JTextField();
        label9 = new JLabel();
        textField8 = new JTextField();
        label10 = new JLabel();
        button1 = new JButton();
        label21 = new JLabel();
        label22 = new JLabel();
        label23 = new JLabel();
        textField17 = new JTextField();
        textField18 = new JTextField();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        this2 = new JPanel();
        label11 = new JLabel();
        label12 = new JLabel();
        textField9 = new JTextField();
        textField10 = new JTextField();
        textField11 = new JTextField();
        label13 = new JLabel();
        label14 = new JLabel();
        textField12 = new JTextField();
        textField13 = new JTextField();
        label15 = new JLabel();
        label16 = new JLabel();
        label17 = new JLabel();
        label18 = new JLabel();
        textField14 = new JTextField();
        textField15 = new JTextField();
        label19 = new JLabel();
        textField16 = new JTextField();
        label20 = new JLabel();
        button2 = new JButton();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(null);

        //---- label1 ----
        label1.setText("Ajouter une nouvelle fiche de soin");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 22));
        add(label1);
        label1.setBounds(new Rectangle(new Point(125, 0), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("Date");
        add(label2);
        label2.setBounds(new Rectangle(new Point(20, 65), label2.getPreferredSize()));
        add(textField1);
        textField1.setBounds(new Rectangle(new Point(80, 60), textField1.getPreferredSize()));
        add(textField2);
        textField2.setBounds(140, 60, 36, 30);
        add(textField3);
        textField3.setBounds(200, 60, 36, 30);

        //---- label3 ----
        label3.setText("Medecin");
        add(label3);
        label3.setBounds(new Rectangle(new Point(20, 150), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("Patient");
        add(label4);
        label4.setBounds(new Rectangle(new Point(20, 185), label4.getPreferredSize()));
        add(textField4);
        textField4.setBounds(85, 140, 150, 25);
        add(textField5);
        textField5.setBounds(85, 180, 150, 25);

        //---- label5 ----
        label5.setText("JJ");
        add(label5);
        label5.setBounds(90, 40, 20, 16);

        //---- label6 ----
        label6.setText("MM");
        add(label6);
        label6.setBounds(new Rectangle(new Point(145, 40), label6.getPreferredSize()));

        //---- label7 ----
        label7.setText("AAAA");
        add(label7);
        label7.setBounds(new Rectangle(new Point(205, 40), label7.getPreferredSize()));

        //---- label8 ----
        label8.setText("Nom");
        add(label8);
        label8.setBounds(new Rectangle(new Point(85, 120), label8.getPreferredSize()));
        add(textField6);
        textField6.setBounds(265, 140, 130, 25);
        add(textField7);
        textField7.setBounds(265, 180, 135, 25);

        //---- label9 ----
        label9.setText("Prenom");
        add(label9);
        label9.setBounds(new Rectangle(new Point(270, 120), label9.getPreferredSize()));
        add(textField8);
        textField8.setBounds(435, 180, 100, 25);

        //---- label10 ----
        label10.setText("Numero Securite Social");
        add(label10);
        label10.setBounds(new Rectangle(new Point(435, 160), label10.getPreferredSize()));

        //---- button1 ----
        button1.setText("Valider");
        add(button1);
        button1.setBounds(435, 310, 125, 35);

        //---- label21 ----
        label21.setText("Code ");
        add(label21);
        label21.setBounds(new Rectangle(new Point(25, 240), label21.getPreferredSize()));

        //---- label22 ----
        label22.setText("Coefficient");
        add(label22);
        label22.setBounds(new Rectangle(new Point(25, 270), label22.getPreferredSize()));

        //---- label23 ----
        label23.setText("Observation");
        add(label23);
        label23.setBounds(new Rectangle(new Point(25, 300), label23.getPreferredSize()));
        add(textField17);
        textField17.setBounds(95, 225, 80, 25);
        add(textField18);
        textField18.setBounds(95, 260, 80, 25);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textArea1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(100, 300, 300, 65);

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

        //======== this2 ========
        {

            // JFormDesigner evaluation mark
            this2.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), this2.getBorder())); this2.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            this2.setLayout(null);

            //---- label11 ----
            label11.setText("Ajouter une nouvelle fiche de soin");
            label11.setFont(new Font("Segoe UI", Font.BOLD, 22));
            this2.add(label11);
            label11.setBounds(new Rectangle(new Point(125, 0), label11.getPreferredSize()));

            //---- label12 ----
            label12.setText("Date");
            this2.add(label12);
            label12.setBounds(new Rectangle(new Point(20, 65), label12.getPreferredSize()));
            this2.add(textField9);
            textField9.setBounds(new Rectangle(new Point(80, 60), textField9.getPreferredSize()));
            this2.add(textField10);
            textField10.setBounds(140, 60, 36, 30);
            this2.add(textField11);
            textField11.setBounds(200, 60, 36, 30);

            //---- label13 ----
            label13.setText("Medecin");
            this2.add(label13);
            label13.setBounds(new Rectangle(new Point(20, 150), label13.getPreferredSize()));

            //---- label14 ----
            label14.setText("Patient");
            this2.add(label14);
            label14.setBounds(new Rectangle(new Point(20, 185), label14.getPreferredSize()));
            this2.add(textField12);
            textField12.setBounds(85, 140, 150, 25);
            this2.add(textField13);
            textField13.setBounds(85, 180, 150, 25);

            //---- label15 ----
            label15.setText("JJ");
            this2.add(label15);
            label15.setBounds(90, 40, 20, 16);

            //---- label16 ----
            label16.setText("MM");
            this2.add(label16);
            label16.setBounds(new Rectangle(new Point(145, 40), label16.getPreferredSize()));

            //---- label17 ----
            label17.setText("AAAA");
            this2.add(label17);
            label17.setBounds(new Rectangle(new Point(205, 40), label17.getPreferredSize()));

            //---- label18 ----
            label18.setText("Nom");
            this2.add(label18);
            label18.setBounds(new Rectangle(new Point(85, 120), label18.getPreferredSize()));
            this2.add(textField14);
            textField14.setBounds(265, 140, 130, 25);
            this2.add(textField15);
            textField15.setBounds(265, 180, 135, 25);

            //---- label19 ----
            label19.setText("Prenom");
            this2.add(label19);
            label19.setBounds(new Rectangle(new Point(270, 120), label19.getPreferredSize()));
            this2.add(textField16);
            textField16.setBounds(435, 180, 100, 25);

            //---- label20 ----
            label20.setText("Numero Securite Social");
            this2.add(label20);
            label20.setBounds(new Rectangle(new Point(435, 160), label20.getPreferredSize()));

            //---- button2 ----
            button2.setText("Valider");
            this2.add(button2);
            button2.setBounds(85, 235, 90, 35);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < this2.getComponentCount(); i++) {
                    Rectangle bounds = this2.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = this2.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                this2.setMinimumSize(preferredSize);
                this2.setPreferredSize(preferredSize);
            }
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Armelle
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel label3;
    private JLabel label4;
    private JTextField textField4;
    private JTextField textField5;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JTextField textField6;
    private JTextField textField7;
    private JLabel label9;
    private JTextField textField8;
    private JLabel label10;
    private JButton button1;
    private JLabel label21;
    private JLabel label22;
    private JLabel label23;
    private JTextField textField17;
    private JTextField textField18;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JPanel this2;
    private JLabel label11;
    private JLabel label12;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JLabel label13;
    private JLabel label14;
    private JTextField textField12;
    private JTextField textField13;
    private JLabel label15;
    private JLabel label16;
    private JLabel label17;
    private JLabel label18;
    private JTextField textField14;
    private JTextField textField15;
    private JLabel label19;
    private JTextField textField16;
    private JLabel label20;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
