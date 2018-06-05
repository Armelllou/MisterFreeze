/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

import affichage.Login;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.List;

public class InterfaceSecretaireMedical extends JFrame {

    private JLabel picLabel;
    private JToggleButton actemedical;
    private JToggleButton ficheSoin;
    private JPanel panelFicheSoin;
    private Font police = new Font(Constants.TAHOMA.getValue(), Font.BOLD, 16);

    private CardLayout cl = new CardLayout();
    private JPanel affichage = new JPanel();
    //Liste des noms de nos conteneurs pour la supperposition des JPanels
    private String[] listContent = {"ACCUEIL","REGISTRE_PATIENT", "REGISTRE_MEDECIN", "FICHIER_MEDICAL", "CREER_UNE_FICHE", "ACTE_MEDICAL", "DECONNEXION"};
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
    private JButton buttonImp;
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
    private JComboBox comboBox2;
    private JLabel label21;
    private JLabel label22;
    private JTextField coef;
    private JLabel label23;
    private JTextArea scrollPane1;
    private JTextArea textArea1;
    private ListeMedecin listeMedecin;
    private JToggleButton deconnexion;
    private JToggleButton fichierMedical;
    private JLabel registreM;
    private JLabel labelajoutActe;
    private JButton buttonAjoutActe;
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

    private JLabel rP;
    private JLabel recherche;
    private JLabel numSec;
    private JLabel nom;
    private JLabel ou;
    private JLabel dateDeNaissance;
    private JLabel adresse;
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
    private JTextField textAdresse;
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

        setPanelRegistrePatient();
        setButtonRegistrePatient();
        setPanelRegistreMedecin();
        setButtonRegistreMedecin();
        setPanelActe();
        setButtonActe();
        setButtonFicheSoin();
        setPanelFicheSoin();
        setAjouterFicheSoin();
        setRechercherMedecin();
        setButtonImprimer();
        setRechercherPatient();
        setButtonDeconnexion();
        setButtonFichierMedical();
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
        comboBox2 = new JComboBox();
        label21 = new JLabel();
        label22 = new JLabel();
        coef = new JTextField();
        label23 = new JLabel();
        scrollPane1 = new JTextArea();
        textArea1 = new JTextArea();
        button1New = new JButton();
        buttonImp = new JButton();
        labelajoutActe = new JLabel();
        buttonAjoutActe = new JButton();

        //======== panelFicheSoin ========
        {
            coef.addKeyListener(new KeyAdapter() {
                                    @Override
                                    public void keyPressed(KeyEvent e) {
                                        final List<Acte> actes = new ArrayList<Acte>();
                                        int key = e.getKeyCode();
                                        if (key == KeyEvent.VK_ENTER) {
                                            Toolkit.getDefaultToolkit().beep();
                                            setAjouterFicheSoin();
                                            System.out.println("test");
                                            System.out.println(comboBox1.getItemAt(comboBox1.getSelectedIndex()));
                                            String s = comboBox1.getItemAt(comboBox1.getSelectedIndex()).toString();
                                            Acte a = new Acte(Code.valueOf(s), Integer.parseInt(coef.getText()));
                                            actes.add(a);
                                            scrollPane1.setText(actes.toString());
                                        }
                                    }
                                }
            );
            panelFicheSoin.setLayout(null);

            //---- label11 ----
            label11.setText("Ajouter une nouvelle fiche de soin");
            label11.setFont(new Font(Constants.SEGOE.getValue(), Font.BOLD, 22));
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
            comboBox1.setBounds(90, 260, 90, 30);
            for (Code code : Code.values()) {
                comboBox1.addItem(code.name());
            }
            panelFicheSoin.add(comboBox2);
            comboBox2.setBounds(265, 260, 135, 30);
            comboBox2.addItem("thérapeutique");
            comboBox2.addItem("diagnostique");

            //---- label ajouter acte ----
            labelajoutActe.setText("Ajouter acte");
            panelFicheSoin.add(labelajoutActe);
            labelajoutActe.setBounds(20, 220, 90, 30);
            labelajoutActe.setFont(new Font(Constants.SEGOE.getValue(), Font.PLAIN, 15));

            //---- label21 ----
            label21.setText("Code ");
            panelFicheSoin.add(label21);
            label21.setBounds(new Rectangle(new Point(20, 265), label21.getPreferredSize()));

            //---- label22 ----
            label22.setText("Coefficient");
            panelFicheSoin.add(label22);
            label22.setBounds(new Rectangle(new Point(15, 305), label22.getPreferredSize()));
            panelFicheSoin.add(coef);
            coef.setBounds(90, 300, 80, 25);

            //---- label23 ----
            label23.setText("Liste Acte");
            panelFicheSoin.add(label23);
            label23.setBounds(new Rectangle(new Point(10, 345), label23.getPreferredSize()));

            //======== scrollPane1 ========
            panelFicheSoin.add(scrollPane1);
            scrollPane1.setBounds(90, 340, 350, 250);

            //---- buttonAjouterActe ----
            buttonAjoutActe.setText("Ajouter un Acte");
            panelFicheSoin.add(buttonAjoutActe);
            buttonAjoutActe.setBounds(445, 340, 155, 40);

            //---- button1New ----
            button1New.setText(Constants.VALIDER.getValue());
            panelFicheSoin.add(button1New);
            button1New.setBounds(445, 430, 105, 40);

            //---- buttonImprimer ----
            buttonImp.setText("Imprimer la fiche de soin");
            panelFicheSoin.add(buttonImp);
            buttonImp.setBounds(445, 470, 200, 40);

            computePreferedSize(panelFicheSoin);

        }
    }

    public void setButtonImprimer() {
        buttonImp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                PrinterJob job = PrinterJob.getPrinterJob();
                /* On donne le contenu à imprimer au job */
                //job.setPrintable(FicheDeSoins ficheCree);
                /* Affichage de la boite de dialogue d'impression */
                boolean doPrint = job.printDialog();
                if (doPrint) {
                    try {
                        /* Lancement de l'impression */
                        job.print();
                    } catch (PrinterException e1) {
                        System.out.println(e1.getMessage());
                    }
                }
            }
        });
    }

    public void setButtonFicheSoin() {
        ficheSoin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au conteneur correspondant au nom fourni en paramètre
                cl.show(affichage, listContent[4]);
                scrollPane1.setEditable(false);
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
                    comboBox2.setVisible(true);
                    label21.setVisible(true);
                    label22.setVisible(true);
                    coef.setVisible(true);
                    label23.setVisible(true);
                    scrollPane1.setVisible(true);
                    textArea1.setVisible(true);
                    button1New.setVisible(true);
                    buttonImp.setVisible(true);
                    labelajoutActe.setVisible(true);
                    buttonAjoutActe.setVisible(true);
                    actemedical.setSelected(false);
                    fichierMedical.setSelected(false);
                    registrePatient.setSelected(false);
                    registreMedecin.setSelected(false);
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
                    buttonImp.setVisible(false);
                    labelajoutActe.setVisible(false);
                    buttonAjoutActe.setVisible(false);
                    comboBox2.setVisible(false);
                    actemedical.setSelected(false);
                    fichierMedical.setSelected(false);
                    registrePatient.setSelected(false);
                    registreMedecin.setSelected(false);
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
        haut.add(picLabel, BorderLayout.CENTER);
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
                    actemedical.setSelected(false);
                    fichierMedical.setSelected(false);
                    ficheSoin.setSelected(false);
                    registreMedecin.setSelected(false);
                    adresse.setVisible(true);
                    textAdresse.setVisible(true);
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
                    actemedical.setSelected(false);
                    fichierMedical.setSelected(false);
                    ficheSoin.setSelected(false);
                    registreMedecin.setSelected(false);
                    adresse.setVisible(false);
                    textAdresse.setVisible(false);
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

        // adresse
        adresse.setText("Adresse:");
        adresse.setAlignmentX(0.5F);
        adresse.setBorder(new EtchedBorder());
        panelRegistrePatient.add(adresse);
        adresse.setBounds(140, 280, 55, adresse.getPreferredSize().height);

        // TextAdresse

        panelRegistrePatient.add(textAdresse);
        textAdresse.setBounds(210, 275, 250, textAdresse.getPreferredSize().height);

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
        rechercheM.setText("Recherche: entrez le nom et le prenom");
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
        validerRechercheM.setText(Constants.VALIDER.getValue());
        validerRechercheM.setBackground(new Color(51, 153, 255));
        panelRegistreMedecin.add(validerRechercheM);
        validerRechercheM.setBounds(445, 150, 72, 24);

        //---- ouM ----

        panelRegistreMedecin.add(separator1M);

        computePreferedSize(panelRegistreMedecin);
    }

    public void setRechercherMedecin() {
        validerRechercheM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                /*Map<String, String> xmlToSave = new LinkedHashMap<String, String>();
                xmlToSave.put(null, "medecin");
                xmlToSave.put("nom", textField1.getText());
                xmlToSave.put("prenom", textField2.getText());
                xmlToSave.put("specialite", textField3.getText());
                xmlToSave.put("numeroTelephone", textField4.getText());*/

                LectureXML test1 = new LectureXML("listeMedecin.xml");
                ListeMedecin listeMedecin = test1.getListeMedecin();
                System.out.println(listeMedecin.rechercherMedecin(textNomM.getText(), textPrénomM.getText()));
                if (textPrenom.getText() != null && textNom.getText() != null) {
                    textSpecialite.setText(listeMedecin.rechercherMedecin(textNomM.getText(), textPrénomM.getText()).getSpecialite());
                    textTelephone.setText(listeMedecin.rechercherMedecin(textNomM.getText(), textPrénomM.getText()).getNumeroTel());
                }
            }
        });
    }

    public void setButtonRegistreMedecin() {
        registreMedecin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au conteneur correspondant au nom fourni en paramètre
                cl.show(affichage, listContent[2]);
                //textField4.setEditable(false);
                //textField3.setEditable(false);
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
                    actemedical.setSelected(false);
                    fichierMedical.setSelected(false);
                    ficheSoin.setSelected(false);
                    registrePatient.setSelected(false);

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
                    actemedical.setSelected(false);
                    fichierMedical.setSelected(false);
                    ficheSoin.setSelected(false);
                    registrePatient.setSelected(false);
                }
            }
        });


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
        panelActe.setBorder(new BevelBorder(BevelBorder.LOWERED));


        panelActe.setLayout(null);

        //---- rAM ----
        rAM.setText("Rechercher d'un acte m2dical");
        rAM.setFont(new Font("Arimo", Font.BOLD, 22));
        rAM.setForeground(new Color(51, 0, 153));
        panelActe.add(rAM);
        rAM.setBounds(150, 35, 350, 30);
        rAM.setHorizontalAlignment(JLabel.CENTER);
        rAM.setVerticalAlignment(JLabel.CENTER);

        //---- acte ----
        acte.setText("ACTE : entrez le coefficient et le code ");
        acte.setForeground(new Color(0, 102, 102));
        acte.setFont(new Font(Constants.COPPERPLATE.getValue(), Font.BOLD, 14));
        panelActe.add(acte);
        acte.setBounds(70, 95, 50, acte.getPreferredSize().height);

        //---- type ----
        type.setText(" Coefficient :");
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
        cout.setText(" Co\u00fbt :");
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
                    fichierMedical.setSelected(false);
                    ficheSoin.setSelected(false);
                    registrePatient.setSelected(false);
                    registreMedecin.setSelected(false);

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
                    fichierMedical.setSelected(false);
                    ficheSoin.setSelected(false);
                    registrePatient.setSelected(false);
                    registreMedecin.setSelected(false);
                }
            }
        });

    }


    public void setAjouterFicheSoin() {
        final List<Acte> actes = new ArrayList<Acte>();
        buttonAjoutActe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                System.out.println(comboBox1.getItemAt(comboBox1.getSelectedIndex()));
                String s = comboBox1.getItemAt(comboBox1.getSelectedIndex()).toString();
                Acte a = new Acte(Code.valueOf(s), Integer.parseInt(coef.getText()));
                actes.add(a);
                scrollPane1.append(a.toString());

                button1New.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        Date date = new Date(Integer.parseInt(jj.getText()), Integer.parseInt(mm.getText()), Integer.parseInt(aaaa.getText()));

                        //retrouver info Medecin
                        LectureXML test = new LectureXML("listeMedecin.xml");
                        ListeMedecin listeMedecin = test.getListeMedecin();
                        System.out.println(listeMedecin.rechercherMedecin(nomMed.getText(), prenomMed.getText()));
                        String specialite = listeMedecin.rechercherMedecin(nomMed.getText(), prenomMed.getText()).getSpecialite();
                        String numTel = listeMedecin.rechercherMedecin(nomMed.getText(), prenomMed.getText()).getNumeroTel();
                        String mdp = listeMedecin.rechercherMedecin(nomMed.getText(), prenomMed.getText()).getMdp();
                        Medecin medecin = new Medecin(nomMed.getText(), prenomMed.getText(), specialite, numTel, mdp);

                        //retrouver info patient pour completer
                        LectureXML test1 = new LectureXML("listePatient.xml");
                        ListePatient listePatient = test1.getListePatient();
                        System.out.println(listePatient.rechercherViaNomPrenom(nomPa.getText(), prenomPa.getText()));
                        String adresse = listePatient.rechercherViaNomPrenom(nomPa.getText(), prenomPa.getText()).getAdresse();
                        Patient patient = new Patient(nomPa.getText(), prenomPa.getText(), adresse, numSecu.getText(), new Date(Integer.parseInt(jj.getText()), Integer.parseInt(mm.getText()), Integer.parseInt(aaaa.getText())));

                        //ecrire dans dossiers.xml
                        EcrireXML.saveFicheDeSoinToXML("src/donnees/dossiers2.xml", date, medecin, patient, actes);

                        JOptionPane.showMessageDialog(null, "Création de fiche de soins", "Réussis", JOptionPane.INFORMATION_MESSAGE);

                        jj.setText(null);
                        mm.setText(null);
                        aaaa.setText(null);
                        nomMed.setText(null);
                        nomPa.setText(null);
                        prenomMed.setText(null);
                        prenomPa.setText(null);
                        numSecu.setText(null);
                        coef.setText(null);
                        scrollPane1.setText(null);
                        actes.clear();

                    }
                });

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

    private void setSideButton(JToggleButton button) {
        haut.add(button, BorderLayout.CENTER);
        button.setFont(police);
        button.setPreferredSize(new Dimension(230, 50));
    }
}
