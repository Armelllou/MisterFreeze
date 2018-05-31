package princetonPlainsboro;

import affichage.Acceuil;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class InterfaceSecretaireAdministratif extends JFrame {
    CardLayout cl = new CardLayout();
    JPanel affichage = new JPanel();

    //Liste des noms de nos conteneurs pour la supperposition des JPanels
    String[] listContent = {"REGISTRE_PATIENT", "REGISTRE_MEDECIN", "FICHIER_MEDICAL", "CREER_UNE_FICHE", "ACTE_MEDICAL", "DECONNEXION"};

    private JPanel menuderoulant = new JPanel();
    private JPanel haut = new JPanel();
    private JPanel bas = new JPanel();
    private JTextArea dossierMed;
    //JLabel image ;//= new JLabel( new ImageIcon( "princetonPlainsboro/images.png"));
    private BufferedImage image;
    JLabel picLabel;


    public InterfaceSecretaireAdministratif() {
        this.setSize(500, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);


        haut.setLayout(new GridLayout(9, 1));
        //bas.setLayout(new BorderLayout());
        menuderoulant.add(haut, BorderLayout.CENTER);
        menuderoulant.add(bas, BorderLayout.SOUTH);

        //On cree trois conteneurs de couleurs differentes
        JPanel panelRegistrePatient = new JPanel();
        panelRegistrePatient.setBackground(Color.pink);
        JPanel panelRegistreMedecin = new JPanel();
        panelRegistreMedecin.setBackground(Color.red);
        JPanel panelRegistreM = new JPanel();
        JPanel panelDeconnexion = new JPanel();
        JPanel panelActe = new JPanel();
        JPanel panelFicheSoin = new JPanel();

        //creation des boutons
        JToggleButton actemedical = new JToggleButton("Acte Medical");
        haut.add(actemedical, BorderLayout.CENTER);
        Font police = new Font("Tahoma", Font.BOLD, 16);
        actemedical.setFont(police);
        actemedical.setPreferredSize(new Dimension(230, 50));

        JToggleButton fichierMedical = new JToggleButton("Fichier Medical");
        haut.add(fichierMedical, BorderLayout.CENTER);
        fichierMedical.setFont(police);
        fichierMedical.setPreferredSize(new Dimension(230, 50));

        JToggleButton ficheSoin = new JToggleButton("Crée une fiche de soin");
        haut.add(ficheSoin, BorderLayout.CENTER);
        ficheSoin.setFont(police);
        ficheSoin.setPreferredSize(new Dimension(230, 50));

        JToggleButton registrePatient = new JToggleButton("Registre Patient");
        haut.add(registrePatient, BorderLayout.CENTER);
        registrePatient.setFont(police);
        registrePatient.setPreferredSize(new Dimension(230, 50));

        JToggleButton registreMedecin = new JToggleButton("Registre Medecin");
        haut.add(registreMedecin, BorderLayout.CENTER);
        registreMedecin.setFont(police);
        registreMedecin.setPreferredSize(new Dimension(230, 50));

        JToggleButton deconnexion = new JToggleButton("Deconnecter");
        haut.add(deconnexion, BorderLayout.CENTER);
        deconnexion.setFont(police);

        ImagePanel();

        //image
        //JLabel image = new JLabel( new ImageIcon( "princetonPlainsboro/images.png"));



        panelRegistreM.setLayout(new BorderLayout());

        //recupère Les fiches de soins du XML
        LectureXML test = new LectureXML("dossiers.xml");
        DossierMedical dm1 = test.getDossier();
        dossierMed = new JTextArea(dm1.toStringDM());
        panelRegistreM.add(dossierMed, BorderLayout.CENTER);
        dossierMed.setVisible(false);

        //titre registre Medical
        JLabel registreM = new JLabel("Registre Medical");
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

        //Definition de l'action du bouton registrePatient
        registrePatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au prochain conteneur de la pile
                cl.show(affichage, listContent[1]);
                if (registrePatient.isSelected()) {

                } else {

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

    }

    public void setpanelDeconnexion(JPanel panelDeconnexion) {
        JLabel deco;
        JButton retourAccueil;

        deco = new JLabel("Vous êtes deconnecté");
        Font police = new Font("Tahoma", Font.BOLD, 30);
        deco.setFont(police);
        deco.setHorizontalAlignment(JLabel.CENTER);
        deco.setVerticalAlignment(JLabel.CENTER);

        //Button accueil
        retourAccueil = new JButton("Accueil");
        panelDeconnexion.setLayout(new GridLayout(2, 1));
        panelDeconnexion.add(deco, BorderLayout.NORTH);
        panelDeconnexion.add(retourAccueil, BorderLayout.CENTER);
        this.add(panelDeconnexion);
        retourAccueil.setMaximumSize(new Dimension(20, 50));

        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        //retour page accueil --> marche pas
        retourAccueil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Acceuil accu1 = new Acceuil();
                accu1.setMinimumSize(new Dimension(700, 700));

            }
        });
    }

    public void ImagePanel() {
        try {
            File myPicture = new File("image.jpg");
            //picLabel = new JLabel(new ImageIcon("princetonPlainsboro/images.png"));
//picLabel.setVisible(true);
            BufferedImage image = ImageIO.read(myPicture);
            System.out.println(image.getHeight());
            System.out.println(image.getHeight());

        } catch (Exception ex) {
            System.out.println("error in image");
        }
        //haut.add(picLabel);
    }

}


