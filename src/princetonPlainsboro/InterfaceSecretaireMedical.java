/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class InterfaceSecretaireMedical extends JFrame implements ComponentListener {

    private JPanel menuderoulant = new JPanel();
    private JPanel affichage = new JPanel();
    private JPanel mainPanel = new JPanel();
    private JToggleButton fichierMedical;
    private JPanel haut;
    private JPanel bas;
    private JButton registrePatient;
    private JButton deconnexion;
    private JButton registreMedecin;
    private JButton actemedical;
    private JButton ficheSoin;
    private JTextArea dossierMed;

    public InterfaceSecretaireMedical() {
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(menuderoulant, BorderLayout.WEST);
        mainPanel.add(affichage, BorderLayout.CENTER);

        this.add(mainPanel);

        setLeftPanel(menuderoulant);
        setCenterPanel(affichage);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setPreferredSize(this.getSize());
        this.setMinimumSize(this.getSize());
        this.setVisible(true);
        this.addComponentListener(this);
    }

    public void setLeftPanel(JPanel menuderoulant) {
        menuderoulant.setLayout(new BorderLayout());
        haut = new JPanel();
        bas = new JPanel();
        haut.setLayout(new GridLayout(5, 1));
        menuderoulant.add(haut, BorderLayout.NORTH);
        menuderoulant.add(bas, BorderLayout.SOUTH);

        //RegitrePatient
        registrePatient = new JButton("Registre Patient");
        Font police = new Font("Tahoma", Font.BOLD, 16);
        registrePatient.setFont(police);
        registrePatient.setPreferredSize(new Dimension(230, 50));
        haut.add(registrePatient, BorderLayout.CENTER);

        //Deconnexion
        deconnexion = new JButton("Deconnexion");
        deconnexion.setFont(police);
        bas.add(deconnexion, BorderLayout.CENTER);

        //registreMedecin
        registreMedecin = new JButton("Registre Medecin");
        registreMedecin.setFont(police);
        haut.add(registreMedecin, BorderLayout.CENTER);

        //fichierMedical
        fichierMedical = new JToggleButton("Fichier Medical");
        fichierMedical.setFont(police);
        haut.add(fichierMedical, BorderLayout.CENTER);



        //bouton fiche de soin
        ficheSoin = new JButton("Créer une fiche de soin");
        ficheSoin.setFont(police);
        haut.add(ficheSoin, BorderLayout.CENTER);


        //acteMedical
        actemedical = new JButton("Acte Medical");
        actemedical.setFont(police);
        haut.add(actemedical, BorderLayout.CENTER);

        //page deconnexion
        deconnexion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    Deconnexion deco1 = new Deconnexion();
                    deco1.setMinimumSize(new Dimension (700, 700));
                    dispose();
                }
        });


    }


    public void setCenterPanel(JPanel affichage) {
        affichage.setLayout(new BorderLayout());
        affichage.setMaximumSize(new Dimension(600, 700));

         LectureXML test = new LectureXML("dossiers.xml");
         DossierMedical dm1 = test.getDossier();
        dossierMed = new JTextArea(dm1.toStringDM());
        affichage.add(dossierMed, BorderLayout.CENTER);
        dossierMed.setVisible(false);

        //ouvrir page fichier medical
        fichierMedical.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (fichierMedical.isSelected()) {
                    dossierMed.setVisible(true);
                } else {
                    dossierMed.setVisible(false);
                }


            }
        });

        //page
        deconnexion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Deconnexion deco1 = new Deconnexion();
                deco1.setMinimumSize(new Dimension (700, 700));
                dispose();
            }
        });

    }

    @Override
    public void componentResized(ComponentEvent e) {

        mainPanel.setSize(new Dimension((int) e.getComponent().getSize().getWidth(), 1000));

    }

    @Override
    public void componentMoved(ComponentEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentShown(ComponentEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}