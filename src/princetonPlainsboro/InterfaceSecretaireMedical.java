/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class InterfaceSecretaireMedical extends JFrame implements ComponentListener {

    private JPanel menuderoulant = new JPanel();
    private JPanel affichage = new JPanel();
    private JPanel mainPanel = new JPanel();

    public InterfaceSecretaireMedical() {
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        mainPanel.setLayout(new BorderLayout());

        mainPanel.add(menuderoulant, BorderLayout.WEST);
        mainPanel.add(affichage, BorderLayout.EAST);

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
        //menuderoulant.setMaximumSize(new Dimension());
        JPanel haut = new JPanel();
        JPanel bas = new JPanel();
        haut.setLayout(new GridLayout(4, 1));

        //JLabel 
        JButton registrePatient = new JButton("Registre Patient");
        Font police = new Font("Tahoma", Font.BOLD, 16);

        registrePatient.setFont(police);
        
        JButton deconnexion = new JButton("Deconnexion");
        deconnexion.setFont(police);
        JButton registreMedecin = new JButton("Registre Medecin");
        registreMedecin.setFont(police);

        registrePatient.setPreferredSize(new Dimension(230, 50));
        JButton fichierMedical = new JButton("Fichier Medical");
        fichierMedical.setFont(police);

        JButton actemedical = new JButton("Acte Medical");
        actemedical.setFont(police);

        menuderoulant.add(haut, BorderLayout.NORTH);
        menuderoulant.add(bas, BorderLayout.SOUTH);


        haut.add(registrePatient, BorderLayout.CENTER);
        bas.add(deconnexion, BorderLayout.CENTER);
        haut.add(registreMedecin, BorderLayout.CENTER);
        haut.add(fichierMedical, BorderLayout.CENTER);
        haut.add(actemedical, BorderLayout.CENTER);

        
    }

    public void setCenterPanel(JPanel affichage) {
        affichage.setLayout(new BorderLayout());
        affichage.setMaximumSize(new Dimension(600, 700));



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
