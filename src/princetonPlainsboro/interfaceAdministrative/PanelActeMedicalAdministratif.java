package princetonPlainsboro.interfaceAdministrative;

import princetonPlainsboro.Acte;
import princetonPlainsboro.Code;
import princetonPlainsboro.Constants;
import princetonPlainsboro.interfacemedical.PanelCompute;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelActeMedicalAdministratif {
    private JTextField textType;
    private JTextField textCode;
    private JTextField textCoef;
    private JTextField textCout;
    private JButton validerActe;


    public PanelActeMedicalAdministratif(JPanel panelActe){
        JLabel rAM = new JLabel();
        JLabel acte = new JLabel();
        JLabel type = new JLabel();
        JLabel code = new JLabel();
        JLabel coeff = new JLabel();
        JLabel cout = new JLabel();
        textType = new JTextField();
        textCode = new JTextField();
        textCoef = new JTextField();
        textCout = new JTextField();
        JLabel euro = new JLabel();
        validerActe = new JButton();

        //======== this ========
        panelActe.setBorder(new BevelBorder(BevelBorder.LOWERED));


        panelActe.setLayout(null);

        //---- rAM ----
        rAM.setText("Rechercher d'un acte medical");
        rAM.setFont(new Font("Arimo", Font.BOLD, 22));
        rAM.setForeground(new Color(51, 0, 153));
        panelActe.add(rAM);
        rAM.setBounds(150, 35, 350, 30);
        rAM.setHorizontalAlignment(JLabel.CENTER);
        rAM.setVerticalAlignment(JLabel.CENTER);

        //---- acte ----
        acte.setText("ACTE : entrez le coefficient et le code");
        acte.setForeground(new Color(0, 102, 102));
        acte.setFont(new Font(Constants.COPPERPLATE.getValue(), Font.BOLD, 14));
        panelActe.add(acte);
        acte.setBounds(70, 95, 300, acte.getPreferredSize().height);

        //---- type ----
        type.setText(" Coefficient :");
        type.setBorder(new BevelBorder(BevelBorder.LOWERED));
        panelActe.add(type);
        type.setBounds(70, 140, 75, type.getPreferredSize().height);

        //---- code ----
        code.setText("Code :");
        code.setBorder(new BevelBorder(BevelBorder.LOWERED));
        panelActe.add(code);
        code.setBounds(100, 175, 45, code.getPreferredSize().height);

        //---- coeff ----
        coeff.setText("Type :");
        coeff.setBorder(new BevelBorder(BevelBorder.LOWERED));
        panelActe.add(coeff);
        coeff.setBounds(100, 210, 45, coeff.getPreferredSize().height);

        //---- cout ----
        cout.setText(" Cout :");
        cout.setBorder(new BevelBorder(BevelBorder.LOWERED));
        panelActe.add(cout);
        cout.setBounds(100, 245, 45, 15);
        panelActe.add(textType);
        textType.setBounds(150, 135, 235, textType.getPreferredSize().height);
        panelActe.add(textCode);
        textCode.setBounds(150, 170, 235, textCode.getPreferredSize().height);
        panelActe.add(textCoef);
        textCoef.setBounds(150, 205, 235, textCoef.getPreferredSize().height);
        panelActe.add(textCout);
        textCout.setBounds(150, 240, 235, textCout.getPreferredSize().height);

        //---- euro ----
        euro.setText("euros");
        euro.setBorder(new BevelBorder(BevelBorder.LOWERED));
        panelActe.add(euro);
        euro.setBounds(220, 245, 15, euro.getPreferredSize().height);

        //---- validerActe ----
        validerActe.setText(Constants.VALIDER.getValue());
        validerActe.setBackground(new Color(0, 161, 219));
        panelActe.add(validerActe);
        validerActe.setBounds(new Rectangle(new Point(400, 170), validerActe.getPreferredSize()));

        PanelCompute.computePreferedSize(panelActe);
        setRechercheCout();
    }

    private void setRechercheCout(){
        textCoef.setEditable(false);
        textCout.setEditable(false);
        validerActe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                textCout.setEditable(false);
                Acte acte = new Acte(Code.valueOf(textCode.getText()), Integer.parseInt(textType.getText()), textCoef.getText());

                textCout.setText(String.valueOf(acte.cout()));
            }
        });
    }
}
