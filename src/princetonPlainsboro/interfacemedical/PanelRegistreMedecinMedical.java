package princetonPlainsboro.interfacemedical;

import princetonPlainsboro.Constants;
import princetonPlainsboro.LectureXML;
import princetonPlainsboro.ListeMedecin;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelRegistreMedecinMedical {
    private JTextField textNomM;
    private JTextField textPrenomM;
    private JTextField textSpecialite;
    private JTextField textPrenom;
    private JTextField textNom;

    private JTextField textTelephone;
    private JButton validerRechercheM;

    PanelRegistreMedecinMedical(JPanel panelRegistreMedecin) {
        JLabel rM = new JLabel();
        JLabel rechercheM = new JLabel();
        JLabel nomM = new JLabel();
        JLabel prenomM = new JLabel();
        textNomM = new JTextField();
        textPrenomM = new JTextField();
        JLabel specialite = new JLabel();
        JLabel telephone = new JLabel();
        textSpecialite = new JTextField();
        textTelephone = new JTextField();
        validerRechercheM = new JButton();
        JLabel ouM = new JLabel();
        JSeparator separator1M = new JSeparator();
        JLabel ajoutM = new JLabel();
        JLabel nomM2 = new JLabel();
        JLabel prenomM2 = new JLabel();
        JLabel specialité2 = new JLabel();
        JLabel telephone2 = new JLabel();
        JTextField textNomM2 = new JTextField();
        JTextField textPrénomM2 = new JTextField();
        JTextField textSpecialite2 = new JTextField();
        JTextField textTelephone2 = new JTextField();
        JButton validerRechercheM2 = new JButton();

        //======== this ========

        panelRegistreMedecin.setLayout(null);

        //---- rM ----
        rM.setText("Registre Medecins");
        rM.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
        rM.setForeground(Color.magenta);
        panelRegistreMedecin.add(rM);
        rM.setBounds(new Rectangle(new Point(225, 30), rM.getPreferredSize()));

        //---- rechercheM ----
        rechercheM.setText("Recherche : entrez le nom et le prenom");
        rechercheM.setForeground(Color.orange);
        rechercheM.setFont(new Font(Constants.COPPERPLATE.getValue(), Font.BOLD, 14));
        panelRegistreMedecin.add(rechercheM);
        rechercheM.setBounds(55, 80, 400, 17);

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

        //---- specialité ----
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

        PanelCompute.computePreferedSize(panelRegistreMedecin);
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
}
