package princetonPlainsboro;

import affichage.Login;

import javax.swing.*;
import javax.swing.border.BevelBorder;
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
    private String[] listContent = {" ACCUEIL", "REGISTRE_PATIENT", "REGISTRE_MEDECIN", "FICHIER_MEDICAL", "CREER_UNE_FICHE", "ACTE_MEDICAL", "DECONNEXION"};
    private JPanel menuderoulant = new JPanel();
    private JPanel haut = new JPanel();
    private JPanel bas = new JPanel();
    private JTextArea dossierMed;
    private JToggleButton registrePatient;
    private JPanel panelRegistrePatient;
    private JToggleButton registreMedecin;
    private JButton button1New;
    private JPanel panelRegistreMedecin;

    private JPanel panelActe;


    private JLabel rAM;
    private JLabel acte;
    private JLabel type;
    private JLabel code;
    private JLabel coeff;
    private JLabel cout;
    private JTextField textType;
    private JTextField textCode;
    private JTextField textCoef;
    private JTextField textCout;
    private JLabel euro;
    private JButton validerActe;

    private JLabel rP;
    private JLabel recherche;
    private JLabel numSec;
    private JLabel nom;
    private JLabel ou;
    private JLabel dateDeNaissance;
    private JLabel prenom;
    private JTextField textNumSecu;
    private JTextField textNom;
    private JTextField textPrenom;
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
    private JTextField textPrenom2;
    private JTextField jour2;
    private JTextField mois2;
    private JTextField annee2;
    private JSeparator separator1;
    private JButton validerAjout;
    private JLabel adresse;
    private JTextField textAdresse;
    private JLabel adresse2;
    private JTextField textAdresse2;

    private JLabel rM;
    private JLabel rechercheM;
    private JLabel nomM;
    private JLabel prenomM;
    private JTextField textNomM;
    private JTextField textPrenomM;
    private JLabel specialite;
    private JLabel telephone;
    private JTextField textSpecialite;
    private JTextField textTelephone;
    private JButton validerRechercheM;
    private JLabel ouM;
    private JSeparator separator1M;
    private JLabel ajoutM;
    private JLabel nomM2;
    private JLabel prenomM2;
    private JLabel specialite2;
    private JLabel telephone2;
    private JTextField textNomM2;
    private JTextField textPrenomM2;
    private JTextField textSpecialite2;
    private JTextField textTelephone2;
    private JButton validerRechercheM2;
    private JLabel mdpMedecin;
    private JTextField textmdpMedecin;

    private JButton trieDate;
    private JButton listeMedecin;
    private JButton trieCout;
    private JButton listePatient;
    private JButton entreDeuxDates;
    private JButton ficheDUnPatient;
    private JTextField listePatientText;
    private JButton dossierMedical;
    private JTextField date1;
    private JTextField date2;
    private JTextField date3;
    private JTextField date4;
    private JTextField date5;
    private JTextField date6;
    private JLabel textdate1;
    private JLabel textdate2;
    private JTextField textFiche;
    private JPanel hautRegistreM;
    private JPanel panelAccueil;


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
        panelAccueil = new JPanel();
        panelAccueil.setLayout(new BorderLayout());



        final JPanel panelRegistreM = new JPanel();
        final JPanel hautRegistreM = new JPanel();
        JPanel panelDeconnexion = new JPanel();
        panelActe = new JPanel();
        panelFicheSoin = new JPanel();

        ImagePanel();

        //creation des boutons
        actemedical = new JToggleButton("Acte Medical");
        haut.add(actemedical, BorderLayout.CENTER);
        Font police = new Font(Constants.TAHOMA.getValue(), Font.BOLD, 16);
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

        hautRegistreM.setPreferredSize(new Dimension(500, 110));

        dossierMedical = new JButton("Dossier Médical");
        dossierMedical.setPreferredSize(new Dimension(160, 25));
        hautRegistreM.add(dossierMedical);
        listeMedecin = new JButton("Liste des médecins");
        listeMedecin.setPreferredSize(new Dimension(160, 25));
        hautRegistreM.add(listeMedecin);
        listePatient = new JButton("Liste des patients");
        listePatient.setPreferredSize(new Dimension(160, 25));
        hautRegistreM.add(listePatient);
        trieDate = new JButton("Trier les fiches par dates");
        trieDate.setPreferredSize(new Dimension(180, 25));
        hautRegistreM.add(trieDate);
        trieCout = new JButton("Trier les fiches par cout");
        trieCout.setPreferredSize(new Dimension(160, 25));
        hautRegistreM.add(trieCout);
        ficheDUnPatient = new JButton("Afficher le dossier d'un patient via numéro de sécu");
        hautRegistreM.add(ficheDUnPatient);
        textFiche = new JTextField();
        textFiche.setPreferredSize(new Dimension(60, 25));
        hautRegistreM.add(textFiche);
        entreDeuxDates = new JButton("Fiches entre les dates suivantes :");
        entreDeuxDates.setPreferredSize(new Dimension(200, 25));
        hautRegistreM.add(entreDeuxDates);
        textdate1 = new JLabel("Date de début JJ/MM/AAAA : ");
        textdate2 = new JLabel("Date de fin JJ/MM/AAAA : ");
        hautRegistreM.add(textdate1);

        date1 = new JTextField();
        date2 = new JTextField();
        date3 = new JTextField();
        date4 = new JTextField();
        date5 = new JTextField();
        date6 = new JTextField();
        date1.setPreferredSize(new Dimension(25, 25));
        date2.setPreferredSize(new Dimension(25, 25));
        date3.setPreferredSize(new Dimension(40, 25));
        date4.setPreferredSize(new Dimension(25, 25));
        date5.setPreferredSize(new Dimension(25, 25));
        date6.setPreferredSize(new Dimension(40, 25));
        hautRegistreM.add(date1);
        hautRegistreM.add(date2);
        hautRegistreM.add(date3);
        hautRegistreM.add(textdate2);
        hautRegistreM.add(date4);
        hautRegistreM.add(date5);
        hautRegistreM.add(date6);

        //recupère Les fiches de soins du XML
        final LectureXML test = new LectureXML("dossiers.xml");
        final DossierMedical dm1 = test.getDossier();
        dossierMed = new JTextArea(dm1.toStringDM());
        final JScrollPane sp = new JScrollPane(dossierMed);
        panelRegistreM.add(sp, BorderLayout.CENTER);
        panelRegistreM.add(hautRegistreM, BorderLayout.SOUTH);

        sp.setVisible(false);

        //titre registre Medical
        final JLabel registreM = new JLabel("Registre Medical");
        panelRegistreM.add(registreM, BorderLayout.NORTH);
        registreM.setVisible(false);
        Font police1 = new Font(Constants.TAHOMA.getValue(), Font.BOLD, 20);
        registreM.setFont(police1);
        registreM.setHorizontalAlignment(JLabel.CENTER);
        registreM.setVerticalAlignment(JLabel.CENTER);

        //Définition de l'action du bouton fichierMedical
        fichierMedical.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au prochain conteneur de la pile
                cl.show(affichage, listContent[3]);
                if (fichierMedical.isSelected()) {

                    sp.setVisible(true);
                    registreM.setVisible(true);
                    hautRegistreM.setVisible(true);
                } else {
                    sp.setVisible(false);
                    registreM.setVisible(false);
                    hautRegistreM.setVisible(false);
                }
            }
        });
        //boutons registre médical
        ficheDUnPatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au prochain conteneur de la pile
                dossierMed.setForeground(Color.BLACK);
                dossierMed.setText(dm1.rechercherfichesDUnPatient(textFiche.getText()).toString());

            }
        });

        dossierMedical.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au prochain conteneur de la pile
                dossierMed.setForeground(Color.BLACK);
                dossierMed.setText(dm1.toStringDM());

            }
        });

        ficheDUnPatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au prochain conteneur de la pile
                LectureXML test = new LectureXML("dossiers.xml");
                DossierMedical dm1 = test.getDossier();
                dossierMed = new JTextArea(dm1.toStringDM());
                panelRegistreMedecin.add(dossierMed, BorderLayout.CENTER);
                dossierMed.setVisible(false);
                if (dm1.rechercherfichesDUnPatient(textFiche.getText()) == null) {
                    dossierMed.setForeground(Color.GRAY);
                    dossierMed.setText("Pas de correspondance...");
                } else {
                    dossierMed.setForeground(Color.BLACK);
                    dossierMed.setText(dm1.rechercherfichesDUnPatient(textFiche.getText()).toString());
                }

            }
        });

        entreDeuxDates.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au prochain conteneur de la pile
                dossierMed.setForeground(Color.BLACK);
                Date d1 = new Date(Integer.parseInt(date1.getText()), Integer.parseInt(date2.getText()), Integer.parseInt(date3.getText()));
                Date d2 = new Date(Integer.parseInt(date4.getText()), Integer.parseInt(date5.getText()), Integer.parseInt(date6.getText()));
                dm1.trierEntreDeuxDates(d1, d2, new ComparaisonFichesCouts());
                dossierMed.setText(dm1.toStringDM());

            }
        });

        listePatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au prochain conteneur de la pile
                dossierMed.setForeground(Color.BLACK);
                dossierMed.setText(test.getListePatient().toString());

            }
        });

        listeMedecin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au prochain conteneur de la pile
                dossierMed.setForeground(Color.BLACK);
                dossierMed.setText(test.getListeMedecin().toString());

            }
        });

        trieDate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au prochain conteneur de la pile
                dossierMed.setForeground(Color.BLACK);
                dm1.trierDates();
                dossierMed.setText(dm1.toStringDM());

            }
        });

        trieCout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au prochain conteneur de la pile
                dossierMed.setForeground(Color.BLACK);
                dm1.trier(new ComparaisonFichesCouts());
                dossierMed.setText(dm1.toStringDM());

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
        //  PAS DE MODIF EN DESSOUS

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

        setPanelRegistrePatient();
        setButtonRegistrePatient();
        setPanelRegistreMedecin();
        setButtonRegistreMedecin();
        setPanelActe();
        setButtonActe();
        setRechercherPatient();
        setAjouterMedecin();
        setAjouterPatient();
        setRechercherMedecin();
        ImagePanelAccueil();
        setRechercheCout();
    }

    public void setRechercheCout(){
        validerActe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Acte acte = new Acte(Code.valueOf(textCode.getText()), Integer.parseInt(textType.getText()));
                    textCoef.setText(acte.getCode().getLibelle());
                    textCout.setText(String.valueOf(acte.cout()));

            }
        });
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

    public void setPanelActe() {

        rAM = new JLabel();
        acte = new JLabel();
        type = new JLabel();
        code = new JLabel();
        coeff = new JLabel();
        cout = new JLabel();
        textType = new JTextField();
        textCode = new JTextField();
        textCoef = new JTextField();
        textCout = new JTextField();
        euro = new JLabel();
        validerActe = new JButton();

        //======== this ========


        panelActe.setLayout(null);

        //---- rAM ----
        rAM.setText("Rechercher d'un acte medical");
        rAM.setFont(new Font("Arimo", Font.BOLD, 22));
        rAM.setForeground(new Color(51, 0, 153));
        panelActe.add(rAM);
        rAM.setBounds(150, 35, 350, 30);
        rAM.setHorizontalAlignment(JLabel.CENTER);
        rAM.setVerticalAlignment(JLabel.CENTER);

        //---- acte ----
        acte.setText("ACTE");
        acte.setForeground(new Color(0, 102, 102));
        acte.setFont(new Font(Constants.COPPERPLATE.getValue(), Font.BOLD, 14));
        panelActe.add(acte);
        acte.setBounds(70, 95, 50, acte.getPreferredSize().height);

        //---- type ----
        type.setText("Coefficient :");
        type.setBorder(new BevelBorder(BevelBorder.LOWERED));
        panelActe.add(type);
        type.setBounds(70, 140, 75, type.getPreferredSize().height);

        //---- code ----
        code.setText("Code :");
        code.setBorder(new BevelBorder(BevelBorder.LOWERED));
        panelActe.add(code);
        code.setBounds(100, 175, 45, code.getPreferredSize().height);

        //---- coeff ----
        coeff.setText("Type :");
        coeff.setBorder(new BevelBorder(BevelBorder.LOWERED));
        panelActe.add(coeff);
        coeff.setBounds(100, 210, 45, coeff.getPreferredSize().height);

        //---- cout ----
        cout.setText(" Cout :");
        cout.setBorder(new BevelBorder(BevelBorder.LOWERED));
        panelActe.add(cout);
        cout.setBounds(100, 245, 45, 15);
        panelActe.add(textType);
        textType.setBounds(150, 135, 235, textType.getPreferredSize().height);
        panelActe.add(textCode);
        textCode.setBounds(150, 170, 235, textCode.getPreferredSize().height);
        panelActe.add(textCoef);
        textCoef.setBounds(150, 205, 235, textCoef.getPreferredSize().height);
        panelActe.add(textCout);
        textCout.setBounds(150, 240, 235, textCout.getPreferredSize().height);

        //---- euro ----
        euro.setText("\u20ac");
        euro.setBorder(new BevelBorder(BevelBorder.LOWERED));
        panelActe.add(euro);
        euro.setBounds(220, 245, 15, euro.getPreferredSize().height);

        //---- validerActe ----
        validerActe.setText(Constants.VALIDER.getValue());
        validerActe.setBackground(new Color(0, 161, 219));
        panelActe.add(validerActe);
        validerActe.setBounds(new Rectangle(new Point(400, 170), validerActe.getPreferredSize()));
        computePreferedSize(panelActe);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public void setButtonActe() {

        actemedical.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au conteneur correspondant au nom fourni en paramètre
                cl.show(affichage, listContent[5]);
                textCoef.setEditable(false);
                textCout.setEditable(false);

                if (actemedical.isSelected()) {
                    rAM.setVisible(true);
                    acte.setVisible(true);
                    type.setVisible(true);
                    code.setVisible(true);
                    coeff.setVisible(true);
                    cout.setVisible(true);
                    textType.setVisible(true);
                    textCode.setVisible(true);
                    textCoef.setVisible(true);
                    textCout.setVisible(true);
                    euro.setVisible(true);
                    validerActe.setVisible(true);
                } else {
                    rAM.setVisible(false);
                    acte.setVisible(false);
                    type.setVisible(false);
                    code.setVisible(false);
                    coeff.setVisible(false);
                    cout.setVisible(false);
                    textType.setVisible(false);
                    textCode.setVisible(false);
                    textCoef.setVisible(false);
                    textCout.setVisible(false);
                    euro.setVisible(false);
                    validerActe.setVisible(false);
                }
            }
        });

    }


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
        textPrenom = new JTextField();
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
        textPrenom2 = new JTextField();
        separator1 = new JSeparator();
        jour2 = new JTextField();
        mois2 = new JTextField();
        annee2 = new JTextField();
        validerAjout = new JButton();
        adresse = new JLabel();
        textAdresse = new JTextField();
        adresse2 = new JLabel();
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
        numSecu2.setText("Num\u00e9ro de s\u00e9curit\u00e9 sociale:");
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
        prenom2.setText("Pr\u00e9nom:");
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


        computePreferedSize(panelRegistrePatient);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

    }

    public void setRechercherPatient() {
        System.out.println("marche");
        validerRecherche.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                LectureXML test1 = new LectureXML("listePatient.xml");
                ListePatient listePatient = test1.getListePatient();
                System.out.println(listePatient.rechercher(textNumSecu.getText()));
                textNom.setText(listePatient.rechercher(textNumSecu.getText()).getNom());
                textPrenom.setText(listePatient.rechercher(textNumSecu.getText()).getPrenom());
                jour.setText(listePatient.rechercher(textNumSecu.getText()).getDateNaissance().toString());
                textAdresse.setText(listePatient.rechercher(textNumSecu.getText()).getAdresse());
            }
        });
    }

    public void setButtonRegistrePatient() {
        registrePatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au conteneur correspondant au nom fourni en paramètre
                cl.show(affichage, listContent[1]);
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
                    textPrenom.setVisible(true);
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
                    textPrenom2.setVisible(true);
                    jour2.setVisible(true);
                    mois2.setVisible(true);
                    annee2.setVisible(true);
                    separator1.setVisible(true);
                    validerAjout.setVisible(true);
                    adresse.setVisible(true);
                    textAdresse.setVisible(true);
                    adresse2.setVisible(true);
                    textAdresse2.setVisible(true);

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
                    textPrenom.setVisible(false);
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
                    textPrenom2.setVisible(false);
                    jour2.setVisible(false);
                    mois2.setVisible(false);
                    annee2.setVisible(false);
                    separator1.setVisible(false);
                    validerAjout.setVisible(false);
                    adresse.setVisible(false);
                    textAdresse.setVisible(false);
                    adresse2.setVisible(false);
                    textAdresse2.setVisible(false);

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
        textPrenomM = new JTextField();
        specialite = new JLabel();
        telephone = new JLabel();
        textSpecialite = new JTextField();
        textTelephone = new JTextField();
        validerRechercheM = new JButton();
        ouM = new JLabel();
        separator1M = new JSeparator();
        ajoutM = new JLabel();
        nomM2 = new JLabel();
        prenomM2 = new JLabel();
        specialite2 = new JLabel();
        telephone2 = new JLabel();
        textNomM2 = new JTextField();
        textPrenomM2 = new JTextField();
        textSpecialite2 = new JTextField();
        textTelephone2 = new JTextField();
        validerRechercheM2 = new JButton();
        mdpMedecin = new JLabel();
        textmdpMedecin = new JTextField();

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
        rechercheM.setFont(new Font(Constants.COPPERPLATE.getValue(), Font.BOLD, 14));
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
        panelRegistreMedecin.add(textPrenomM);
        textPrenomM.setBounds(180, 150, 250, 24);

        //---- specialite ----
        specialite.setText("Specialite:");
        specialite.setAlignmentX(0.5F);
        specialite.setBorder(new EtchedBorder());
        panelRegistreMedecin.add(specialite);
        specialite.setBounds(105, 190, 65, 20);

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
        validerRechercheM.setText(Constants.VALIDER.getValue());
        validerRechercheM.setBackground(new Color(51, 153, 255));
        panelRegistreMedecin.add(validerRechercheM);
        validerRechercheM.setBounds(445, 150, 72, 24);

        //---- ouM ----

        panelRegistreMedecin.add(separator1M);
        separator1M.setBounds(0, 285, 1200, 15);

        //---- ajoutM ----
        ajoutM.setText("Ajout d'un medecin");
        ajoutM.setForeground(Color.orange);
        ajoutM.setFont(new Font(Constants.COPPERPLATE.getValue(), Font.BOLD, 14));
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

        //---- specialite2 ----
        specialite2.setText("Specialite:");
        specialite2.setAlignmentX(0.5F);
        specialite2.setBorder(new EtchedBorder());
        panelRegistreMedecin.add(specialite2);
        specialite2.setBounds(105, 405, 65, 20);

        //---- telephone2 ----
        telephone2.setText("Telephone:");
        telephone2.setAlignmentX(0.5F);
        telephone2.setBorder(new EtchedBorder());
        panelRegistreMedecin.add(telephone2);
        telephone2.setBounds(100, 445, 70, 20);
        panelRegistreMedecin.add(textNomM2);
        textNomM2.setBounds(180, 325, 250, 24);
        panelRegistreMedecin.add(textPrenomM2);
        textPrenomM2.setBounds(180, 365, 250, 24);
        panelRegistreMedecin.add(textSpecialite2);
        textSpecialite2.setBounds(180, 405, 250, 24);
        panelRegistreMedecin.add(textTelephone2);
        textTelephone2.setBounds(180, 445, 250, 24);

        //---- mdp2 ----
        mdpMedecin.setText("Mot de passe :");
        mdpMedecin.setAlignmentX(0.5F);
        mdpMedecin.setBorder(new EtchedBorder());
        panelRegistreMedecin.add(mdpMedecin);
        mdpMedecin.setBounds(80, 475, 93, 20);
        panelRegistreMedecin.add(textmdpMedecin);
        textmdpMedecin.setBounds(180, 475, 250, 24);

        //---- validerRechercheM2 ----
        validerRechercheM2.setText(Constants.VALIDER.getValue());
        validerRechercheM2.setBackground(new Color(51, 153, 255));
        panelRegistreMedecin.add(validerRechercheM2);
        validerRechercheM2.setBounds(445, 535, 72, 24);

        computePreferedSize(panelRegistreMedecin);

    }

    public void setRechercherMedecin() {
        validerRechercheM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                LectureXML test1 = new LectureXML("listeMedecin.xml");
                ListeMedecin listeMedecin = test1.getListeMedecin();
                System.out.println(listeMedecin.rechercherMedecin(textNomM.getText(), textPrenomM.getText()));
                if (textPrenom.getText() != null && textNom.getText() != null) {
                    textSpecialite.setText(listeMedecin.rechercherMedecin(textNomM.getText(), textPrenomM.getText()).getSpecialite());
                    textTelephone.setText(listeMedecin.rechercherMedecin(textNomM.getText(), textPrenomM.getText()).getNumeroTel());
                }
            }
        });
    }

    public void setButtonRegistreMedecin() {
        registreMedecin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au conteneur correspondant au nom fourni en paramètre
                cl.show(affichage, listContent[2]);
                if (registreMedecin.isSelected()) {
                    rM.setVisible(true);
                    rechercheM.setVisible(true);
                    nomM.setVisible(true);
                    ouM.setVisible(true);
                    specialite.setVisible(true);
                    telephone.setVisible(true);
                    prenomM.setVisible(true);
                    textNomM.setVisible(true);
                    textPrenomM.setVisible(true);
                    textSpecialite.setVisible(true);
                    textTelephone.setVisible(true);
                    validerRechercheM.setVisible(true);
                    ajoutM.setVisible(true);
                    textSpecialite2.setVisible(true);
                    specialite2.setVisible(true);
                    nomM2.setVisible(true);
                    prenomM2.setVisible(true);
                    textNomM2.setVisible(true);
                    textPrenomM2.setVisible(true);
                    telephone2.setVisible(true);
                    textTelephone2.setVisible(true);
                    separator1M.setVisible(true);
                    validerRechercheM2.setVisible(true);
                    mdpMedecin.setVisible(true);
                    textmdpMedecin.setVisible(true);
                } else {
                    rM.setVisible(false);
                    rechercheM.setVisible(false);
                    nomM.setVisible(false);
                    ouM.setVisible(false);
                    specialite.setVisible(false);
                    telephone.setVisible(false);
                    prenomM.setVisible(false);
                    textNomM.setVisible(false);
                    textPrenomM.setVisible(false);
                    textSpecialite.setVisible(false);
                    textTelephone.setVisible(false);
                    validerRechercheM.setVisible(false);
                    ajoutM.setVisible(false);
                    textSpecialite2.setVisible(false);
                    specialite2.setVisible(false);
                    nomM2.setVisible(false);
                    prenomM2.setVisible(false);
                    textNomM2.setVisible(false);
                    textPrenomM2.setVisible(false);
                    telephone2.setVisible(false);
                    textTelephone2.setVisible(false);
                    separator1M.setVisible(false);
                    validerRechercheM2.setVisible(false);
                    mdpMedecin.setVisible(false);
                    textmdpMedecin.setVisible(false);
                }
            }
        });

    }

    public void setAjouterMedecin() {
        validerRechercheM2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Medecin medecin = new Medecin(textNomM2.getText(), textPrenomM2.getText(), textSpecialite2.getText(), textTelephone2.getText(), textmdpMedecin.getText());
                EcrireXML.saveToXML("src/donnees/dossiers2.xml", "medecin", medecin);
            }
        });

    }

    public void setAjouterPatient() {

        validerAjout.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                Patient patient = new Patient(textNom2.getText(), textPrenom2.getText(), textAdresse2.getText(), textNumSecu2.getText(), new Date(Integer.parseInt(jour2.getText()), Integer.parseInt(mois2.getText()), Integer.parseInt(annee2.getText())));
                EcrireXML.saveToXML("src/donnees/ListePatient.xml", "patient", patient);
                JOptionPane.showMessageDialog(null, "Ajout Patient", "Réussis", JOptionPane.INFORMATION_MESSAGE);

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


    private void computePreferedSize(JPanel panel) {
        Dimension preferredSize = new Dimension();
        for (int i = 0; i < panel.getComponentCount(); i++) {
            Rectangle bounds = panel.getComponent(i).getBounds();
            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
        }
        Insets insets = panel.getInsets();
        preferredSize.width += insets.right;
        preferredSize.height += insets.bottom;
        panel.setMinimumSize(preferredSize);
        panel.setPreferredSize(preferredSize);
    }
}