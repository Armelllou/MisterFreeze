package princetonPlainsboro;

import affichage.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Deconnexion extends JFrame {

    JPanel pageDeco = new JPanel();
    JLabel deco;
    JToggleButton retourAccueil;


    Deconnexion() {
        //JLabel
        deco = new JLabel("Vous êtes deconnecté");
        Font police = new Font("Tahoma", Font.BOLD, 30);
        deco.setFont(police);
        deco.setHorizontalAlignment(JLabel.CENTER);
        deco.setVerticalAlignment(JLabel.CENTER);

        //Button accueil
        retourAccueil = new JToggleButton("Accueil");
        pageDeco.setLayout(new BorderLayout());
        pageDeco.add(deco, BorderLayout.CENTER);
        pageDeco.add(retourAccueil, BorderLayout.SOUTH);
        this.add(pageDeco);
        retourAccueil.setMaximumSize(new Dimension(100, 150));

        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);


        //retour page accueil
        retourAccueil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                new Login().showLogin();
                close();
            }
        });
    }

    private void close(){
        this.dispose();
    }
}
