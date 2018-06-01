package princetonPlainsboro;

import java.util.ArrayList;
import java.util.List;

public class ListDossierPatient {
    private List<DossierPatient> dossierPatientList;

    public ListDossierPatient() {
        dossierPatientList = new ArrayList<DossierPatient>();
    }

    public void ajoutDossierPatient(DossierPatient dp) {
        dossierPatientList.add(dp);
    }

    public void afficherListDossierPatient() {
        for (int i = 0; i < dossierPatientList.size(); i++) {
            DossierPatient dp = dossierPatientList.get(i);
            System.out.println("    > " + dp.toString());

        }
    }
}
