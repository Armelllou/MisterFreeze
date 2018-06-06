package princetonPlainsboro.interfacemedical;

import princetonPlainsboro.Constants;
import princetonPlainsboro.DossierMedical;
import princetonPlainsboro.LectureXML;

import javax.swing.*;
import java.awt.*;

public class PanelDossierMedical {

    PanelDossierMedical(JPanel panelDossierMedical) {
        //recupère Les fiches de soins du XML
        LectureXML test = new LectureXML("dossiers.xml");
        DossierMedical dm1 = test.getDossier();
        JTextArea dossierMed = new JTextArea(dm1.toStringDM());
        panelDossierMedical.add(dossierMed, BorderLayout.CENTER);

        //titre registre Medical
        JLabel registreM = new JLabel("Registre Medical");
        panelDossierMedical.add(registreM, BorderLayout.NORTH);
        Font police1 = new Font(Constants.TAHOMA.getValue(), Font.BOLD, 20);
        registreM.setFont(police1);
        registreM.setHorizontalAlignment(JLabel.CENTER);
        registreM.setVerticalAlignment(JLabel.CENTER);
    }
}
