package princetonPlainsboro.interfaceAdministrative;

import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;
import princetonPlainsboro.*;
import princetonPlainsboro.interfacemedical.PanelCompute;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelRegistreMedecinAdministration {

    private JTextField textNomM;
    private JTextField textPrenomM;
    private JTextField textSpecialite;
    private JTextField textPrenom;
    private JTextField textNom;

    private JTextField textTelephone;
    private JButton validerRechercheM;

    private JTextField  textNomM2 ;
    private JTextField textPrenomM2 ;
    private JTextField textSpecialite2 ;
    private JTextField  textTelephone2;
   private JButton validerRechercheM2 ;
   private JTextField  textmdpMedecin;

    public PanelRegistreMedecinAdministration(JPanel panelRegistreMedecin) {

        panelRegistreMedecin.setLayout(new BorderLayout());
         JLabel rM = new JLabel();
        JLabel rechercheM = new JLabel();
        JLabel  nomM = new JLabel();
        JLabel  prenomM = new JLabel();
       textNomM = new JTextField();
         textPrenomM = new JTextField();
      JLabel  specialite = new JLabel();
       JLabel telephone = new JLabel();
         textSpecialite = new JTextField();
       textTelephone = new JTextField();
        validerRechercheM = new JButton();
       JLabel ouM = new JLabel();
       JSeparator separator1M = new JSeparator();
        JLabel ajoutM = new JLabel();
        JLabel  nomM2 = new JLabel();
        JLabel  prenomM2 = new JLabel();
        JLabel  specialite2 = new JLabel();
        JLabel  telephone2 = new JLabel();
        textNomM2 = new JTextField();
        textPrenomM2 = new JTextField();
        textSpecialite2 = new JTextField();
        textTelephone2 = new JTextField();
        validerRechercheM2 = new JButton();
       JLabel mdpMedecin = new JLabel();
        textmdpMedecin = new JTextField();

        //======== this ========


        panelRegistreMedecin.setLayout(null);

        //---- rM ----
        rM.setText("Registre Medecins");
        rM.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
        rM.setForeground(Color.magenta);
        panelRegistreMedecin.add(rM);
        rM.setBounds(new Rectangle(new Point(225, 30), rM.getPreferredSize()));

        //---- rechercheM ----
        rechercheM.setText("Recherche");
        rechercheM.setForeground(Color.orange);
        rechercheM.setFont(new Font(Constants.COPPERPLATE.getValue(), Font.BOLD, 14));
        panelRegistreMedecin.add(rechercheM);
        rechercheM.setBounds(55, 80, 93, 17);

        //---- nomM ----
        nomM.setText("Nom:");
        nomM.setAlignmentX(0.5F);
        nomM.setBorder(new EtchedBorder());
        panelRegistreMedecin.add(nomM);
        nomM.setBounds(130, 115, 40, 20);

        //---- prenomM ----
        prenomM.setText("Prenom:");
        prenomM.setAlignmentX(0.5F);
        prenomM.setBorder(new EtchedBorder());
        panelRegistreMedecin.add(prenomM);
        prenomM.setBounds(115, 155, 55, 15);
        panelRegistreMedecin.add(textNomM);
        textNomM.setBounds(180, 110, 250, 24);
        panelRegistreMedecin.add(textPrenomM);
        textPrenomM.setBounds(180, 150, 250, 24);

        //---- specialite ----
        specialite.setText("Specialite:");
        specialite.setAlignmentX(0.5F);
        specialite.setBorder(new EtchedBorder());
        panelRegistreMedecin.add(specialite);
        specialite.setBounds(105, 190, 65, 20);

        //---- telephone ----
        telephone.setText("Telephone:");
        telephone.setAlignmentX(0.5F);
        telephone.setBorder(new EtchedBorder());
        panelRegistreMedecin.add(telephone);
        telephone.setBounds(100, 230, 70, 20);
        panelRegistreMedecin.add(textSpecialite);
        textSpecialite.setBounds(180, 190, 250, textSpecialite.getPreferredSize().height);
        panelRegistreMedecin.add(textTelephone);
        textTelephone.setBounds(180, 230, 250, textTelephone.getPreferredSize().height);

        //---- validerRechercheM ----
        validerRechercheM.setText(Constants.VALIDER.getValue());
        validerRechercheM.setBackground(new Color(51, 153, 255));
        panelRegistreMedecin.add(validerRechercheM);
        validerRechercheM.setBounds(445, 150, 72, 24);

        //---- ouM ----

        panelRegistreMedecin.add(separator1M);
        separator1M.setBounds(0, 285, 1200, 15);

        //---- ajoutM ----
        ajoutM.setText("Ajout d'un medecin");
        ajoutM.setForeground(Color.orange);
        ajoutM.setFont(new Font(Constants.COPPERPLATE.getValue(), Font.BOLD, 14));
        panelRegistreMedecin.add(ajoutM);
        ajoutM.setBounds(55, 295, 175, 17);

        //---- nomM2 ----
        nomM2.setText("Nom:");
        nomM2.setAlignmentX(0.5F);
        nomM2.setBorder(new EtchedBorder());
        panelRegistreMedecin.add(nomM2);
        nomM2.setBounds(130, 330, 40, 20);

        //---- prenomM2 ----
        prenomM2.setText("Pr\u00e9nom:");
        prenomM2.setAlignmentX(0.5F);
        prenomM2.setBorder(new EtchedBorder());
        panelRegistreMedecin.add(prenomM2);
        prenomM2.setBounds(115, 370, 55, 15);

        //---- specialite2 ----
        specialite2.setText("Specialite:");
        specialite2.setAlignmentX(0.5F);
        specialite2.setBorder(new EtchedBorder());
        panelRegistreMedecin.add(specialite2);
        specialite2.setBounds(105, 405, 65, 20);

        //---- telephone2 ----
        telephone2.setText("Telephone:");
        telephone2.setAlignmentX(0.5F);
        telephone2.setBorder(new EtchedBorder());
        panelRegistreMedecin.add(telephone2);
        telephone2.setBounds(100, 445, 70, 20);
        panelRegistreMedecin.add(textNomM2);
        textNomM2.setBounds(180, 325, 250, 24);
        panelRegistreMedecin.add(textPrenomM2);
        textPrenomM2.setBounds(180, 365, 250, 24);
        panelRegistreMedecin.add(textSpecialite2);
        textSpecialite2.setBounds(180, 405, 250, 24);
        panelRegistreMedecin.add(textTelephone2);
        textTelephone2.setBounds(180, 445, 250, 24);

        //---- mdp2 ----
        mdpMedecin.setText("Mot de passe :");
        mdpMedecin.setAlignmentX(0.5F);
        mdpMedecin.setBorder(new EtchedBorder());
        panelRegistreMedecin.add(mdpMedecin);
        mdpMedecin.setBounds(80, 475, 93, 20);
        panelRegistreMedecin.add(textmdpMedecin);
        textmdpMedecin.setBounds(180, 475, 250, 24);

        //---- validerRechercheM2 ----
        validerRechercheM2.setText(Constants.VALIDER.getValue());
        validerRechercheM2.setBackground(new Color(51, 153, 255));
        panelRegistreMedecin.add(validerRechercheM2);
        validerRechercheM2.setBounds(445, 535, 72, 24);

        PanelCompute.computePreferedSize(panelRegistreMedecin);


        //fonctions
        setAjouterMedecin();
        setRechercherMedecin();

    }

    public void setRechercherMedecin() {
        textSpecialite.setEditable(false);
        textTelephone.setEditable(false);
        validerRechercheM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                LectureXML test1 = new LectureXML("listeMedecin.xml");
                ListeMedecin listeMedecin = test1.getListeMedecin();
                System.out.println(listeMedecin.rechercherMedecin(textNomM.getText(), textPrenomM.getText()));
                if (textPrenom.getText() != null && textNom.getText() != null) {
                    textSpecialite.setText(listeMedecin.rechercherMedecin(textNomM.getText(), textPrenomM.getText()).getSpecialite());
                    textTelephone.setText(listeMedecin.rechercherMedecin(textNomM.getText(), textPrenomM.getText()).getNumeroTel());
                }
            }
        });
    }


    public void setAjouterMedecin() {
        validerRechercheM2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Medecin medecin = new Medecin(textNomM2.getText(), textPrenomM2.getText(), textSpecialite2.getText(), textTelephone2.getText(), textmdpMedecin.getText());
                EcrireXML.saveToXML("src/donnees/ListeMedecin.xml", "medecin", medecin);
                JOptionPane.showMessageDialog(null, "Vous avez ajouté un medecin", "Ajout Medecin", JOptionPane.INFORMATION_MESSAGE);

                textNomM2.setText(null);
                textPrenomM2.setText(null);
                textSpecialite2.setText(null);
                textTelephone2.setText(null);
                textmdpMedecin.setText(null);
            }
        });

    }
}
