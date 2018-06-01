package princetonPlainsboro;

import javax.swing.*;
import java.awt.*;

public class registreMedecin {
    private JTextField textField1;
    private JPanel panel1;
    private JTextField textField2;
    private JButton validerButton;
    private JTextField textField3;


        public static void main (String[]args){
            JFrame frame = new JFrame("registreMedecin");
            frame.setContentPane(new registreMedecin().panel1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }

        public void appelRegistreMedecin(){
            JFrame frame = new JFrame("registreMedecin");
            frame.setContentPane(new registreMedecin().panel1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }


}
