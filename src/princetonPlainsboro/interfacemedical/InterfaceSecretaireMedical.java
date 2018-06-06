/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro.interfacemedical;

import affichage.Login;
import princetonPlainsboro.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class InterfaceSecretaireMedical extends JFrame {

    private Font police = new Font(Constants.TAHOMA.getValue(), Font.BOLD, 16);
    private String[] listContent = {"ACCUEIL", "REGISTRE_PATIENT", "REGISTRE_MEDECIN", "FICHIER_MEDICAL", "CREER_UNE_FICHE", "ACTE_MEDICAL", "DECONNEXION"};

    private JToggleButton actemedical;
    private JToggleButton ficheSoin;
    private JToggleButton registrePatient;
    private JToggleButton registreMedecin;
    private JToggleButton deconnexion;
    private JToggleButton fichierMedical;

    private JLabel picLabel;


    private CardLayout cl = new CardLayout();
    private JPanel affichage = new JPanel();

    private List<JToggleButton> buttons;

    public InterfaceSecretaireMedical() {
        this.setSize(500, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Andromeda");

        //panel
        JPanel haut = new JPanel();
        haut.setLayout(new GridLayout(8, 1));
        haut.setBackground(Color.PINK);

        JPanel bas = new JPanel();
        bas.setLayout(new BorderLayout());
        bas.setBackground(Color.PINK);

        //Liste des noms de nos conteneurs pour la supperposition des JPanels
        JPanel menuderoulant = new JPanel();
        menuderoulant.setBackground(Color.PINK);
        menuderoulant.add(haut, BorderLayout.CENTER);
        menuderoulant.add(bas, BorderLayout.NORTH);

        //On cree trois conteneurs de couleurs differentes
        JPanel panelRegistrePatient = new JPanel();
        panelRegistrePatient.setLayout(new FlowLayout());
        JPanel panelRegistreMedecin = new JPanel();
        panelRegistreMedecin.setLayout(new BorderLayout());
        JPanel panelAccueil = new JPanel();
        panelAccueil.setLayout(new BorderLayout());
        JPanel panelDossierMedical = new JPanel();
        panelDossierMedical.setLayout(new BorderLayout());

        JPanel panelDeconnexion = new JPanel();
        JPanel panelActe = new JPanel();
        JPanel panelFicheSoin = new JPanel();

        imagePanel("src/princetonPlainsboro/image1.jpg", haut, 250, 90);
        imagePanel("src/princetonPlainsboro/Bienvenue.png", panelAccueil, 1000, 700);

        //creation des boutons
        actemedical = new JToggleButton("Acte Medical");
        fichierMedical = new JToggleButton("Fichier Medical");
        ficheSoin = new JToggleButton("Créer une fiche de soin");
        registrePatient = new JToggleButton("Registre Patient");
        registreMedecin = new JToggleButton("Registre Medecin");
        deconnexion = new JToggleButton("Deconnecter");

        buttons = new ArrayList<JToggleButton>();
        buttons.add(actemedical);
        buttons.add(fichierMedical);
        buttons.add(ficheSoin);
        buttons.add(registrePatient);
        buttons.add(registreMedecin);
        buttons.add(deconnexion);

        for (JToggleButton button : buttons) {
            setSideButton(haut, button);
        }

        //On définit le layout
        affichage.setLayout(cl);

        //On ajoute les cartes à la pile avec un nom pour les retrouver
        affichage.add(panelAccueil, listContent[0]);
        affichage.add(panelRegistrePatient, listContent[1]);
        affichage.add(panelRegistreMedecin, listContent[2]);
        affichage.add(panelDossierMedical, listContent[3]);
        affichage.add(panelFicheSoin, listContent[4]);
        affichage.add(panelActe, listContent[5]);
        affichage.add(panelDeconnexion, listContent[6]);

        this.getContentPane().add(menuderoulant, BorderLayout.WEST);
        this.getContentPane().add(affichage, BorderLayout.CENTER);
        this.setVisible(true);

        setButtonDeconnexion();
        setButtonListener(actemedical, panelActe, listContent[5]);
        setButtonListener(registreMedecin, panelRegistreMedecin, listContent[2]);
        setButtonListener(registrePatient, panelRegistrePatient, listContent[1]);
        setButtonListener(ficheSoin, panelFicheSoin, listContent[4]);
        setButtonListener(fichierMedical, panelDossierMedical, listContent[3]);

        new PanelActeMedical(panelActe);
        new PanelDossierMedical(panelDossierMedical);
        new PanelFicheSoinMedical(panelFicheSoin);
        new PanelRegistrePatientMedical(panelRegistrePatient);
        new PanelRegistreMedecinMedical(panelRegistreMedecin);
    }

    private void setButtonDeconnexion() {
        //Définition de l'action du Deconnexion
        deconnexion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au conteneur correspondant au nom fourni en paramètre
                for (JToggleButton button : buttons) {
                    button.setSelected(false);
                }
                JOptionPane.showMessageDialog(null, "Déconnexion", "Vous êtes déconnecté", JOptionPane.INFORMATION_MESSAGE);
                cl.show(affichage, listContent[6]);
                new Login().showLogin();
                dispose();
            }
        });
    }

    private void imagePanel(String path, JPanel dest, int width, int height) {
        try {
            ImageIcon icon = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
            picLabel = new JLabel(icon);
            picLabel.setVisible(true);
            picLabel.setOpaque(true);
            picLabel.setBackground(Color.PINK);
        } catch (Exception ex) {
            System.out.println("error in image");
        }
        dest.add(picLabel, BorderLayout.CENTER);
    }

    private void setSideButton(JPanel panel, JToggleButton button) {
        panel.add(button, BorderLayout.CENTER);
        button.setFont(police);
        button.setPreferredSize(new Dimension(230, 50));
    }

    private void setButtonListener(final JToggleButton button, final JPanel panel, final String name) {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au conteneur correspondant au nom fourni en paramètre
                cl.show(affichage, name);
                panel.setEnabled(button.isSelected());
                for (JToggleButton but : buttons) {
                    if (but != button) {
                        but.setSelected(false);
                    }
                }
            }
        });
    }
}
