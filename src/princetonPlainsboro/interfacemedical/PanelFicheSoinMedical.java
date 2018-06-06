package princetonPlainsboro.interfacemedical;

import princetonPlainsboro.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.List;

public class PanelFicheSoinMedical {

    private JTextField jj;
    private JTextField mm;
    private JTextField aaaa;
    private JTextField nomMed;
    private JTextField nomPa;
    private JTextField prenomMed;
    private JTextField prenomPa;
    private JTextField numSecu;
    private JComboBox comboBox1;
    private JTextField coef;
    private JTextArea scrollPane1;
    private JButton button1New;
    private JButton buttonImp;
    private JButton buttonAjoutActe;
    private JComboBox comboBox2;
    private boolean ficheAjouté;

    PanelFicheSoinMedical(JPanel panelFicheSoin) {
        JLabel label11 = new JLabel();
        JLabel label12 = new JLabel();
        jj = new JTextField();
        mm = new JTextField();
        aaaa = new JTextField();
        JLabel label13 = new JLabel();
        JLabel label14 = new JLabel();
        nomMed = new JTextField();
        nomPa = new JTextField();
        JLabel label15 = new JLabel();
        JLabel label16 = new JLabel();
        JLabel label17 = new JLabel();
        JLabel label18 = new JLabel();
        prenomMed = new JTextField();
        prenomPa = new JTextField();
        JLabel label19 = new JLabel();
        numSecu = new JTextField();
        JLabel label20 = new JLabel();
        comboBox1 = new JComboBox();
        comboBox2 = new JComboBox();
        JLabel label21 = new JLabel();
        JLabel label22 = new JLabel();
        coef = new JTextField();
        JLabel label23 = new JLabel();
        scrollPane1 = new JTextArea();
        JTextArea textArea1 = new JTextArea();
        button1New = new JButton();
        buttonImp = new JButton();
        JLabel labelajoutActe = new JLabel();
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
                                            Acte a = new Acte(Code.valueOf(s), Integer.parseInt(coef.getText()), comboBox2.getItemAt(comboBox2.getSelectedIndex()).toString());
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

            PanelCompute.computePreferedSize(panelFicheSoin);
            setAjouterFicheSoin();
            setButtonImprimer();
        }
    }

    public void setAjouterFicheSoin() {
        final List<Acte> actes = new ArrayList<Acte>();
        buttonAjoutActe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println(comboBox1.getItemAt(comboBox1.getSelectedIndex()));
                String s = comboBox1.getItemAt(comboBox1.getSelectedIndex()).toString();
                Acte a = new Acte(Code.valueOf(s), Integer.parseInt(coef.getText()), comboBox2.getItemAt(comboBox2.getSelectedIndex()).toString());
                actes.add(a);
                scrollPane1.append(a.toString() + "\n");

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
                        EcrireXML.saveFicheDeSoinToXML("src/donnees/dossiers.xml", date, medecin, patient, actes);

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
                        ficheAjouté = true;

                    }
                });

            }
        });


    }

    public void setButtonImprimer() {
        buttonImp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if(ficheAjouté == true){
                PrinterJob job = PrinterJob.getPrinterJob();
                /* On donne le contenu à imprimer au job */

                        final LectureXML test = new LectureXML("dossiers.xml");
        final DossierMedical dm = test.getDossier(); 
        job.setPrintable(dm.getListe().get(dm.getListe().size()-1));
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
            }}
        });
    }
}
