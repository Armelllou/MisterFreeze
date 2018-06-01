package princetonPlainsboro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;


public class InterfaceAdministration extends JFrame implements ComponentListener {

    private JPanel menuSecretaire = new JPanel();
    private JPanel affichageSecretaire = new JPanel();
    private JPanel mainPanelSecretaire = new JPanel();

    public InterfaceAdministration() {
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        mainPanelSecretaire.setLayout(new BorderLayout());

        mainPanelSecretaire.add(menuSecretaire, BorderLayout.WEST);
        mainPanelSecretaire.add(affichageSecretaire, BorderLayout.EAST);

        this.add(mainPanelSecretaire);

        setLeftPanel(menuSecretaire);
        setCenterPanel(affichageSecretaire);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        //this.setPreferredSize(this.getSize());
        //this.setMinimumSize(this.getSize());
        this.setVisible(true);
        this.addComponentListener(this);
    }

    public void setLeftPanel(JPanel menuSecretaire) {
        menuSecretaire.setLayout(new BorderLayout());
        //menuderoulant.setMaximumSize(new Dimension());
        JPanel haut = new JPanel();
        JPanel bas = new JPanel();
        haut.setLayout(new GridLayout(2, 1));

        JButton accesPatient = new JButton("AccesPatient");
        JButton deconnexionSecretaire = new JButton("Deconnexion");
        accesPatient.setPreferredSize(new Dimension(250, 80));

        menuSecretaire.add(haut, BorderLayout.NORTH);
        menuSecretaire.add(bas, BorderLayout.SOUTH);

        haut.add(accesPatient, BorderLayout.CENTER);
        haut.add(deconnexionSecretaire, BorderLayout.CENTER);
    }

    public void setCenterPanel(JPanel affichageSecretaire) {
        affichageSecretaire.setLayout(new BorderLayout());
        affichageSecretaire.setMaximumSize(new Dimension(600, 700));
    }

    public void componentResized(ComponentEvent e) {
        mainPanelSecretaire.setSize(new Dimension((int) e.getComponent().getSize().getWidth(), 1000));
    }

    public void componentMoved(ComponentEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void componentShown(ComponentEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void componentHidden(ComponentEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
