package princetonPlainsboro;

import affichage.Login;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JButton button1New;
    private JPanel panelRegistreMedecin;
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

    private JLabel rP;
    private JLabel recherche;
    private JLabel numSec;
    private JLabel nom;
    private JLabel ou;
    private JLabel dateDeNaissance;
    private JLabel prenom;
    private JTextField textNumSecu;
    private JTextField textNom;
    private JTextField textPrénom;
    private JTextField jour;
    private JTextField mois;
    private JTextField annee;
    private JButton validerRecherche;
    private JLabel recherche2;
    private JLabel numSecu2;
    private JLabel nom2;
    private JLabel prenom2;
    private JLabel dateDeNaissance2;
    private JTextField textNumSecu2;
    private JTextField textNom2;
    private JTextField textPrénom2;
    private JTextField jour2;
    private JTextField mois2;
    private JTextField annee2;
    private JSeparator separator1;
    private JButton validerAjout;

    private JLabel rM;
    private JLabel rechercheM;
    private JLabel nomM;
    private JLabel prenomM;
    private JTextField textNomM;
    private JTextField textPrénomM;
    private JLabel specialité;
    private JLabel telephone;
    private JTextField textSpecialite;
    private JTextField textTelephone;
    private JButton validerRechercheM;
    private JLabel ouM;
    private JSeparator separator1M;
    private JLabel ajoutM;
    private JLabel nomM2;
    private JLabel prenomM2;
    private JLabel specialité2;
    private JLabel telephone2;
    private JTextField textNomM2;
    private JTextField textPrénomM2;
    private JTextField textSpecialite2;
    private JTextField textTelephone2;
    private JButton validerRechercheM2;


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
                JOptionPane.showMessageDialog(null, "Déconnexion", "Vous êtes déconnecté", JOptionPane.INFORMATION_MESSAGE);
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


        //setAjouterMedecin();
        //setAjouterPatient();


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


    /*public void setAjouterMedecin() {
        button1New.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                Medecin medecin1 = new Medecin(textField1.getText(),textField2.getText(),textField3.getText(),textField4.getText()," "); //ajouter mdp
                EcrireXML.saveToXML("src/donnees/dossiers2.xml","medecin",medecin1);
                listMedecin.ajouterMedecin(medecin1);

            }
        });
    }*/

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
    /*public void setAjouterPatient() {
        button1Patient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Patient patient1 = new Patient(textField1Patient.getText(), textField2Patient.getText(), new Date(14, 3, 1996),textField4Patient.getText());
                EcrireXML.saveToXML("src/donnees/dossiers2.xml","patient", patient1);
            }
        });

    }*/


    public void setPanelRegistrePatient() {
        rP = new JLabel();
        recherche = new JLabel();
        numSec = new JLabel();
        nom = new JLabel();
        ou = new JLabel();
        dateDeNaissance = new JLabel();
        prenom = new JLabel();
        textNumSecu = new JTextField();
        textNom = new JTextField();
        textPrénom = new JTextField();
        jour = new JTextField();
        mois = new JTextField();
        annee = new JTextField();
        validerRecherche = new JButton();
        recherche2 = new JLabel();
        numSecu2 = new JLabel();
        nom2 = new JLabel();
        prenom2 = new JLabel();
        dateDeNaissance2 = new JLabel();
        textNumSecu2 = new JTextField();
        textNom2 = new JTextField();
        textPrénom2 = new JTextField();
        separator1 = new JSeparator();
        jour2 = new JTextField();
        mois2 = new JTextField();
        annee2 = new JTextField();
        validerAjout = new JButton();

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
        recherche.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 14));
        panelRegistrePatient.add(recherche);
        recherche.setBounds(new Rectangle(new Point(55, 80), recherche.getPreferredSize()));

        //---- numSecu ----
        numSec.setText("Num\u00e9ro de s\u00e9curit\u00e9 sociale:");
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

        //---- ou ----
        ou.setText("OU");
        ou.setBorder(new EtchedBorder());
        ou.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panelRegistrePatient.add(ou);
        ou.setBounds(new Rectangle(new Point(480, 110), ou.getPreferredSize()));

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
        panelRegistrePatient.add(textPrénom);
        textPrénom.setBounds(210, 190, 250, textPrénom.getPreferredSize().height);
        panelRegistrePatient.add(jour);
        jour.setBounds(210, 230, 35, jour.getPreferredSize().height);
        panelRegistrePatient.add(mois);
        mois.setBounds(255, 230, 130, 24);
        panelRegistrePatient.add(annee);
        annee.setBounds(395, 230, 65, 24);

        //---- validerRecherche ----
        validerRecherche.setText("Valider");
        validerRecherche.setBackground(new Color(51, 153, 255));
        panelRegistrePatient.add(validerRecherche);
        validerRecherche.setBounds(new Rectangle(new Point(480, 255), validerRecherche.getPreferredSize()));

        //---- recherche2 ----
        recherche2.setText("Ajout d'un patient");
        recherche2.setForeground(Color.blue);
        recherche2.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 14));
        panelRegistrePatient.add(recherche2);
        recherche2.setBounds(55, 295, 160, 17);

        //---- numSecu2 ----
        numSecu2.setText("Num\u00e9ro de s\u00e9curit\u00e9 sociale:");
        numSecu2.setAlignmentX(0.5F);
        numSecu2.setBorder(new EtchedBorder());
        panelRegistrePatient.add(numSecu2);
        numSecu2.setBounds(35, 330, 160, 20);

        //---- nom2 ----
        nom2.setText("Nom:");
        nom2.setAlignmentX(0.5F);
        nom2.setBorder(new EtchedBorder());
        panelRegistrePatient.add(nom2);
        nom2.setBounds(150, 370, 45, 20);

        //---- prenom2 ----
        prenom2.setText("Pr\u00e9nom:");
        prenom2.setAlignmentX(0.5F);
        prenom2.setBorder(new EtchedBorder());
        panelRegistrePatient.add(prenom2);
        prenom2.setBounds(135, 410, 60, 15);

        //---- dateDeNaissance2 ----
        dateDeNaissance2.setText("Date de naissance (jj/mm/aaaa):");
        dateDeNaissance2.setAlignmentX(0.5F);
        dateDeNaissance2.setBorder(new EtchedBorder());
        panelRegistrePatient.add(dateDeNaissance2);
        dateDeNaissance2.setBounds(10, 445, 185, 20);
        panelRegistrePatient.add(textNumSecu2);
        textNumSecu2.setBounds(210, 325, 250, 24);
        panelRegistrePatient.add(textNom2);
        textNom2.setBounds(210, 365, 250, 24);
        panelRegistrePatient.add(textPrénom2);
        textPrénom2.setBounds(210, 405, 250, 24);
        panelRegistrePatient.add(separator1);
        separator1.setBounds(0, 285, 570, 15);
        panelRegistrePatient.add(jour2);
        jour2.setBounds(210, 445, 35, 24);
        panelRegistrePatient.add(mois2);
        mois2.setBounds(255, 445, 130, 24);
        panelRegistrePatient.add(annee2);
        annee2.setBounds(395, 445, 65, 24);

        //---- validerAjout ----
        validerAjout.setText("Valider");
        validerAjout.setBackground(new Color(51, 153, 255));
        panelRegistrePatient.add(validerAjout);
        validerAjout.setBounds(480, 475, 72, 24);

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

    public void setButtonRegistrePatient() {
        registrePatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au conteneur correspondant au nom fourni en paramètre
                cl.show(affichage, listContent[0]);
                if (registrePatient.isSelected()) {
                    rP.setVisible(true);
                    recherche.setVisible(true);
                    numSec.setVisible(true);
                    nom.setVisible(true);
                    ou.setVisible(true);
                    dateDeNaissance.setVisible(true);
                    prenom.setVisible(true);
                    textNumSecu.setVisible(true);
                    textNom.setVisible(true);
                    textPrénom.setVisible(true);
                    jour.setVisible(true);
                    mois.setVisible(true);
                    annee.setVisible(true);
                    validerRecherche.setVisible(true);
                    recherche2.setVisible(true);
                    numSecu2.setVisible(true);
                    nom2.setVisible(true);
                    dateDeNaissance2.setVisible(true);
                    prenom2.setVisible(true);
                    textNumSecu2.setVisible(true);
                    textNom2.setVisible(true);
                    textPrénom2.setVisible(true);
                    jour2.setVisible(true);
                    mois2.setVisible(true);
                    annee2.setVisible(true);
                    separator1.setVisible(true);
                    validerAjout.setVisible(true);
                } else {
                    rP.setVisible(false);
                    recherche.setVisible(false);
                    numSec.setVisible(false);
                    nom.setVisible(false);
                    ou.setVisible(false);
                    dateDeNaissance.setVisible(false);
                    prenom.setVisible(false);
                    textNumSecu.setVisible(false);
                    textNom.setVisible(false);
                    textPrénom.setVisible(false);
                    jour.setVisible(false);
                    mois.setVisible(false);
                    annee.setVisible(false);
                    validerRecherche.setVisible(false);
                    recherche2.setVisible(false);
                    numSecu2.setVisible(false);
                    nom2.setVisible(false);
                    dateDeNaissance2.setVisible(false);
                    prenom2.setVisible(false);
                    textNumSecu2.setVisible(false);
                    textNom2.setVisible(false);
                    textPrénom2.setVisible(false);
                    jour2.setVisible(false);
                    mois2.setVisible(false);
                    annee2.setVisible(false);
                    separator1.setVisible(false);
                    validerAjout.setVisible(false);
                }
            }
        });


    }

    public void setPanelRegistreMedecin() {

        rM = new JLabel();
        rechercheM = new JLabel();
        nomM = new JLabel();
        prenomM = new JLabel();
        textNomM = new JTextField();
        textPrénomM = new JTextField();
        specialité = new JLabel();
        telephone = new JLabel();
        textSpecialite = new JTextField();
        textTelephone = new JTextField();
        validerRechercheM = new JButton();
        ouM = new JLabel();
        separator1M = new JSeparator();
        ajoutM = new JLabel();
        nomM2 = new JLabel();
        prenomM2 = new JLabel();
        specialité2 = new JLabel();
        telephone2 = new JLabel();
        textNomM2 = new JTextField();
        textPrénomM2 = new JTextField();
        textSpecialite2 = new JTextField();
        textTelephone2 = new JTextField();
        validerRechercheM2 = new JButton();

        //======== this ========


        panelRegistreMedecin.setLayout(null);

        //---- rM ----
        rM.setText("Registre Medecins");
        rM.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
        rM.setForeground(Color.magenta);
        panelRegistreMedecin.add(rM);
        rM.setBounds(new Rectangle(new Point(225, 30), rM.getPreferredSize()));

        //---- rechercheM ----
        rechercheM.setText("Recherche");
        rechercheM.setForeground(Color.orange);
        rechercheM.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 14));
        panelRegistreMedecin.add(rechercheM);
        rechercheM.setBounds(55, 80, 93, 17);

        //---- nomM ----
        nomM.setText("Nom:");
        nomM.setAlignmentX(0.5F);
        nomM.setBorder(new EtchedBorder());
        panelRegistreMedecin.add(nomM);
        nomM.setBounds(130, 115, 40, 20);

        //---- prenomM ----
        prenomM.setText("Prenom:");
        prenomM.setAlignmentX(0.5F);
        prenomM.setBorder(new EtchedBorder());
        panelRegistreMedecin.add(prenomM);
        prenomM.setBounds(115, 155, 55, 15);
        panelRegistreMedecin.add(textNomM);
        textNomM.setBounds(180, 110, 250, 24);
        panelRegistreMedecin.add(textPrénomM);
        textPrénomM.setBounds(180, 150, 250, 24);

        //---- specialité ----
        specialité.setText("Specialite:");
        specialité.setAlignmentX(0.5F);
        specialité.setBorder(new EtchedBorder());
        panelRegistreMedecin.add(specialité);
        specialité.setBounds(105, 190, 65, 20);

        //---- telephone ----
        telephone.setText("Telephone:");
        telephone.setAlignmentX(0.5F);
        telephone.setBorder(new EtchedBorder());
        panelRegistreMedecin.add(telephone);
        telephone.setBounds(100, 230, 70, 20);
        panelRegistreMedecin.add(textSpecialite);
        textSpecialite.setBounds(180, 190, 250, textSpecialite.getPreferredSize().height);
        panelRegistreMedecin.add(textTelephone);
        textTelephone.setBounds(180, 230, 250, textTelephone.getPreferredSize().height);

        //---- validerRechercheM ----
        validerRechercheM.setText("Valider");
        validerRechercheM.setBackground(new Color(51, 153, 255));
        panelRegistreMedecin.add(validerRechercheM);
        validerRechercheM.setBounds(445, 255, 72, 24);

        //---- ouM ----
        ouM.setText("OU");
        ouM.setBorder(new EtchedBorder());
        ouM.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panelRegistreMedecin.add(ouM);
        ouM.setBounds(445, 150, 25, 24);
        panelRegistreMedecin.add(separator1M);
        separator1M.setBounds(0, 285, 570, 15);

        //---- ajoutM ----
        ajoutM.setText("Ajout d'un medecin");
        ajoutM.setForeground(Color.orange);
        ajoutM.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 14));
        panelRegistreMedecin.add(ajoutM);
        ajoutM.setBounds(55, 295, 175, 17);

        //---- nomM2 ----
        nomM2.setText("Nom:");
        nomM2.setAlignmentX(0.5F);
        nomM2.setBorder(new EtchedBorder());
        panelRegistreMedecin.add(nomM2);
        nomM2.setBounds(130, 330, 40, 20);

        //---- prenomM2 ----
        prenomM2.setText("Pr\u00e9nom:");
        prenomM2.setAlignmentX(0.5F);
        prenomM2.setBorder(new EtchedBorder());
        panelRegistreMedecin.add(prenomM2);
        prenomM2.setBounds(115, 370, 55, 15);

        //---- specialité2 ----
        specialité2.setText("Specialite:");
        specialité2.setAlignmentX(0.5F);
        specialité2.setBorder(new EtchedBorder());
        panelRegistreMedecin.add(specialité2);
        specialité2.setBounds(105, 405, 65, 20);

        //---- telephone2 ----
        telephone2.setText("Telephone:");
        telephone2.setAlignmentX(0.5F);
        telephone2.setBorder(new EtchedBorder());
        panelRegistreMedecin.add(telephone2);
        telephone2.setBounds(100, 445, 70, 20);
        panelRegistreMedecin.add(textNomM2);
        textNomM2.setBounds(180, 325, 250, 24);
        panelRegistreMedecin.add(textPrénomM2);
        textPrénomM2.setBounds(180, 365, 250, 24);
        panelRegistreMedecin.add(textSpecialite2);
        textSpecialite2.setBounds(180, 405, 250, 24);
        panelRegistreMedecin.add(textTelephone2);
        textTelephone2.setBounds(180, 445, 250, 24);

        //---- validerRechercheM2 ----
        validerRechercheM2.setText("Valider");
        validerRechercheM2.setBackground(new Color(51, 153, 255));
        panelRegistreMedecin.add(validerRechercheM2);
        validerRechercheM2.setBounds(445, 475, 72, 24);

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


    public void setButtonRegistreMedecin() {
        registreMedecin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au conteneur correspondant au nom fourni en paramètre
                cl.show(affichage, listContent[1]);
                if (registreMedecin.isSelected()) {
                    rM.setVisible(true);
                    rechercheM.setVisible(true);
                    nomM.setVisible(true);
                    ouM.setVisible(true);
                    specialité.setVisible(true);
                    telephone.setVisible(true);
                    prenomM.setVisible(true);
                    textNomM.setVisible(true);
                    textPrénomM.setVisible(true);
                    textSpecialite.setVisible(true);
                    textTelephone.setVisible(true);
                    validerRechercheM.setVisible(true);
                    ajoutM.setVisible(true);
                    textSpecialite2.setVisible(true);
                    specialité2.setVisible(true);
                    nomM2.setVisible(true);
                    prenomM2.setVisible(true);
                    textNomM2.setVisible(true);
                    textPrénomM2.setVisible(true);
                    telephone2.setVisible(true);
                    textTelephone2.setVisible(true);
                    separator1M.setVisible(true);
                    validerRechercheM2.setVisible(true);
                } else {
                    rM.setVisible(false);
                    rechercheM.setVisible(false);
                    nomM.setVisible(false);
                    ouM.setVisible(false);
                    specialité.setVisible(false);
                    telephone.setVisible(false);
                    prenomM.setVisible(false);
                    textNomM.setVisible(false);
                    textPrénomM.setVisible(false);
                    textSpecialite.setVisible(false);
                    textTelephone.setVisible(false);
                    validerRechercheM.setVisible(false);
                    ajoutM.setVisible(false);
                    textSpecialite2.setVisible(false);
                    specialité2.setVisible(false);
                    nomM2.setVisible(false);
                    prenomM2.setVisible(false);
                    textNomM2.setVisible(false);
                    textPrénomM2.setVisible(false);
                    telephone2.setVisible(false);
                    textTelephone2.setVisible(false);
                    separator1M.setVisible(false);
                    validerRechercheM2.setVisible(false);
                }
            }
        });


    }
}
