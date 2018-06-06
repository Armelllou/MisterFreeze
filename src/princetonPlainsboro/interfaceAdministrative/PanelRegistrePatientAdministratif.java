package princetonPlainsboro.interfaceAdministrative;

import princetonPlainsboro.*;
import princetonPlainsboro.interfacemedical.PanelCompute;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelRegistrePatientAdministratif {

    private JTextField textNumSecu;
    private JTextField textNom;
    private JTextField textPrenom;
    private JTextField jour;
    private JButton validerRecherche;
    private JTextField textAdresse;
    private JTextField textNom2;
    private JTextField textPrenom2;
    private JTextField textAdresse2;
    private JTextField textNumSecu2;
    private JTextField jour2;
    private JTextField mois2;
    private JTextField annee2;
    private JButton validerAjout;


    public PanelRegistrePatientAdministratif(JPanel panelRegistrePatient) {

        panelRegistrePatient.setLayout(new FlowLayout());

        JLabel rP = new JLabel();
        JLabel recherche = new JLabel();
        JLabel numSec = new JLabel();
        JLabel nom = new JLabel();
        JLabel ou = new JLabel();
        JLabel dateDeNaissance = new JLabel();
        JLabel prenom = new JLabel();
        textNumSecu = new JTextField();
        textNom = new JTextField();
        textPrenom = new JTextField();
        jour = new JTextField();
        mois2 = new JTextField();
        JTextField annee = new JTextField();
        validerRecherche = new JButton();
        JLabel recherche2 = new JLabel();
        JLabel numSecu2 = new JLabel();
        JLabel nom2 = new JLabel();
        JLabel prenom2 = new JLabel();
        JLabel dateDeNaissance2 = new JLabel();
        textNumSecu2 = new JTextField();
        textNom2 = new JTextField();
        textPrenom2 = new JTextField();
        JSeparator separator1 = new JSeparator();
        jour2 = new JTextField();
        JTextField JTextFieldmois2 = new JTextField();
        annee2 = new JTextField();
        validerAjout = new JButton();
        JLabel adresse = new JLabel();
        textAdresse = new JTextField();
        JLabel adresse2 = new JLabel();
         textAdresse2 = new JTextField();

        //======== this ========

        panelRegistrePatient.setLayout(null);

        //---- rP ----
        rP.setText("Registre Patients");
        rP.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
        rP.setForeground(Color.red);
        panelRegistrePatient.add(rP);
        rP.setBounds(new Rectangle(new Point(225, 30), rP.getPreferredSize()));

        //---- recherche ----
        recherche.setText("Recherche");
        recherche.setForeground(Color.blue);
        recherche.setFont(new Font(Constants.COPPERPLATE.getValue(), Font.BOLD, 14));
        panelRegistrePatient.add(recherche);
        recherche.setBounds(new Rectangle(new Point(55, 80), recherche.getPreferredSize()));

        //---- numSecu ----
        numSec.setText("Numero de securite sociale:");
        numSec.setAlignmentX(0.5F);
        numSec.setBorder(new EtchedBorder());
        panelRegistrePatient.add(numSec);
        numSec.setBounds(35, 115, 160, numSec.getPreferredSize().height);

        //---- nom ----
        nom.setText("Nom:");
        nom.setAlignmentX(0.5F);
        nom.setBorder(new EtchedBorder());
        panelRegistrePatient.add(nom);
        nom.setBounds(150, 155, 45, nom.getPreferredSize().height);


        //---- dateDeNaissance ----
        dateDeNaissance.setText("Date de naissance (jj/mm/aaaa):");
        dateDeNaissance.setAlignmentX(0.5F);
        dateDeNaissance.setBorder(new EtchedBorder());
        panelRegistrePatient.add(dateDeNaissance);
        dateDeNaissance.setBounds(10, 230, 185, dateDeNaissance.getPreferredSize().height);

        //---- prenom ----
        prenom.setText("Prenom:");
        prenom.setAlignmentX(0.5F);
        prenom.setBorder(new EtchedBorder());
        panelRegistrePatient.add(prenom);
        prenom.setBounds(135, 195, 60, 15);
        panelRegistrePatient.add(textNumSecu);
        textNumSecu.setBounds(210, 110, 250, textNumSecu.getPreferredSize().height);
        panelRegistrePatient.add(textNom);
        textNom.setBounds(210, 150, 250, textNom.getPreferredSize().height);
        panelRegistrePatient.add(textPrenom);
        textPrenom.setBounds(210, 190, 250, textPrenom.getPreferredSize().height);
        panelRegistrePatient.add(jour);
        jour.setBounds(210, 230, 250, jour.getPreferredSize().height);

        //---- validerRecherche ----
        validerRecherche.setText(Constants.VALIDER.getValue());
        validerRecherche.setBackground(new Color(51, 153, 255));
        panelRegistrePatient.add(validerRecherche);
        validerRecherche.setBounds(480, 110, 72, 24);

        //---- recherche2 ----
        recherche2.setText("Ajout d'un patient");
        recherche2.setForeground(Color.blue);
        recherche2.setFont(new Font(Constants.COPPERPLATE.getValue(), Font.BOLD, 14));
        panelRegistrePatient.add(recherche2);
        recherche2.setBounds(55, 355, 160, 17);

        //---- numSecu2 ----
        numSecu2.setText("Numero de securite sociale:");
        numSecu2.setAlignmentX(0.5F);
        numSecu2.setBorder(new EtchedBorder());
        panelRegistrePatient.add(numSecu2);
        numSecu2.setBounds(35, 400, 160, 20);

        //---- nom2 ----
        nom2.setText("Nom:");
        nom2.setAlignmentX(0.5F);
        nom2.setBorder(new EtchedBorder());
        panelRegistrePatient.add(nom2);
        nom2.setBounds(150, 430, 45, 20);


        //---- prenom2 ----
        prenom2.setText("Prenom:");
        prenom2.setAlignmentX(0.5F);
        prenom2.setBorder(new EtchedBorder());
        panelRegistrePatient.add(prenom2);
        prenom2.setBounds(135, 470, 60, 15);

        // adresse
        adresse.setText("Adresse:");
        adresse.setAlignmentX(0.5F);
        adresse.setBorder(new EtchedBorder());
        panelRegistrePatient.add(adresse);
        adresse.setBounds(140, 275, 55, adresse.getPreferredSize().height);


        // TextAdresse

        panelRegistrePatient.add(textAdresse);
        textAdresse.setBounds(210, 275, 250, textAdresse.getPreferredSize().height);

        //---- dateDeNaissance2 ----
        dateDeNaissance2.setText("Date de naissance (jj/mm/aaaa):");
        dateDeNaissance2.setAlignmentX(0.5F);
        dateDeNaissance2.setBorder(new EtchedBorder());
        panelRegistrePatient.add(dateDeNaissance2);
        dateDeNaissance2.setBounds(10, 505, 185, 20);
        panelRegistrePatient.add(textNumSecu2);
        textNumSecu2.setBounds(210, 385, 250, 24);
        panelRegistrePatient.add(textNom2);
        textNom2.setBounds(210, 425, 250, 24);
        panelRegistrePatient.add(textPrenom2);
        textPrenom2.setBounds(210, 465, 250, 24);
        panelRegistrePatient.add(separator1);
        separator1.setBounds(0, 325, 1200, 15);
        panelRegistrePatient.add(jour2);
        jour2.setBounds(210, 505, 35, 24);
        panelRegistrePatient.add(mois2);
        mois2.setBounds(255, 505, 130, 24);
        panelRegistrePatient.add(annee2);
        annee2.setBounds(395, 505, 65, 24);

        //---- validerAjout ----
        validerAjout.setText(Constants.VALIDER.getValue());
        validerAjout.setBackground(new Color(51, 153, 255));
        panelRegistrePatient.add(validerAjout);
        validerAjout.setBounds(480, 555, 72, 24);

        // adresse2
        adresse2.setText("Adresse:");
        adresse2.setAlignmentX(0.5F);
        adresse2.setBorder(new EtchedBorder());
        panelRegistrePatient.add(adresse2);
        adresse2.setBounds(140, 550, 55, adresse2.getPreferredSize().height);


        // TextAdresse2

        panelRegistrePatient.add(textAdresse2);
        textAdresse2.setBounds(210, 550, 250, textAdresse2.getPreferredSize().height);


        PanelCompute.computePreferedSize(panelRegistrePatient);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        //fonction
        setRechercherPatient();
        setAjouterPatient();

    }


    public void setRechercherPatient() {
        textNom.setEditable(false);
        textPrenom.setEditable(false);
        jour.setEditable(false);
        textAdresse.setEditable(false);
        validerRecherche.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                LectureXML test1 = new LectureXML("listePatient.xml");
                ListePatient listePatient = test1.getListePatient();
                System.out.println(listePatient.rechercher(textNumSecu.getText()));
                if (textNumSecu.getText().length() < 16) {
                    textNom.setText(listePatient.rechercher(textNumSecu.getText()).getNom());
                    textPrenom.setText(listePatient.rechercher(textNumSecu.getText()).getPrenom());
                    jour.setText(listePatient.rechercher(textNumSecu.getText()).getDateNaissance().toString());
                    textAdresse.setText(listePatient.rechercher(textNumSecu.getText()).getAdresse());
                } else {
                    JOptionPane.showMessageDialog(null, "Vous avez ajouté un trop grand nombre de chiffre", "Erreur", JOptionPane.ERROR_MESSAGE);
                    textNumSecu.setText(null);
                }
            }
        });
    }


    public void setAjouterPatient() {

        validerAjout.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                Patient patient = new Patient(textNom2.getText(), textPrenom2.getText(), textAdresse2.getText(), textNumSecu2.getText(), new Date(Integer.parseInt(jour2.getText()), Integer.parseInt(mois2.getText()), Integer.parseInt(annee2.getText())));
                EcrireXML.saveToXML("src/donnees/ListePatient.xml", "patient", patient);
                JOptionPane.showMessageDialog(null, "Vous avez ajouté un patient", "Ajout Patient", JOptionPane.INFORMATION_MESSAGE);

                textNom2.setText(null);
                textPrenom2.setText(null);
                textAdresse2.setText(null);
                textNumSecu2.setText(null);
                jour2.setText(null);
                mois2.setText(null);
                annee2.setText(null);
            }
        });
    }
}
