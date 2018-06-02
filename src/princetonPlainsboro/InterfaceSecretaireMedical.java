/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

import static princetonPlainsboro.ecrireXML.saveToXML;

public class InterfaceSecretaireMedical extends JFrame {

    JLabel picLabel;
    JToggleButton actemedical;
    JToggleButton ficheSoin;
    JPanel panelFicheSoin;
    private CardLayout cl = new CardLayout();
    private JPanel affichage = new JPanel();
    //Liste des noms de nos conteneurs pour la supperposition des JPanels
    private String[] listContent = {"REGISTRE_PATIENT", "REGISTRE_MEDECIN", "FICHIER_MEDICAL", "CREER_UNE_FICHE", "ACTE_MEDICAL", "DECONNEXION"};
    private JPanel menuderoulant = new JPanel();
    private JPanel haut = new JPanel();
    private JPanel bas = new JPanel();
    private JTextArea dossierMed;
    private JToggleButton registrePatient;
    private JPanel panelRegistrePatient;
    private JToggleButton registreMedecin;
    private JLabel label3;
    private JTextField textField1;
    private JLabel label4;
    private JTextField textField2;
    private JLabel label5;
    private JButton button1;
    private JTextField textField3;
    private JLabel label6;
    private JLabel label7;
    private JTextField textField4;
    private JPanel panelRegistreMedecin;
    private JLabel label1Patient;
    private JLabel label2Patient;
    private JButton button1Patient;
    private JTextField textField1Patient;
    private JLabel label3Patient;
    private JLabel label4Patient;
    private JTextField textField2Patient;
    private JTextField textField3Patient;
    private JLabel label5Patient;
    private JTextField textField4Patient;
    private JLabel label6Patient;
    private JLabel label1Acte;
    private JLabel label2Acte;
    private JTextField textField1Acte;
    private JLabel label3Acte;
    private JTextField textField2Acte;
    private JButton button1Acte;
    private JLabel label4ACte;
    private JTextField textField3Acte;
    private JPanel panelActe;
    private JLabel label1New;
    private JLabel label2New;
    private JTextField textField1New;
    private JTextField textField2New;
    private JTextField textField3New;
    private JLabel label3New;
    private JLabel label4New;
    private JTextField textField4New;
    private JTextField textField5New;
    private JLabel label5New;
    private JLabel label6New;
    private JLabel label7New;
    private JLabel label8New;
    private JTextField textField6New;
    private JTextField textField7New;
    private JLabel label9New;
    private JTextField textField8New;
    private JLabel label10New;
    private JButton button1New;
    private JLabel New;
    private JLabel label22New;
    private JLabel label23New;
    private JTextField textField17New;
    private JTextField textField18New;
    private JScrollPane scrollPane1New;
    private JTextArea textArea1New;
    private JPanel this2New;
    private JLabel label11New;
    private JLabel label12New;
    private JTextField textField9New;
    private JTextField textField10New;
    private JTextField textField11New;
    private JLabel label13New;
    private JLabel label14New;
    private JTextField textField12New;
    private JTextField textField13New;
    private JLabel label15New;
    private JLabel label16New;
    private JLabel label17New;
    private JLabel label18New;
    private JTextField textField14New;
    private JTextField textField15New;
    private JLabel label19New;
    private JTextField textField16New;
    private JLabel label20New;
    private JButton button2New;


    public InterfaceSecretaireMedical() {
        this.setSize(500, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //panel
        haut.setLayout(new GridLayout(8, 1));
        menuderoulant.setBackground(Color.PINK);
        haut.setBackground(Color.PINK);
        bas.setBackground(Color.PINK);
        bas.setLayout(new BorderLayout());
        menuderoulant.add(haut, BorderLayout.CENTER);
        menuderoulant.add(bas, BorderLayout.SOUTH);

        //On cree trois conteneurs de couleurs differentes
        panelRegistrePatient = new JPanel();
        panelRegistrePatient.setLayout(new BorderLayout());
        panelRegistreMedecin = new JPanel();
        panelRegistreMedecin.setLayout(new BorderLayout());


        JPanel panelRegistreM = new JPanel();
        JPanel panelDeconnexion = new JPanel();
        panelActe = new JPanel();
        panelFicheSoin = new JPanel();

        ImagePanel();

        //creation des boutons
        actemedical = new JToggleButton("Acte Medical");
        haut.add(actemedical, BorderLayout.CENTER);
        Font police = new Font("Tahoma", Font.BOLD, 16);
        actemedical.setFont(police);
        actemedical.setPreferredSize(new Dimension(230, 50));

        final JToggleButton fichierMedical = new JToggleButton("Fichier Medical");
        haut.add(fichierMedical, BorderLayout.CENTER);
        fichierMedical.setFont(police);
        fichierMedical.setPreferredSize(new Dimension(230, 50));

        ficheSoin = new JToggleButton("Crée une fiche de soin");
        haut.add(ficheSoin, BorderLayout.CENTER);
        ficheSoin.setFont(police);
        ficheSoin.setPreferredSize(new Dimension(230, 50));

        registrePatient = new JToggleButton("Registre Patient");
        haut.add(registrePatient, BorderLayout.CENTER);
        registrePatient.setFont(police);
        registrePatient.setPreferredSize(new Dimension(230, 50));

        registreMedecin = new JToggleButton("Registre Medecin");
        haut.add(registreMedecin, BorderLayout.CENTER);
        registreMedecin.setFont(police);
        registreMedecin.setPreferredSize(new Dimension(230, 50));

        JToggleButton deconnexion = new JToggleButton("Deconnecter");
        haut.add(deconnexion, BorderLayout.CENTER);
        deconnexion.setFont(police);


        panelRegistreM.setLayout(new BorderLayout());

        //recupère Les fiches de soins du XML
        LectureXML test = new LectureXML("dossiers.xml");
        DossierMedical dm1 = test.getDossier();
            dossierMed = new JTextArea(dm1.toStringDM());
        panelRegistreM.add(dossierMed, BorderLayout.CENTER);
        dossierMed.setVisible(false);

        //titre registre Medical
        final JLabel registreM = new JLabel("Registre Medical");
        panelRegistreM.add(registreM, BorderLayout.NORTH);
        registreM.setVisible(false);
        Font police1 = new Font("Tahoma", Font.BOLD, 20);
        registreM.setFont(police1);
        registreM.setHorizontalAlignment(JLabel.CENTER);
        registreM.setVerticalAlignment(JLabel.CENTER);

        //Définition de l'action du bouton fichierMedical
        fichierMedical.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au prochain conteneur de la pile
                cl.show(affichage, listContent[2]);
                if (fichierMedical.isSelected()) {
                    dossierMed.setVisible(true);
                    registreM.setVisible(true);
                } else {
                    dossierMed.setVisible(false);
                    registreM.setVisible(false);
                }
            }
        });

        //Définition de l'action du Deconnexion
        deconnexion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au conteneur correspondant au nom fourni en paramètre
                cl.show(affichage, listContent[5]);
                Deconnexion deco1 = new Deconnexion();
                deco1.setMinimumSize(new Dimension(700, 700));
                dispose();
            }
        });


        //On définit le layout
        affichage.setLayout(cl);

        //On ajoute les cartes à la pile avec un nom pour les retrouver
        affichage.add(panelRegistrePatient, listContent[0]);
        affichage.add(panelRegistreMedecin, listContent[1]);
        affichage.add(panelRegistreM, listContent[2]);
        affichage.add(panelFicheSoin, listContent[3]);
        affichage.add(panelActe, listContent[4]);
        affichage.add(panelDeconnexion, listContent[5]);


        this.getContentPane().add(menuderoulant, BorderLayout.WEST);
        this.getContentPane().add(affichage, BorderLayout.CENTER);
        this.setVisible(true);


        setPanelRegistrePatient();
        setButtonRegistrePatient();
        setPanelRegistreMedecin();
        setButtonRegistreMedecin();
        setPanelActe();
        setButtonActe();
        setButtonFicheSoin();
        setPanelFicheSoin();
        //a mettre dans secretaire medical
        setAjouterMedecin();
        setAjouterPatient();

    }

    public void setPanelFicheSoin() {
        label1New = new JLabel();
        label2New = new JLabel();
        textField1New = new JTextField();
        textField2New = new JTextField();
        textField3New = new JTextField();
        label3New = new JLabel();
        label4New = new JLabel();
        textField4New = new JTextField();
        textField5New = new JTextField();
        label5New = new JLabel();
        label6New = new JLabel();
        label7New = new JLabel();
        label8New = new JLabel();
        textField6New = new JTextField();
        textField7New = new JTextField();
        label9New = new JLabel();
        textField8New = new JTextField();
        label10New = new JLabel();
        button1New = new JButton();
        New = new JLabel();
        label22New = new JLabel();
        label23New = new JLabel();
        textField17New = new JTextField();
        textField18New = new JTextField();
        scrollPane1New = new JScrollPane();
        textArea1New = new JTextArea();
        this2New = new JPanel();
        label11New = new JLabel();
        label12New = new JLabel();
        textField9New = new JTextField();
        textField10New = new JTextField();
        textField11New = new JTextField();
        label13New = new JLabel();
        label14New = new JLabel();
        textField12New = new JTextField();
        textField13New = new JTextField();
        label15New = new JLabel();
        label16New = new JLabel();
        label17New = new JLabel();
        label18New = new JLabel();
        textField14New = new JTextField();
        textField15New = new JTextField();
        label19New = new JLabel();
        textField16New = new JTextField();
        label20New = new JLabel();
        button2New = new JButton();

        //======== this ========

        // JFormDesigner evaluation mark
        panelFicheSoin.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panelFicheSoin.getBorder()));
        panelFicheSoin.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent e) {
                if ("border".equals(e.getPropertyName())) throw new RuntimeException();
            }
        });

        panelFicheSoin.setLayout(null);

        //---- label1New ----
        label1New.setText("Ajouter une nouvelle fiche de soin");
        label1New.setFont(new Font("Segoe UI", Font.BOLD, 22));
        panelFicheSoin.add(label1New);
        label1New.setBounds(new Rectangle(new Point(125, 0), label1New.getPreferredSize()));

        //---- label2New ----
        label2New.setText("Date");
        panelFicheSoin.add(label2New);
        label2New.setBounds(new Rectangle(new Point(20, 65), label2New.getPreferredSize()));
        panelFicheSoin.add(textField1New);
        textField1New.setBounds(new Rectangle(new Point(90, 60), textField1New.getPreferredSize()));
        panelFicheSoin.add(textField2New);
        textField2New.setBounds(140, 60, 40, 30);
        panelFicheSoin.add(textField3New);
        textField3New.setBounds(200, 60, 40, 30);

        //---- label3New ----
        label3New.setText("Medecin");
        panelFicheSoin.add(label3New);
        label3New.setBounds(new Rectangle(new Point(20, 150), label3New.getPreferredSize()));

        //---- label4New ----
        label4New.setText("Patient");
        panelFicheSoin.add(label4New);
        label4New.setBounds(new Rectangle(new Point(20, 185), label4New.getPreferredSize()));
        panelFicheSoin.add(textField4New);
        textField4New.setBounds(85, 140, 150, 25);
        panelFicheSoin.add(textField5New);
        textField5New.setBounds(85, 180, 150, 25);

        //---- label5New ----
        label5New.setText("JJ");
        panelFicheSoin.add(label5New);
        label5New.setBounds(90, 40, 20, 16);

        //---- label6New ----
        label6New.setText("MM");
        panelFicheSoin.add(label6New);
        label6New.setBounds(new Rectangle(new Point(145, 40), label6New.getPreferredSize()));

        //---- label7New ----
        label7New.setText("AAAA");
        panelFicheSoin.add(label7New);
        label7New.setBounds(new Rectangle(new Point(205, 40), label7New.getPreferredSize()));

        //---- label8New ----
        label8New.setText("Nom");
        panelFicheSoin.add(label8New);
        label8New.setBounds(new Rectangle(new Point(85, 120), label8New.getPreferredSize()));
        panelFicheSoin.add(textField6New);
        textField6New.setBounds(265, 140, 130, 25);
        panelFicheSoin.add(textField7New);
        textField7New.setBounds(265, 180, 135, 25);

        //---- label9New ----
        label9New.setText("Prenom");
        panelFicheSoin.add(label9New);
        label9New.setBounds(new Rectangle(new Point(270, 120), label9New.getPreferredSize()));
        panelFicheSoin.add(textField8New);
        textField8New.setBounds(435, 180, 100, 25);

        //---- label10New ----
        label10New.setText("Numero Securite Social");
        panelFicheSoin.add(label10New);
        label10New.setBounds(new Rectangle(new Point(435, 160), label10New.getPreferredSize()));

        //---- button1New ----
        button1New.setText("Valider");
        panelFicheSoin.add(button1New);
        button1New.setBounds(435, 310, 125, 35);

        //---- New ----
        New.setText("Code ");
        panelFicheSoin.add(New);
        New.setBounds(new Rectangle(new Point(25, 240), New.getPreferredSize()));

        //---- label22New ----
        label22New.setText("Coefficient");
        panelFicheSoin.add(label22New);
        label22New.setBounds(new Rectangle(new Point(25, 270), label22New.getPreferredSize()));

        //---- label23New ----
        label23New.setText("Observation");
        panelFicheSoin.add(label23New);
        label23New.setBounds(new Rectangle(new Point(25, 300), label23New.getPreferredSize()));
        panelFicheSoin.add(textField17New);
        textField17New.setBounds(95, 225, 80, 25);
        panelFicheSoin.add(textField18New);
        textField18New.setBounds(95, 260, 80, 25);

        //======== scrollPane1New ========
        {
            scrollPane1New.setViewportView(textArea1New);
        }
        panelFicheSoin.add(scrollPane1New);
        scrollPane1New.setBounds(100, 300, 300, 65);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < getComponentCount(); i++) {
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

        //======== this2New ========
        {

            // JFormDesigner evaluation mark
            this2New.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "", javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                            java.awt.Color.red), this2New.getBorder()));
            this2New.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                public void propertyChange(java.beans.PropertyChangeEvent e) {
                    if ("border".equals(e.getPropertyName())) throw new RuntimeException();
                }
            });

            this2New.setLayout(null);

            //---- label11New ----
            label11New.setText("Ajouter une nouvelle fiche de soin");
            label11New.setFont(new Font("Segoe UI", Font.BOLD, 22));
            this2New.add(label11New);
            label11New.setBounds(new Rectangle(new Point(125, 0), label11New.getPreferredSize()));

            //---- label12New ----
            label12New.setText("Date");
            this2New.add(label12New);
            label12New.setBounds(new Rectangle(new Point(20, 65), label12New.getPreferredSize()));
            this2New.add(textField9New);
            textField9New.setBounds(50, 60, 400, 30);
            this2New.add(textField10New);
            textField10New.setBounds(140, 60, 50, 30);
            this2New.add(textField11New);
            textField11New.setBounds(210, 60, 50, 30);

            //---- label13New ----
            label13New.setText("Medecin");
            this2New.add(label13New);
            label13New.setBounds(new Rectangle(new Point(20, 150), label13New.getPreferredSize()));

            //---- label14New ----
            label14New.setText("Patient");
            this2New.add(label14New);
            label14New.setBounds(new Rectangle(new Point(20, 185), label14New.getPreferredSize()));
            this2New.add(textField12New);
            textField12New.setBounds(85, 140, 150, 25);
            this2New.add(textField13New);
            textField13New.setBounds(85, 180, 150, 25);

            //---- label15New ----
            label15New.setText("JJ");
            this2New.add(label15New);
            label15New.setBounds(90, 40, 20, 16);

            //---- label16New ----
            label16New.setText("MM");
            this2New.add(label16New);
            label16New.setBounds(new Rectangle(new Point(145, 40), label16New.getPreferredSize()));

            //---- label17New ----
            label17New.setText("AAAA");
            this2New.add(label17New);
            label17New.setBounds(new Rectangle(new Point(205, 40), label17New.getPreferredSize()));

            //---- label18New ----
            label18New.setText("Nom");
            this2New.add(label18New);
            label18New.setBounds(new Rectangle(new Point(85, 120), label18New.getPreferredSize()));
            this2New.add(textField14New);
            textField14New.setBounds(265, 140, 130, 25);
            this2New.add(textField15New);
            textField15New.setBounds(265, 180, 135, 25);

            //---- label19New ----
            label19New.setText("Prenom");
            this2New.add(label19New);
            label19New.setBounds(new Rectangle(new Point(270, 120), label19New.getPreferredSize()));
            this2New.add(textField16New);
            textField16New.setBounds(435, 180, 100, 25);

            //---- label20New ----
            label20New.setText("Numero Securite Social");
            this2New.add(label20New);
            label20New.setBounds(new Rectangle(new Point(435, 160), label20New.getPreferredSize()));

            //---- button2New ----
            button2New.setText("Valider");
            this2New.add(button2New);
            button2New.setBounds(85, 235, 90, 35);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for (int i = 0; i < this2New.getComponentCount(); i++) {
                    Rectangle bounds = this2New.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = this2New.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                this2New.setMinimumSize(preferredSize);
                this2New.setPreferredSize(preferredSize);
            }
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    public void setButtonFicheSoin() {
        ficheSoin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au conteneur correspondant au nom fourni en paramètre
                cl.show(affichage, listContent[3]);
                if (ficheSoin.isSelected()) {
                    label1New.setVisible(true);
                    label2New.setVisible(true);
                    textField1New.setVisible(true);
                    textField2New.setVisible(true);
                    textField3New.setVisible(true);
                    label3New.setVisible(true);
                    label4New.setVisible(true);
                    textField4New.setVisible(true);
                    textField5New.setVisible(true);
                    label5New.setVisible(true);
                    label6New.setVisible(true);
                    label7New.setVisible(true);
                    label8New.setVisible(true);
                    textField6New.setVisible(true);
                    textField7New.setVisible(true);
                    label9New.setVisible(true);
                    textField8New.setVisible(true);
                    label10New.setVisible(true);
                    button1New.setVisible(true);
                    New.setVisible(true);
                    label22New.setVisible(true);
                    label23New.setVisible(true);
                    textField17New.setVisible(true);
                    textField18New.setVisible(true);
                    scrollPane1New.setVisible(true);
                    textArea1New.setVisible(true);
                    this2New.setVisible(true);
                    label11New.setVisible(true);
                    label12New.setVisible(true);
                    textField9New.setVisible(true);
                    textField10New.setVisible(true);
                    textField11New.setVisible(true);
                    label13New.setVisible(true);
                    label14New.setVisible(true);
                    textField12New.setVisible(true);
                    textField13New.setVisible(true);
                    label15New.setVisible(true);
                    label16New.setVisible(true);
                    label17New.setVisible(true);
                    label18New.setVisible(true);
                    textField14New.setVisible(true);
                    textField15New.setVisible(true);
                    label19New.setVisible(true);
                    textField16New.setVisible(true);
                    label20New.setVisible(true);
                    button2New.setVisible(true);
                } else {
                    label1New.setVisible(false);
                    label2New.setVisible(false);
                    textField1New.setVisible(false);
                    textField2New.setVisible(false);
                    textField3New.setVisible(false);
                    label3New.setVisible(false);
                    label4New.setVisible(false);
                    textField4New.setVisible(false);
                    textField5New.setVisible(false);
                    ;
                    label5New.setVisible(false);
                    label6New.setVisible(false);
                    label7New.setVisible(false);
                    label8New.setVisible(false);
                    textField6New.setVisible(false);
                    textField7New.setVisible(false);
                    label9New.setVisible(false);
                    textField8New.setVisible(false);
                    label10New.setVisible(false);
                    button1New.setVisible(false);
                    New.setVisible(false);
                    label22New.setVisible(false);
                    label23New.setVisible(false);
                    textField17New.setVisible(false);
                    textField18New.setVisible(false);
                    scrollPane1New.setVisible(false);
                    textArea1New.setVisible(false);
                    this2New.setVisible(false);
                    label11New.setVisible(false);
                    label12New.setVisible(false);
                    textField9New.setVisible(false);
                    textField10New.setVisible(false);
                    textField11New.setVisible(false);
                    ;
                    label13New.setVisible(false);
                    label14New.setVisible(false);
                    textField12New.setVisible(false);
                    textField13New.setVisible(false);
                    label15New.setVisible(false);
                    label16New.setVisible(false);
                    label17New.setVisible(false);
                    label18New.setVisible(false);
                    textField14New.setVisible(false);
                    textField15New.setVisible(false);
                    label19New.setVisible(false);
                    textField16New.setVisible(false);
                    label20New.setVisible(false);
                    button2New.setVisible(false);
                }
            }
        });

    }

    public void ImagePanel() {
        try {
            ImageIcon icon = new ImageIcon(new ImageIcon("src/princetonPlainsboro/image1.jpg").getImage().getScaledInstance(250, 90, Image.SCALE_DEFAULT));
            picLabel = new JLabel(icon);
            picLabel.setVisible(true);
            picLabel.setOpaque(true);
            picLabel.setBackground(Color.PINK);
        } catch (Exception ex) {
            System.out.println("error in image");
        }
        haut.add(picLabel, BorderLayout.NORTH);
    }

    public void setButtonRegistrePatient() {
        registrePatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au conteneur correspondant au nom fourni en paramètre
                cl.show(affichage, listContent[0]);
                if (registrePatient.isSelected()) {
                    label1Patient.setVisible(true);
                    label2Patient.setVisible(true);
                    button1Patient.setVisible(true);
                    textField1Patient.setVisible(true);
                    label3Patient.setVisible(true);
                    label4Patient.setVisible(true);
                    textField2Patient.setVisible(true);
                    textField3Patient.setVisible(true);
                    label5Patient.setVisible(true);
                    textField4Patient.setVisible(true);
                    label6Patient.setVisible(true);
                } else {
                    label1Patient.setVisible(false);
                    label2Patient.setVisible(false);
                    button1Patient.setVisible(false);
                    ;
                    textField1Patient.setVisible(false);
                    label3Patient.setVisible(false);
                    label4Patient.setVisible(false);
                    textField2Patient.setVisible(false);
                    textField3Patient.setVisible(false);
                    label5Patient.setVisible(false);
                    textField4Patient.setVisible(false);
                    label6Patient.setVisible(false);
                }
            }
        });


    }

    public void setPanelRegistrePatient() {


        label1Patient = new JLabel();
        label2Patient = new JLabel();
        button1Patient = new JButton();
        textField1Patient = new JTextField();
        label3Patient = new JLabel();
        label4Patient = new JLabel();
        textField2Patient = new JTextField();
        textField3Patient = new JTextField();
        label5Patient = new JLabel();
        textField4Patient = new JTextField();
        label6Patient = new JLabel();

        //======== this ========

        // JFormDesigner evaluation mark
        panelRegistrePatient.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panelRegistrePatient.getBorder()));
        panelRegistrePatient.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent e) {
                if ("border".equals(e.getPropertyName())) throw new RuntimeException();
            }
        });

        panelRegistrePatient.setLayout(null);

        //---- label1Patient ----
        label1Patient.setText("Recherche d'un patient");
        label1Patient.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        panelRegistrePatient.add(label1Patient);
        label1Patient.setBounds(new Rectangle(new Point(35, 60), label1Patient.getPreferredSize()));

        //---- label2Patient ----
        label2Patient.setText("Numero de Securite Sociale : ");
        panelRegistrePatient.add(label2Patient);
        label2Patient.setBounds(new Rectangle(new Point(35, 100), label2Patient.getPreferredSize()));

        //---- button1Patient ----
        button1Patient.setText("Valider");
        panelRegistrePatient.add(button1Patient);
        button1Patient.setBounds(new Rectangle(new Point(35, 130), button1Patient.getPreferredSize()));
        panelRegistrePatient.add(textField1Patient);
        textField1Patient.setBounds(195, 100, 115, 30);

        //---- label3Patient ----
        label3Patient.setText("Nom ");
        panelRegistrePatient.add(label3Patient);
        label3Patient.setBounds(new Rectangle(new Point(40, 180), label3Patient.getPreferredSize()));

        //---- label4Patient ----
        label4Patient.setText("Prenom");
        panelRegistrePatient.add(label4Patient);
        label4Patient.setBounds(new Rectangle(new Point(195, 180), label4Patient.getPreferredSize()));
        panelRegistrePatient.add(textField2Patient);
        textField2Patient.setBounds(40, 205, 120, 30);
        panelRegistrePatient.add(textField3Patient);
        textField3Patient.setBounds(190, 205, 125, 30);

        //---- label5Patient ----
        label5Patient.setText("Date de naissance");
        panelRegistrePatient.add(label5Patient);
        label5Patient.setBounds(new Rectangle(new Point(345, 180), label5Patient.getPreferredSize()));
        panelRegistrePatient.add(textField4Patient);
        textField4Patient.setBounds(345, 205, 125, 30);

        //---- label6Patient ----
        label6Patient.setText("Registre Patient");
        label6Patient.setFont(new Font("Segoe UI", Font.BOLD, 30));
        panelRegistrePatient.add(label6Patient);
        label6Patient.setBounds(new Rectangle(new Point(175, 5), label6Patient.getPreferredSize()));


        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < getComponentCount(); i++) {
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

    }

    public void setPanelRegistreMedecin() {

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Armelle
        label3 = new JLabel();
        textField1 = new JTextField();
        label4 = new JLabel();
        textField2 = new JTextField();
        label5 = new JLabel();
        button1 = new JButton();
        textField3 = new JTextField();
        label6 = new JLabel();
        label7 = new JLabel();
        textField4 = new JTextField();

        //======== panel1 ========
        {

            // JFormDesigner evaluation mark
            panelRegistreMedecin.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                            java.awt.Color.red), panelRegistreMedecin.getBorder()));
            panelRegistreMedecin.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                public void propertyChange(java.beans.PropertyChangeEvent e) {
                    if ("border".equals(e.getPropertyName())) throw new RuntimeException();
                }
            });

            panelRegistreMedecin.setLayout(null);

            //---- label3 ----
            label3.setText("Recherche");
            label3.setFont(new Font("Segoe UI", Font.BOLD, 26));
            panelRegistreMedecin.add(label3);
            label3.setBounds(215, 10, 145, 30);
            panelRegistreMedecin.add(textField1);
            textField1.setBounds(70, 85, 130, 25);

            //---- label4 ----
            label4.setText("Nom");
            panelRegistreMedecin.add(label4);
            label4.setBounds(75, 60, 85, 25);
            panelRegistreMedecin.add(textField2);
            textField2.setBounds(285, 85, 120, 25);

            //---- label5 ----
            label5.setText("Prenom");
            panelRegistreMedecin.add(label5);
            label5.setBounds(290, 60, 60, 20);

            //---- button1 ----
            button1.setText("Valider");
            panelRegistreMedecin.add(button1);
            button1.setBounds(75, 130, 95, button1.getPreferredSize().height);
            panelRegistreMedecin.add(textField3);
            textField3.setBounds(75, 210, 120, 25);


            //---- label6 ----
            label6.setText("Specialite");
            panelRegistreMedecin.add(label6);
            label6.setBounds(85, 185, 60, 20);

            //---- label7 ----
            label7.setText("Numero de telephone");
            panelRegistreMedecin.add(label7);
            label7.setBounds(new Rectangle(new Point(310, 190), label7.getPreferredSize()));
            panelRegistreMedecin.add(textField4);
            textField4.setBounds(305, 210, 130, 25);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for (int i = 0; i < panelRegistreMedecin.getComponentCount(); i++) {
                    Rectangle bounds = panelRegistreMedecin.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panelRegistreMedecin.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panelRegistreMedecin.setMinimumSize(preferredSize);
                panelRegistreMedecin.setPreferredSize(preferredSize);
            }
        }

    }

    public void setAjouterMedecin(){
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Map<String, String> xmlToSave = new LinkedHashMap<String, String>();
                xmlToSave.put(null, "medecin");
                xmlToSave.put("nom", textField1.getText());
                xmlToSave.put("prenom", textField2.getText());
                xmlToSave.put("specialite", textField3.getText());
                xmlToSave.put("numeroTelephone", textField4.getText());
                saveToXML(xmlToSave);
            }
        });
    }

    public void setButtonRegistreMedecin() {
        registreMedecin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au conteneur correspondant au nom fourni en paramètre
                cl.show(affichage, listContent[1]);
                if (registreMedecin.isSelected()) {
                    label3.setVisible(true);
                    textField1.setVisible(true);
                    label4.setVisible(true);
                    textField2.setVisible(true);
                    label5.setVisible(true);
                    button1.setVisible(true);
                    textField3.setVisible(true);
                    label6.setVisible(true);
                    label7.setVisible(true);
                    textField4.setVisible(true);
                } else {
                    label3.setVisible(false);
                    textField1.setVisible(false);
                    label4.setVisible(false);
                    textField2.setVisible(false);
                    label5.setVisible(false);
                    button1.setVisible(false);
                    textField3.setVisible(false);
                    label6.setVisible(false);
                    label7.setVisible(false);
                    textField4.setVisible(false);
                }
            }
        });

    }

    public void setPanelActe() {
        label1Acte = new JLabel();
        label2Acte = new JLabel();
        textField1Acte = new JTextField();
        label3Acte = new JLabel();
        textField2Acte = new JTextField();
        button1Acte = new JButton();
        label4ACte = new JLabel();
        textField3Acte = new JTextField();

        //======== this ========

        // JFormDesigner evaluation mark
        panelActe.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panelActe.getBorder()));
        panelActe.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent e) {
                if ("border".equals(e.getPropertyName())) throw new RuntimeException();
            }
        });

        panelActe.setLayout(null);

        //---- label1Acte ----
        label1Acte.setText("Rechercher un acte");
        label1Acte.setFont(new Font("Segoe UI", Font.BOLD, 24));
        panelActe.add(label1Acte);
        label1Acte.setBounds(new Rectangle(new Point(185, 5), label1Acte.getPreferredSize()));

        //---- label2Acte ----
        label2Acte.setText("Code associ\u00e9 \u00e0 son coefficient (exemple K12) ");
        panelActe.add(label2Acte);
        label2Acte.setBounds(new Rectangle(new Point(60, 80), label2Acte.getPreferredSize()));
        panelActe.add(textField1Acte);
        textField1Acte.setBounds(55, 105, 225, 25);

        //---- label3Acte ----
        label3Acte.setText("Type de consultation");
        panelActe.add(label3Acte);
        label3Acte.setBounds(new Rectangle(new Point(60, 145), label3Acte.getPreferredSize()));
        panelActe.add(textField2Acte);
        textField2Acte.setBounds(55, 170, 170, 25);

        //---- button1Acte ----
        button1Acte.setText("Valider");
        panelActe.add(button1Acte);
        button1Acte.setBounds(new Rectangle(new Point(340, 100), button1Acte.getPreferredSize()));

        //---- label4ACte ----
        label4ACte.setText("Co\u00fbt");
        panelActe.add(label4ACte);
        label4ACte.setBounds(new Rectangle(new Point(60, 215), label4ACte.getPreferredSize()));
        panelActe.add(textField3Acte);
        textField3Acte.setBounds(55, 235, 165, 25);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < getComponentCount(); i++) {
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

    public void setButtonActe() {

        actemedical.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au conteneur correspondant au nom fourni en paramètre
                cl.show(affichage, listContent[4]);
                if (actemedical.isSelected()) {
                    label1Acte.setVisible(true);
                    label2Acte.setVisible(true);
                    textField1Acte.setVisible(true);
                    label3Acte.setVisible(true);
                    textField2Acte.setVisible(true);
                    button1Acte.setVisible(true);
                    label4ACte.setVisible(true);
                    textField3Acte.setVisible(true);
                } else {
                    label1Acte.setVisible(false);
                    label2Acte.setVisible(false);
                    textField1Acte.setVisible(false);
                    label3Acte.setVisible(false);
                    textField2Acte.setVisible(false);
                    button1Acte.setVisible(false);
                    label4ACte.setVisible(false);
                    textField3Acte.setVisible(false);
                }
            }
        });


    }
    //mettre dans secretaire administrative
    public void setAjouterPatient(){
        button1Patient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Map<String, String> xmlToSave = new LinkedHashMap<String, String>();
                xmlToSave.put(null, "patient");
                xmlToSave.put("nom", textField2Patient.getText());
                xmlToSave.put("prenom", textField3Patient.getText());
                xmlToSave.put("date", textField4Patient.getText());
                xmlToSave.put("numeroSecurite", textField1Patient.getText());
                saveToXML(xmlToSave);
            }
        });

    }
}






