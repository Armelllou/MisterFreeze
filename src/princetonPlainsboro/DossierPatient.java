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
    private int numeroSecu;

    /*for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            if (p == f.getPatient()) {
                ajouterFiche(fiches.get(i));
            }
    */

    //private Acte tab[] = new acte[];
    //mettre adresse et numero secu en attribut de patient
    public DossierPatient(Patient p, String adresse, int numeroSecu) {
        this.p = p;
        this.adresse = adresse;
        this.numeroSecu = numeroSecu;
        this.fichesDuPatient = new ArrayList<>();
    }

    public void ajoutFiche(FicheDeSoins fiche) {
        fichesDuPatient.add(fiche);
    }

    public void trierParDates(Date d1, Date d2) {
        List<FicheDeSoins> ficheTrier = new ArrayList<>(fichesDuPatient);
        ficheTrier.removeIf(fiche -> fiche.getDate().compareTo(d1) < 0 || fiche.getDate().compareTo(d2) > 0);
        ficheTrier.sort((f1, f2) -> f1.getDate().compareTo(f2.getDate()));
        ficheTrier.forEach(fiche -> System.out.println(fiche));
    }

    public void afficherParCout() {
        List<FicheDeSoins> triParCout = new ArrayList<>(fichesDuPatient);
        triParCout.sort((f1, f2) -> Double.compare(f1.coutTotal(), f2.coutTotal()));
        triParCout.forEach(fiche -> System.out.println(fiche));
    }

    public void afficherListeMedecins(Patient p) {
        System.out.println("> liste des medecins de " + p.toString() + " :");
        for (int i = 0; i < fichesDuPatient.size(); i++) {
            FicheDeSoins f = fichesDuPatient.get(i);
            if (p.equals(f.getPatient())) {
                System.out.println(" - " + f.getMedecin().toString());
            }
        }
        System.out.println("\n");
    }

    public String toString() {
        for (int i = 0; i < fichesDuPatient.size(); i++) {
            FicheDeSoins f = fichesDuPatient.get(i);
            f.afficher();
        }
        return p.toString() + "" + this.numeroSecu + "" + this.adresse + "";
    }

}

