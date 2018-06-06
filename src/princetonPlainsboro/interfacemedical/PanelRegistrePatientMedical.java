package princetonPlainsboro.interfacemedical;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import princetonPlainsboro.*;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelRegistrePatientMedical {

    private JTextField textNumSecu;
    private JTextField textNom;
    private JTextField textPrenom;
    private JTextField jour;
    private JButton validerRecherche;
    private JTextField textAdresse;
    private JTextField  textListPatient;


    PanelRegistrePatientMedical(JPanel panelRegistrePatient) {
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
        JTextField mois = new JTextField();
        JTextField annee = new JTextField();
        validerRecherche = new JButton();
        JLabel recherche2 = new JLabel();
        JLabel numSecu2 = new JLabel();
        JLabel nom2 = new JLabel();
        JLabel prenom2 = new JLabel();
        JLabel dateDeNaissance2 = new JLabel();
        JTextField textNumSecu2 = new JTextField();
        JTextField textNom2 = new JTextField();
        JTextField textPrenom2 = new JTextField();
        JSeparator separator1 = new JSeparator();
        JTextField jour2 = new JTextField();
        JTextField mois2 = new JTextField();
        JTextField annee2 = new JTextField();
        JButton validerAjout = new JButton();
        JLabel adresse = new JLabel();
        textAdresse = new JTextField();
        textListPatient = new JTextField();

        //======== this ========

        panelRegistrePatient.setLayout(null);

        //---- rP ----
        rP.setText("Registre Patients");
        rP.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
        rP.setForeground(Color.red);
        panelRegistrePatient.add(rP);
        rP.setBounds(new Rectangle(new Point(225, 30), rP.getPreferredSize()));

        //---- recherche ----
        recherche.setText("Recherche : entrez le numero de securite");
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

        // adresse
        adresse.setText("Adresse:");
        adresse.setAlignmentX(0.5F);
        adresse.setBorder(new EtchedBorder());
        panelRegistrePatient.add(adresse);
        adresse.setBounds(140, 280, 55, adresse.getPreferredSize().height);

        // TextAdresse
        panelRegistrePatient.add(textAdresse);
        textAdresse.setBounds(210, 275, 250, textAdresse.getPreferredSize().height);

        // TextAdresse
        //panelRegistrePatient.add(textListPatient);
        //textListPatient.setBounds(210, 350, 250, 400);

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
        validerRecherche.setBounds(new Rectangle(new Point(480, 110), validerRecherche.getPreferredSize()));


        PanelCompute.computePreferedSize(panelRegistrePatient);
        setRechercherPatient();
    }

    public void setRechercherPatient() {
        textNom.setEditable(false);
        textPrenom.setEditable(false);
        jour.setEditable(false);
        textAdresse.setEditable(false);
        System.out.println("marche");
        validerRecherche.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                LectureXML test1 = new LectureXML("listePatient.xml");
                ListePatient listePatient = test1.getListePatient();
                LectureXML test2 = new LectureXML("dossiers.xml");
                DossierMedical dm1 = test2.getDossier();
                System.out.println(listePatient.rechercher(textNumSecu.getText()));


                if(textNumSecu.getText().length()<16) {
                    textNom.setText(listePatient.rechercher(textNumSecu.getText()).getNom());
                    textPrenom.setText(listePatient.rechercher(textNumSecu.getText()).getPrenom());
                    jour.setText(listePatient.rechercher(textNumSecu.getText()).getDateNaissance().toString());
                    textAdresse.setText(listePatient.rechercher(textNumSecu.getText()).getAdresse());
                    //textListPatient.setText(dm1.rechercherfichesDUnPatient(textNumSecu.getText()).toString());
                }

                else {
                    JOptionPane.showMessageDialog(null, "Vous avez ajouté un trop grand nombre de chiffre", "Erreur", JOptionPane.ERROR_MESSAGE);
                    textNumSecu.setText(null);
                }

            }
        });
    }
}
