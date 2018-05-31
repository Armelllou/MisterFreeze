/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

import java.util.ArrayList;
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
        fichesDuPatient = new ArrayList<FicheDeSoins>();
    }

    public void ajoutFiche(FicheDeSoins fiche) {
        fichesDuPatient.add(fiche);
    }

    public void trierParDates(Date d1, Date d2) {
        List<FicheDeSoins> ficheTrier = new ArrayList<>(fichesDuPatient);
        ficheTrier.removeIf(fiche -> fiche.getDate().compareTo(d1) < 0 || fiche.getDate().compareTo(d2) > 0);
        /*while (!ficheTrier.isEmpty()) {System.out.println("test");
            //int imin = 0;
            FicheDeSoins f1 = ficheTrier.get(imin);
            Date d = f1.getDate();
            for (int i = 1; i < ficheTrier.size(); i++) {
                if (d.compareTo(d1) >= 0 && d.compareTo(d2) <= 0) {
                    FicheDeSoins f2 = ficheTrier.get(i);
                    if (f2.getDate().compareTo(f1.getDate()) < 0) {
                        imin = i;
                        f1 = f2;
                    }else{
                        ficheTrier.remove(imin);
                    }
                }

            }
            // on affiche la fiche de soins trouvee :
            f1.afficher();
            System.out.println("------------------------");
            //on la supprime de la liste :
            ficheTrier.remove(imin);
        }*/
        ficheTrier.forEach(fiche -> System.out.println(fiche));
    }

    public void afficherParCout() {
        List<FicheDeSoins> triParCout = new ArrayList<>(fichesDuPatient);
        triParCout.sort((f1, f2) -> Double.compare(f1.coutTotal(), f2.coutTotal()));
        /*while (!fichesDuPatient.isEmpty()) {
            int imin = 0;
            FicheDeSoins f1 = fichesDuPatient.get(imin);
            for (int i = 1; i < fichesDuPatient.size(); i++) {
                FicheDeSoins f2 = fichesDuPatient.get(i);
                if (f2.coutTotal() > (f1.coutTotal())) {
                    imin = i;
                    f1 = f2;
                }
            }
            // on affiche la fiche de soins trouvee :
            f1.afficher();
            System.out.println(f1.coutTotal());
            System.out.println("------------------------");
            //on la supprime de la liste :
            fichesDuPatient.remove(imin);
        }*/
        triParCout.forEach(fiche -> System.out.println(fiche));
    }

    public void afficherListeMedecins(Patient p) {
        System.out.println("> liste des medecins du " + p.toString() + " :");
        List<Medecin> liste = new ArrayList<Medecin>();
        for (int i = 0; i < fichesDuPatient.size(); i++) {
            FicheDeSoins f = fichesDuPatient.get(i);
            if (p.equals(f.getPatient())) {
                Medecin m = f.getMedecin();
                if (!liste.contains(p)) {
                    System.out.println(" - " + m.toString());
                    liste.add(m);
                }

            }
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

