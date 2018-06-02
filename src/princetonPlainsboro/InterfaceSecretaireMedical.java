/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

import affichage.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class InterfaceSecretaireMedical extends JFrame {

    JLabel picLabel;
    private CardLayout cl = new CardLayout();
    private JPanel affichage = new JPanel();
    //Liste des noms de nos conteneurs pour la supperposition des JPanels
    private String[] listContent = {"REGISTRE_PATIENT", "REGISTRE_MEDECIN", "FICHIER_MEDICAL", "CREER_UNE_FICHE", "ACTE_MEDICAL", "DECONNEXION"};
    private JPanel menuderoulant = new JPanel();
    private JPanel haut = new JPanel();
    private JPanel bas = new JPanel();
    private JTextArea dossierMed;
    private BufferedImage image;
    private JToggleButton registrePatient;
    private JPanel panelRegistrePatient;
    private JLabel registrePa;
    private JTextField prenomPatient;
    private JTextField nomPatient;
    private Font police1;
    private JButton ok;
    private JToggleButton registreMedecin;
    private JPanel panel1;
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
        JPanel panelActe = new JPanel();
        JPanel panelFicheSoin = new JPanel();

        ImagePanel();

        //creation des boutons
        JToggleButton actemedical = new JToggleButton("Acte Medical");
        haut.add(actemedical, BorderLayout.CENTER);
        Font police = new Font("Tahoma", Font.BOLD, 16);
        actemedical.setFont(police);
        actemedical.setPreferredSize(new Dimension(230, 50));

        final JToggleButton fichierMedical = new JToggleButton("Fichier Medical");
        haut.add(fichierMedical, BorderLayout.CENTER);
        fichierMedical.setFont(police);
        fichierMedical.setPreferredSize(new Dimension(230, 50));

        JToggleButton ficheSoin = new JToggleButton("Crée une fiche de soin");
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
                    registrePa.setVisible(true);
                    nomPatient.setVisible(true);
                    prenomPatient.setVisible(true);
                    ok.setVisible(true);
                } else {
                    registrePa.setVisible(false);
                    nomPatient.setVisible(false);
                    prenomPatient.setVisible(false);
                    ok.setVisible(false);
                }
            }
        });



    }

    public void setPanelRegistrePatient() {


        //titre du registre
        registrePa = new JLabel("Registre Patient");
        panelRegistrePatient.add(registrePa, BorderLayout.NORTH);
        registrePa.setVisible(false);
        Font police1 = new Font("Tahoma", Font.BOLD, 20);
        registrePa.setFont(police1);
        registrePa.setHorizontalAlignment(JLabel.CENTER);
        registrePa.setVerticalAlignment(JLabel.CENTER);


        //JTextFiled nom et prenom
        nomPatient = new JTextField("Nom     ");
        prenomPatient = new JTextField("Prenom   ");
        panelRegistrePatient.add(nomPatient, BorderLayout.CENTER);
        nomPatient.setVisible(false);
        prenomPatient.setVisible(false);
        Font police2 = new Font("Tahoma", Font.ITALIC, 15);
        nomPatient.setFont(police2);
        panelRegistrePatient.add(prenomPatient, BorderLayout.CENTER);
        prenomPatient.setBounds(190, 90, 500, 300);
        //nomPatient.setPreferredSize(300,200);

        //bouton ok
        ok = new JButton(" Ok ");
        panelRegistrePatient.add(ok, BorderLayout.CENTER);
        ok.setVisible(false);
        //ok.setFont(police1);
        ok.setHorizontalAlignment(JLabel.CENTER);
        ok.setVerticalAlignment(JLabel.CENTER);


        JPanel b1 = new JPanel();
        JPanel b2 = new JPanel();
        panelRegistrePatient.add(b1, BorderLayout.CENTER);

        //On définit le layout en lui indiquant qu'il travaillera en ligne
        b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
        b2.setLayout(new FlowLayout());
        b1.add(b2);
        b2.add(nomPatient);
        b2.add(prenomPatient);
        b2.add(ok);


        //rechercherPatient(nomPatient.getText(),prenomPatient.getText());

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

        public void setButtonRegistreMedecin(){
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

    }





