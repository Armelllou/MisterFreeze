package princetonPlainsboro;

import affichage.Acceuil;
import affichage.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class InterfaceSecretaireAdministratif extends JFrame {
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
    private JButton button1New;
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
    private JLabel label11;
    private JLabel label12;
    private JTextField jj;
    private JTextField mm;
    private JTextField aaaa;
    private JLabel label13;
    private JLabel label14;
    private JTextField nomMed;
    private JTextField nomPa;
    private JLabel label15;
    private JLabel label16;
    private JLabel label17;
    private JLabel label18;
    private JTextField prenomMed;
    private JTextField prenomPa;
    private JLabel label19;
    private JTextField numSecu;
    private JLabel label20;
    private JComboBox comboBox1;
    private JLabel label21;
    private JLabel label22;
    private JTextField coef;
    private JLabel label23;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private ListeMedecin listMedecin;



    public InterfaceSecretaireAdministratif() {
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
        panelRegistrePatient.setLayout(new FlowLayout());
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
                new Login().showLogin();
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
        setAjouterFicheSoin();

        //a mettre dans secretaire medical
        setAjouterMedecin();
        setAjouterPatient();


    }

    public void setPanelFicheSoin() {

        label11 = new JLabel();
        label12 = new JLabel();
        jj = new JTextField();
        mm = new JTextField();
        aaaa = new JTextField();
        label13 = new JLabel();
        label14 = new JLabel();
        nomMed = new JTextField();
        nomPa = new JTextField();
        label15 = new JLabel();
        label16 = new JLabel();
        label17 = new JLabel();
        label18 = new JLabel();
        prenomMed = new JTextField();
        prenomPa = new JTextField();
        label19 = new JLabel();
        numSecu = new JTextField();
        label20 = new JLabel();
        comboBox1 = new JComboBox();
        label21 = new JLabel();
        label22 = new JLabel();
        coef = new JTextField();
        label23 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        button1New = new JButton();

        //======== panelFicheSoin ========
        {

            // JFormDesigner evaluation mark
            panelFicheSoin.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                            java.awt.Color.red), panelFicheSoin.getBorder())); panelFicheSoin.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panelFicheSoin.setLayout(null);

            //---- label11 ----
            label11.setText("Ajouter une nouvelle fiche de soin");
            label11.setFont(new Font("Segoe UI", Font.BOLD, 22));
            panelFicheSoin.add(label11);
            label11.setBounds(new Rectangle(new Point(125, 0), label11.getPreferredSize()));

            //---- label12 ----
            label12.setText("Date");
            panelFicheSoin.add(label12);
            label12.setBounds(new Rectangle(new Point(20, 65), label12.getPreferredSize()));
            panelFicheSoin.add(jj);
            jj.setBounds(90, 60, 36, 30);
            panelFicheSoin.add(mm);
            mm.setBounds(140, 60, 36, 30);
            panelFicheSoin.add(aaaa);
            aaaa.setBounds(200, 60, 36, 30);

            //---- label13 ----
            label13.setText("Medecin");
            panelFicheSoin.add(label13);
            label13.setBounds(new Rectangle(new Point(20, 150), label13.getPreferredSize()));

            //---- label14 ----
            label14.setText("Patient");
            panelFicheSoin.add(label14);
            label14.setBounds(new Rectangle(new Point(20, 185), label14.getPreferredSize()));
            panelFicheSoin.add(nomMed);
            nomMed.setBounds(85, 140, 150, 25);
            panelFicheSoin.add(nomPa);
            nomPa.setBounds(85, 180, 150, 25);

            //---- label15 ----
            label15.setText("JJ");
            panelFicheSoin.add(label15);
            label15.setBounds(90, 40, 20, 16);

            //---- label16 ----
            label16.setText("MM");
            panelFicheSoin.add(label16);
            label16.setBounds(new Rectangle(new Point(145, 40), label16.getPreferredSize()));

            //---- label17 ----
            label17.setText("AAAA");
            panelFicheSoin.add(label17);
            label17.setBounds(new Rectangle(new Point(205, 40), label17.getPreferredSize()));

            //---- label18 ----
            label18.setText("Nom");
            panelFicheSoin.add(label18);
            label18.setBounds(new Rectangle(new Point(85, 120), label18.getPreferredSize()));
            panelFicheSoin.add(prenomMed);
            prenomMed.setBounds(265, 140, 130, 25);
            panelFicheSoin.add(prenomPa);
            prenomPa.setBounds(265, 180, 135, 25);

            //---- label19 ----
            label19.setText("Prenom");
            panelFicheSoin.add(label19);
            label19.setBounds(new Rectangle(new Point(270, 120), label19.getPreferredSize()));
            panelFicheSoin.add(numSecu);
            numSecu.setBounds(435, 180, 100, 25);

            //---- label20 ----
            label20.setText("Numero Securite Social");
            panelFicheSoin.add(label20);
            label20.setBounds(new Rectangle(new Point(435, 160), label20.getPreferredSize()));
            panelFicheSoin.add(comboBox1);
            comboBox1.setBounds(90, 220, 90, 30);
            for(Code code : Code.values()){
                comboBox1.addItem(code.name());
            }


            //---- label21 ----
            label21.setText("Code ");
            panelFicheSoin.add(label21);
            label21.setBounds(new Rectangle(new Point(20, 225), label21.getPreferredSize()));

            //---- label22 ----
            label22.setText("Coefficient");
            panelFicheSoin.add(label22);
            label22.setBounds(new Rectangle(new Point(15, 265), label22.getPreferredSize()));
            panelFicheSoin.add(coef);
            coef.setBounds(90, 260, 80, 25);

            //---- label23 ----
            label23.setText("Observation");
            panelFicheSoin.add(label23);
            label23.setBounds(new Rectangle(new Point(10, 295), label23.getPreferredSize()));

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(textArea1);
            }
            panelFicheSoin.add(scrollPane1);
            scrollPane1.setBounds(90, 300, 300, 65);

            //---- button1New ----
            button1New.setText("Valider");
            panelFicheSoin.add(button1New);
            button1New.setBounds(445, 300, 105, 40);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panelFicheSoin.getComponentCount(); i++) {
                    Rectangle bounds = panelFicheSoin.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panelFicheSoin.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panelFicheSoin.setMinimumSize(preferredSize);
                panelFicheSoin.setPreferredSize(preferredSize);
            }
        }
    }


    public void setButtonFicheSoin() {
        ficheSoin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au conteneur correspondant au nom fourni en paramètre
                cl.show(affichage, listContent[3]);
                if (ficheSoin.isSelected()) {
                    label11.setVisible(true);
                    label12.setVisible(true);
                    jj.setVisible(true);
                    mm.setVisible(true);
                    aaaa.setVisible(true);
                    label13.setVisible(true);
                    label14.setVisible(true);
                    nomMed.setVisible(true);
                    nomPa.setVisible(true);
                    label15.setVisible(true);
                    label16.setVisible(true);
                    label17.setVisible(true);
                    label18.setVisible(true);
                    prenomMed.setVisible(true);
                    prenomPa.setVisible(true);
                    label19.setVisible(true);
                    numSecu.setVisible(true);
                    label20.setVisible(true);
                    comboBox1.setVisible(true);
                    label21.setVisible(true);
                    label22.setVisible(true);
                    coef.setVisible(true);
                    label23.setVisible(true);
                    scrollPane1.setVisible(true);
                    textArea1.setVisible(true);
                    button1New.setVisible(true);
                } else {
                    label11.setVisible(false);
                    label12.setVisible(false);
                    jj.setVisible(false);
                    mm.setVisible(false);
                    aaaa.setVisible(false);
                    label13.setVisible(false);
                    label14.setVisible(false);
                    nomMed.setVisible(false);
                    nomPa.setVisible(false);
                    label15.setVisible(false);
                    label16.setVisible(false);
                    label17.setVisible(false);
                    label18.setVisible(false);
                    prenomMed.setVisible(false);
                    prenomPa.setVisible(false);
                    label19.setVisible(false);
                    numSecu.setVisible(false);
                    label20.setVisible(false);
                    comboBox1.setVisible(false);
                    label21.setVisible(false);
                    label22.setVisible(false);
                    coef.setVisible(false);
                    label23.setVisible(false);
                    scrollPane1.setVisible(false);
                    textArea1.setVisible(false);
                    button1New.setVisible(false);

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
        button1New = new JButton();
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

            //---- button1New ----
            button1New.setText("Valider");
            panelRegistreMedecin.add(button1New);
            button1New.setBounds(75, 130, 95, button1New.getPreferredSize().height);
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

    public void setAjouterMedecin() {
        button1New.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Map<String, String> xmlToSave = new LinkedHashMap<String, String>();
                xmlToSave.put(null, "medecin");
                xmlToSave.put("nom", textField1.getText());
                xmlToSave.put("prenom", textField2.getText());
                xmlToSave.put("specialite", textField3.getText());
                xmlToSave.put("numeroTelephone", textField4.getText());
                //Medecin medecin1 = new Medecin(textField1.getText(),textField2.getText(),textField3.getText(), textField4.getText(),textField5.getText()); //ajouter mdp
                Medecin medecin1 = new Medecin(textField1.getText(),textField2.getText(),textField3.getText(),textField4.getText()," "); //ajouter mdp
                EcrireXML.saveToXML("src/donnees/dossiers2.xml","medecin",medecin1);
                listMedecin.ajouterMedecin(medecin1);

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
                    button1New.setVisible(true);
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
                    button1New.setVisible(false);
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
    public void setAjouterPatient() {
        button1Patient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Patient patient1 = new Patient(textField1Patient.getText(), textField2Patient.getText(), new Date(14, 3, 1996),textField4Patient.getText());
                EcrireXML.saveToXML("src/donnees/dossiers2.xml","patient", patient1);
            }
        });

    }

    public void setAjouterFicheSoin() {
        button1New.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Date date = new Date(Integer.parseInt(jj.getText()), Integer.parseInt(mm.getText()), Integer.parseInt(aaaa.getText()));
                Medecin medecin = new Medecin(nomMed.getText(), prenomMed.getText(), "blabla", "4","mdp5");
                Patient patient = new Patient(nomPa.getText(),prenomPa.getText(), new Date(14, 3, 1996), numSecu.getText());
                List<Acte> actes = new ArrayList<Acte>();
                System.out.println("test");
                System.out.println(comboBox1.getItemAt(comboBox1.getSelectedIndex()));
                String s = comboBox1.getItemAt(comboBox1.getSelectedIndex()).toString();
                actes.add(new Acte(Code.valueOf(s),Integer.parseInt(coef.getText())));

                //actes.add(new Acte(Code.CS, 1));
                EcrireXML.saveFicheDeSoinToXML("src/donnees/dossiers2.xml", date, medecin, patient, actes);
            }
        });

    }
}


