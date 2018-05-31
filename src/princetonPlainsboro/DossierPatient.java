/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

import java.util.List;

/**
 * @author gaillar3
 */
public class DossierPatient {

    private Patient p;
    private List<FicheDeSoins> fichesDuPatient;
    private String adresse;
    private int numeroSecu;        /*for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            if (p == f.getPatient()) {
                ajouterFiche(fiches.get(i));
            }*/

    //private Acte tab[] = new acte[];
    //mettre adresse et numero secu en attribut de patient
    public DossierPatient(Patient p, String adresse, int numeroSecu) {
        this.p = p;
        this.adresse = adresse;
        this.numeroSecu = numeroSecu;

    }

    public void ajoutFiche(FicheDeSoins fiche) {
        fichesDuPatient.add(fiche);
    }

    public void trierParDates(Date d1, Date d2) {
        while (!fichesDuPatient.isEmpty()) {
            int imin = 0;
            FicheDeSoins f1 = fichesDuPatient.get(imin);
            Date d = f1.getDate();
            for (int i = 1; i < fichesDuPatient.size(); i++) {
                if (d.compareTo(d1) >= 0 && d.compareTo(d2) <= 0) {
                    FicheDeSoins f2 = fichesDuPatient.get(i);
                    if (f2.getDate().compareTo(f1.getDate()) < 0) {
                        imin = i;
                        f1 = f2;
                    }
                }//verifier deuxieme f2 dans intervalle

            }
            // on affiche la fiche de soins trouvee :
            f1.afficher();
            System.out.println("------------------------");
            //on la supprime de la liste :
            fichesDuPatient.remove(imin);
        }
    }

    public String toString() {
        for (int i = 0; i < fichesDuPatient.size(); i++) {
            FicheDeSoins f = fichesDuPatient.get(i);
            f.afficher();
        }
        return p.toString() + "" + this.numeroSecu + "" + this.adresse + "";
    }

}

