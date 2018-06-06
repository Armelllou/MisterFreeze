package princetonPlainsboro.interfaceAdministrative;

import princetonPlainsboro.*;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private JTable table;

    private LectureXML test;
    private DossierMedical dm1;

    public PanelDossierMedicalAdminitratif(JPanel panelDossierMedical) {

        panelDossierMedical.setLayout(new BorderLayout());
        hautRegistreM = new JPanel();
        hautRegistreM.setLayout(new FlowLayout());
        hautRegistreM.setPreferredSize(new Dimension(500, 110));
        table = new JTable();


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
                    Set<Patient> patients = new HashSet<Patient>();
                    Set<FicheDeSoins> fiche = new HashSet<FicheDeSoins>();
                    StringBuilder builder = new StringBuilder("Dossier du patient : " + patients + "\n");
                    for (FicheDeSoins fiche1 : fiches) {
                        patients.add(fiche1.getPatient());
                    }
                    for (Patient patient : patients) {
                        builder.append(patient + "\n");
                    }
                    for (FicheDeSoins fiche1 : fiches) {
                        fiche.add(fiche1);
                    }
                    for (FicheDeSoins fiche1 : fiches) {
                        builder.append("\n" + fiche1);
                    }

                    dossierMed.setText(builder.toString());
                }
            }
        });

        imprimer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String defaultPrinter = PrintServiceLookup.lookupDefaultPrintService().getName();
                System.out.println("Default printer: " + defaultPrinter);
                PrintService service = PrintServiceLookup.lookupDefaultPrintService();

                // prints the famous hello world! plus a form feed
                InputStream is = new ByteArrayInputStream(dossierMed.getText().getBytes());

                PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
                pras.add(new Copies(1));

                DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
                Doc doc = new SimpleDoc(is, flavor, null);
                DocPrintJob job = service.createPrintJob();

                PrintJobWatcher pjw = new PrintJobWatcher(job);
                try {
                    job.print(doc, pras);
                } catch (PrintException e) {
                    e.printStackTrace();
                }
                pjw.waitForDone();
                //is.close();
            }

            class PrintJobWatcher {
                boolean done = false;

                PrintJobWatcher(DocPrintJob job) {
                    job.addPrintJobListener(new PrintJobAdapter() {
                        public void printJobCanceled(PrintJobEvent pje) {
                            allDone();
                        }

                        public void printJobCompleted(PrintJobEvent pje) {
                            allDone();
                        }

                        public void printJobFailed(PrintJobEvent pje) {
                            allDone();
                        }

                        public void printJobNoMoreEvents(PrintJobEvent pje) {
                            allDone();
                        }

                        void allDone() {
                            synchronized (PrintJobWatcher.this) {
                                done = true;
                                System.out.println("Printing done ...");
                                PrintJobWatcher.this.notify();
                            }
                        }
                    });
                }

                public synchronized void waitForDone() {
                    try {
                        while (!done) {
                            wait();
                        }
                    } catch (InterruptedException e) {
                    }
                }
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
