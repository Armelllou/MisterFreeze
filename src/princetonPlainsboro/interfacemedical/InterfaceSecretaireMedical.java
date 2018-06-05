/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro.interfacemedical;

import affichage.Login;
import princetonPlainsboro.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceSecretaireMedical extends JFrame {

    private JLabel picLabel;
    private JToggleButton actemedical;
    private JToggleButton ficheSoin;
    private JPanel panelFicheSoin;
    private Font police = new Font(Constants.TAHOMA.getValue(), Font.BOLD, 16);

    private CardLayout cl = new CardLayout();
    private JPanel affichage = new JPanel();
    //Liste des noms de nos conteneurs pour la supperposition des JPanels
    private String[] listContent = {"ACCUEIL", "REGISTRE_PATIENT", "REGISTRE_MEDECIN", "FICHIER_MEDICAL", "CREER_UNE_FICHE", "ACTE_MEDICAL", "DECONNEXION"};
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
    private JPanel panelActe;

    private ListeMedecin listeMedecin;
    private JToggleButton deconnexion;
    private JToggleButton fichierMedical;
    private JLabel registreM;


    private JPanel panelAccueil;


    private JButton button1Medecin;

    public InterfaceSecretaireMedical() {
        this.setSize(500, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Andromeda");

        //panel
        haut.setLayout(new GridLayout(8, 1));
        menuderoulant.setBackground(Color.PINK);
        haut.setBackground(Color.PINK);
        bas.setBackground(Color.PINK);
        bas.setLayout(new BorderLayout());
        menuderoulant.add(haut, BorderLayout.CENTER);
        menuderoulant.add(bas, BorderLayout.NORTH);

        //On cree trois conteneurs de couleurs differentes
        panelRegistrePatient = new JPanel();
        panelRegistrePatient.setLayout(new FlowLayout());
        panelRegistreMedecin = new JPanel();
        panelRegistreMedecin.setLayout(new BorderLayout());
        panelAccueil = new JPanel();
        panelAccueil.setLayout(new BorderLayout());


        JPanel panelRegistreM = new JPanel();
        JPanel panelDeconnexion = new JPanel();
        panelActe = new JPanel();
        panelFicheSoin = new JPanel();

        ImagePanel();

        //creation des boutons
        actemedical = new JToggleButton("Acte Medical");
        fichierMedical = new JToggleButton("Fichier Medical");
        ficheSoin = new JToggleButton("Créer une fiche de soin");
        registrePatient = new JToggleButton("Registre Patient");
        registreMedecin = new JToggleButton("Registre Medecin");
        deconnexion = new JToggleButton("Deconnecter");

        setSideButton(actemedical);
        setSideButton(fichierMedical);
        setSideButton(ficheSoin);
        setSideButton(registrePatient);
        setSideButton(registreMedecin);
        setSideButton(deconnexion);

        panelRegistreM.setLayout(new BorderLayout());

        //recupère Les fiches de soins du XML
        LectureXML test = new LectureXML("dossiers.xml");
        DossierMedical dm1 = test.getDossier();
        dossierMed = new JTextArea(dm1.toStringDM());
        panelRegistreM.add(dossierMed, BorderLayout.CENTER);
        dossierMed.setVisible(false);

        //titre registre Medical
        registreM = new JLabel("Registre Medical");
        panelRegistreM.add(registreM, BorderLayout.NORTH);
        registreM.setVisible(false);
        Font police1 = new Font(Constants.TAHOMA.getValue(), Font.BOLD, 20);
        registreM.setFont(police1);
        registreM.setHorizontalAlignment(JLabel.CENTER);
        registreM.setVerticalAlignment(JLabel.CENTER);

        //On définit le layout
        affichage.setLayout(cl);

        //On ajoute les cartes à la pile avec un nom pour les retrouver
        affichage.add(panelAccueil, listContent[0]);
        affichage.add(panelRegistrePatient, listContent[1]);
        affichage.add(panelRegistreMedecin, listContent[2]);
        affichage.add(panelRegistreM, listContent[3]);
        affichage.add(panelFicheSoin, listContent[4]);
        affichage.add(panelActe, listContent[5]);
        affichage.add(panelDeconnexion, listContent[6]);

        this.getContentPane().add(menuderoulant, BorderLayout.WEST);
        this.getContentPane().add(affichage, BorderLayout.CENTER);
        this.setVisible(true);

        setButtonRegistrePatient();
        setButtonRegistreMedecin();
        setButtonActe();
        setButtonFicheSoin();
        setButtonDeconnexion();
        setButtonFichierMedical();
        ImagePanelAccueil();

        new PanelActeMedical(panelActe);
        new PanelFicheSoinMedical(panelFicheSoin);
        new PanelRegistrePatientMedical(panelRegistrePatient);
        new PanelRegistreMedecinMedical(panelRegistreMedecin);
    }


    public void ImagePanelAccueil() {
        try {
            ImageIcon icon = new ImageIcon(new ImageIcon("src/princetonPlainsboro/Bienvenue.png").getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT));
            picLabel = new JLabel(icon);
            picLabel.setVisible(true);
            picLabel.setOpaque(true);
            picLabel.setBackground(Color.white);
        } catch (Exception ex) {
            System.out.println("error in image");
        }
        panelAccueil.add(picLabel, BorderLayout.CENTER);
    }

    public void setButtonFichierMedical() {
        //Définition de l'action du bouton fichierMedical
        fichierMedical.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au prochain conteneur de la pile
                cl.show(affichage, listContent[3]);
                if (fichierMedical.isSelected()) {
                    dossierMed.setVisible(true);
                    registreM.setVisible(true);

                    actemedical.setSelected(false);
                    ficheSoin.setSelected(false);
                    registrePatient.setSelected(false);
                    registreMedecin.setSelected(false);

                } else {
                    dossierMed.setVisible(false);
                    registreM.setVisible(false);

                    actemedical.setSelected(false);
                    ficheSoin.setSelected(false);
                    registrePatient.setSelected(false);
                    registreMedecin.setSelected(false);
                }
            }
        });
    }

    public void setButtonDeconnexion() {
        //Définition de l'action du Deconnexion
        deconnexion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au conteneur correspondant au nom fourni en paramètre
                actemedical.setSelected(false);
                ficheSoin.setSelected(false);
                registrePatient.setSelected(false);
                registreMedecin.setSelected(false);
                fichierMedical.setSelected(false);
                JOptionPane.showMessageDialog(null, "Déconnexion", "Vous êtes déconnecté", JOptionPane.INFORMATION_MESSAGE);
                cl.show(affichage, listContent[6]);
                new Login().showLogin();
                dispose();
            }
        });
    }


    public void setButtonFicheSoin() {
        ficheSoin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au conteneur correspondant au nom fourni en paramètre
                cl.show(affichage, listContent[4]);
                if (ficheSoin.isSelected()) {
                    panelFicheSoin.setEnabled(true);
                } else {
                    panelFicheSoin.setEnabled(false);
                }
                actemedical.setSelected(false);
                fichierMedical.setSelected(false);
                registrePatient.setSelected(false);
                registreMedecin.setSelected(false);
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
        haut.add(picLabel, BorderLayout.CENTER);
    }

    public void setButtonRegistrePatient() {
        registrePatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au conteneur correspondant au nom fourni en paramètre
                cl.show(affichage, listContent[1]);
                if (registrePatient.isSelected()) {
                    panelRegistrePatient.setEnabled(true);
                } else {
                    panelRegistrePatient.setEnabled(false);
                }
                actemedical.setSelected(false);
                fichierMedical.setSelected(false);
                ficheSoin.setSelected(false);
                registreMedecin.setSelected(false);
            }
        });

    }


    public void setButtonRegistreMedecin() {
        registreMedecin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au conteneur correspondant au nom fourni en paramètre
                cl.show(affichage, listContent[2]);
                if (registreMedecin.isSelected()) {
                    panelRegistreMedecin.setEnabled(true);
                } else {
                    panelRegistreMedecin.setEnabled(false);
                }
                actemedical.setSelected(false);
                fichierMedical.setSelected(false);
                ficheSoin.setSelected(false);
                registrePatient.setSelected(false);
            }
        });


    }



    public void setButtonActe() {

        actemedical.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au conteneur correspondant au nom fourni en paramètre
                cl.show(affichage, listContent[5]);
                if (actemedical.isSelected()) {
                    panelActe.setVisible(true);
                    panelActe.setEnabled(true);
                } else {
                    panelActe.setVisible(false);
                    panelActe.setEnabled(false);
                }
                fichierMedical.setSelected(false);
                ficheSoin.setSelected(false);
                registrePatient.setSelected(false);
                registreMedecin.setSelected(false);

            }
        });

    }


    private void setSideButton(JToggleButton button) {
        haut.add(button, BorderLayout.CENTER);
        button.setFont(police);
        button.setPreferredSize(new Dimension(230, 50));
    }
}
