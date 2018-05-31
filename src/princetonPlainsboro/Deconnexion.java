package princetonPlainsboro;

import affichage.Acceuil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Deconnexion extends JFrame {

    JPanel pageDeco = new JPanel();
    JLabel deco;
    JButton retourAccueil;

    Deconnexion() {
        //JLabel
        deco = new JLabel("Vous êtes deconnecté");
        Font police = new Font("Tahoma", Font.BOLD, 30);
        deco.setFont(police);
        deco.setHorizontalAlignment(JLabel.CENTER);
        deco.setVerticalAlignment(JLabel.CENTER);

        //Button accueil
        retourAccueil = new JButton("Accueil");
        pageDeco.setLayout(new GridLayout(2, 1));
        pageDeco.add(deco, BorderLayout.NORTH);
        pageDeco.add(retourAccueil, BorderLayout.CENTER);
        this.add(pageDeco);
        retourAccueil.setMaximumSize(new Dimension(20, 50));

        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        //retour page accueil
        retourAccueil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Acceuil accu1 = new Acceuil();
                accu1.setMinimumSize(new Dimension(700, 700));

            }
        });
    }


}
