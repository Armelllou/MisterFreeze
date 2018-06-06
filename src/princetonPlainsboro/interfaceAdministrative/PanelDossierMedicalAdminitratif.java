package princetonPlainsboro.interfaceAdministrative;

import princetonPlainsboro.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDossierMedicalAdminitratif {
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
    private JToggleButton deconnexion;
    private JToggleButton fichierMedical;
    private JLabel registreM;
    private JScrollPane sp;
    private JTextArea dossierMed;

    private LectureXML test;
    private DossierMedical dm1;
    private JPanel panelRegistreM;


    public PanelDossierMedicalAdminitratif(JPanel panelDossierMedical) {

        panelDossierMedical.setLayout(new BorderLayout());

        hautRegistreM.setLayout(new BorderLayout());
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
        test = new LectureXML("dossiers.xml");
        dm1 = test.getDossier();
        dossierMed = new JTextArea(dm1.toStringDM());
        sp = new JScrollPane(dossierMed);
        panelDossierMedical.add(sp, BorderLayout.CENTER);
        panelDossierMedical.add(hautRegistreM, BorderLayout.SOUTH);

        sp.setVisible(false);

        //titre registre Medical
        registreM = new JLabel("Registre Medical");
        panelRegistreM.add(registreM, BorderLayout.NORTH);
        registreM.setVisible(false);
        Font police1 = new Font(Constants.TAHOMA.getValue(), Font.BOLD, 20);
        registreM.setFont(police1);
        registreM.setHorizontalAlignment(JLabel.CENTER);
        registreM.setVerticalAlignment(JLabel.CENTER);


        //Fonctions
        setAllButtonRegistreMedical();

    }

    public void setAllButtonRegistreMedical(){

        dossierMedical.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                dossierMed.setForeground(Color.BLACK);
                dossierMed.setText(dm1.toStringDM());

            }
        });

        ficheDUnPatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                LectureXML test = new LectureXML("dossiers2.xml");
                DossierMedical dm1 = test.getDossier();
                System.out.println(dm1.rechercherfichesDUnPatient(textFiche.getText()));
                if (dm1.rechercherfichesDUnPatient(textFiche.getText()) == null) {
                    dossierMed.setForeground(Color.GRAY);
                    dossierMed.setText("Pas de correspondance...");
                } else {
                    dossierMed.setForeground(Color.BLACK);
                    System.out.println(dm1.rechercherfichesDUnPatient(textFiche.getText()).toString());
                    dossierMed.setText(dm1.rechercherfichesDUnPatient(textFiche.getText()).toString());
                }

            }
        });

        entreDeuxDates.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Via cette instruction, on passe au prochain conteneur de la pile
                dossierMed.setForeground(Color.BLACK);
                Date d1= new Date(Integer.parseInt(date1.getText()),Integer.parseInt(date2.getText()),Integer.parseInt(date3.getText()));
                Date d2= new Date(Integer.parseInt(date4.getText()),Integer.parseInt(date5.getText()),Integer.parseInt(date6.getText()));

                dossierMed.setText(dm1.trierEntreDeuxDates(d1,d2, new ComparaisonFichesCouts()).toString());

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
