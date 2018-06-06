package princetonPlainsboro.interfaceAdministrative;

import princetonPlainsboro.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelDossierMedicalAdminitratif {
    private JButton trieDate;
    private JButton listeMedecin;
    private JButton trieCout;
    private JButton listePatient;
    private JButton imprimer;
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
    private JToggleButton deconnexion;
    private JToggleButton fichierMedical;
    private JLabel registreM;
    private JScrollPane sp;
    private JTextArea dossierMed;

    private LectureXML test;
    private DossierMedical dm1;

    public PanelDossierMedicalAdminitratif(JPanel panelDossierMedical) {

        panelDossierMedical.setLayout(new BorderLayout());
        hautRegistreM = new JPanel();
        hautRegistreM.setLayout(new FlowLayout());
        hautRegistreM.setPreferredSize(new Dimension(500, 110));


        dossierMedical = new JButton("Dossier Médical");
        listeMedecin = new JButton("Liste des médecins");
        listePatient = new JButton("Liste des patients");
        trieDate = new JButton("Trier les fiches par dates");
        trieCout = new JButton("Trier les fiches par cout");
        ficheDUnPatient = new JButton("Afficher le dossier d'un patient via numéro Securite social");
        imprimer = new JButton("Imprimer");
        textFiche = new JTextField();

        dossierMedical.setPreferredSize(new Dimension(160, 25));
        listeMedecin.setPreferredSize(new Dimension(160, 25));
        listePatient.setPreferredSize(new Dimension(160, 25));
        trieDate.setPreferredSize(new Dimension(180, 25));
        trieCout.setPreferredSize(new Dimension(160, 25));
        textFiche.setPreferredSize(new Dimension(60, 25));
        imprimer.setPreferredSize(new Dimension(100, 25));
        ficheDUnPatient.setPreferredSize(new Dimension(400, 25));


        hautRegistreM.add(dossierMedical);
        hautRegistreM.add(listeMedecin);
        hautRegistreM.add(listePatient);
        hautRegistreM.add(trieDate);
        hautRegistreM.add(trieCout);
        hautRegistreM.add(ficheDUnPatient);
        hautRegistreM.add(textFiche);
        hautRegistreM.add(imprimer);


        //recupère Les fiches de soins du XML
        test = new LectureXML("dossiers.xml");
        dm1 = test.getDossier();
        dossierMed = new JTextArea(dm1.toStringDM());
        sp = new JScrollPane(dossierMed);
        panelDossierMedical.add(sp, BorderLayout.CENTER);
        panelDossierMedical.add(hautRegistreM, BorderLayout.SOUTH);

        //titre registre Medical
        registreM = new JLabel("Registre Medical");
        panelDossierMedical.add(registreM, BorderLayout.NORTH);
        Font police1 = new Font(Constants.TAHOMA.getValue(), Font.BOLD, 20);
        registreM.setFont(police1);
        registreM.setHorizontalAlignment(JLabel.CENTER);
        registreM.setVerticalAlignment(JLabel.CENTER);

        //Fonctions
        setAllButtonRegistreMedical();

    }

    public void setAllButtonRegistreMedical() {

        dossierMedical.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                dossierMed.setForeground(Color.BLACK);
                dossierMed.setText(dm1.toStringDM());

            }
        });

        ficheDUnPatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                LectureXML test = new LectureXML("dossiers.xml");
                DossierMedical dm = test.getDossier();
                List<FicheDeSoins> fiches = dm.rechercherfichesDUnPatient(textFiche.getText());
                System.out.println(dm.rechercherPatientViaSecu(textFiche.getText()));
                System.out.println(textFiche.getText());
                if (fiches.isEmpty()) {
                    dossierMed.setText("Pas de correspondance...");
                } else {
                    StringBuilder builder = new StringBuilder("Fiches : \n");
                    for (FicheDeSoins fiche : fiches) {
                        builder.append(fiche);
                    }
                    dossierMed.setText(builder.toString());
                }
            }
        });

        imprimer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au prochain conteneur de la pile


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
    }


}
