package princetonPlainsboro.interfacemedical;

import princetonPlainsboro.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PanelDossierMedical {


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
    private JTable table;

    private LectureXML test;
    private DossierMedical dm1;

    public PanelDossierMedical(JPanel panelDossierMedical) {

        panelDossierMedical.setLayout(new BorderLayout());
        hautRegistreM = new JPanel();
        hautRegistreM.setLayout(new FlowLayout());
        hautRegistreM.setPreferredSize(new Dimension(500, 110));
        table = new JTable();


        listeMedecin = new JButton("Liste des médecins");
        listePatient = new JButton("Liste des patients");


        listeMedecin.setPreferredSize(new Dimension(160, 25));
        listePatient.setPreferredSize(new Dimension(160, 25));


        hautRegistreM.add(listeMedecin);
        hautRegistreM.add(listePatient);


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


    }
}


