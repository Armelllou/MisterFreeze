/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        this.fichesDuPatient = new ArrayList<FicheDeSoins>();
    }

    public void ajoutFiche(FicheDeSoins fiche) {
        fichesDuPatient.add(fiche);
    }

    public void trierParDates(Date d1, Date d2) {
        List<FicheDeSoins> ficheTrier = new ArrayList<FicheDeSoins>(fichesDuPatient);
        for (FicheDeSoins fiche : fichesDuPatient) {
            if (fiche.getDate().compareTo(d1) < 0 || fiche.getDate().compareTo(d2) > 0) {
                ficheTrier.remove(fiche);
            }
        }
        Collections.sort(ficheTrier, new Comparator<FicheDeSoins>() {
            public int compare(FicheDeSoins f1, FicheDeSoins f2) {
                return f1.getDate().compareTo(f2.getDate());
            }
        });
        for (FicheDeSoins fiche : ficheTrier) {
            System.out.println(fiche);
        }
    }

    public void afficherParCout() {
        List<FicheDeSoins> triParCout = new ArrayList<FicheDeSoins>(fichesDuPatient);
        Collections.sort(triParCout, new Comparator<FicheDeSoins>() {
            public int compare(FicheDeSoins f1, FicheDeSoins f2) {
                return Double.compare(f1.coutTotal(), f2.coutTotal());
            }
        });
        for (FicheDeSoins fiche : triParCout) {
            System.out.println(fiche);
        }
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
        System.out.println(" ");
        System.out.println("Dossier Patient : ");
        return p.toString() + " " + this.numeroSecu + "" + this.adresse + "";
    }

}

