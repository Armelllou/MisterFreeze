package princetonPlainsboro;

import java.util.List;
import java.util.Vector;

public class DossierMedical {

    private List<FicheDeSoins> fiches;     // contient des objets de classe 'FicheDeSoins'
    private List<Patient> lp;  //vérifier si lp etait la au debut

    public DossierMedical() {
        fiches = new Vector<FicheDeSoins>();  // liste vide
    }

    public void ajouterFiche(FicheDeSoins fiche) {
        fiches.add(fiche);
    }

    public String toStringDM() {
        String t = "Dossier medical informatise :" + "\n" + Constants.SEPARATION.getValue() + "\n";
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            t += f.toString();
            t += "\n";
        }
        return t;
    }

    public void afficher() { //affiche toutes les fiches de la liste
        System.out.println("Dossier medical informatise :");
        System.out.println(Constants.SEPARATION.getValue());
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            f.afficher();
            // pour separer les fiches de soins :
            System.out.println(Constants.SEPARATION.getValue());
        }
    }

    public void afficherPatients() { //affiche tous les patients
        System.out.println("Les patients de l'etablissement sont : ");
        for (int i = 0; i < lp.size(); i++) {
            System.out.println(lp.get(i).toString() + ";");

        }
    }

    public double coutPatient(Patient p) {
        double cout = 0;
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            if (p.equals(f.getPatient())) { //cherche dans toutes les fiches si elles ont pour patient p, ce qui es lourd alors qu'il sera plus simple d'utiliser le dossier medical d'un patient et d'afficher toutes les fiches
                cout += f.coutTotal();
            }
        }
        return cout;
    }

    public double coutMedecin(Medecin m) {
        double cout = 0;
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            if (m.equals(f.getMedecin())) {
                cout += f.coutTotal();
            }
        }
        return cout;
    }

    public double coutSpecialite(String specialite) {
        double cout = 0;
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            if (specialite.equals(f.getMedecin().getSpecialite())) {
                cout += f.coutTotal();
            }
        }
        return cout;
    }

    public void afficherListePatients(Medecin m) {
        System.out.println("> liste des patients du " + m.toString() + " :");
        Vector<Patient> liste = new Vector<Patient>();
        // 'liste' contient tous les patients deja affiches
        // --> ceci permet de ne pas reafficher un patient deja affiche
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            if (m.equals(f.getMedecin())) {
                Patient p = f.getPatient();
                if (!liste.contains(p)) {
                    System.out.println(" - " + p.toString());
                    liste.add(p);
                }
            }
        }
    }

    public int nombreFichesIntervalle(Date d1, Date d2) {
        int n = 0;
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            Date d = f.getDate();
            if (d.compareTo(d1) >= 0 && d.compareTo(d2) <= 0) {
                n++;
            }
        }
        return n;
    }

    public void trierDates() {
        Vector<FicheDeSoins> copieFiches = new Vector<FicheDeSoins>(fiches);
        Vector<FicheDeSoins> copieLocale = new Vector<FicheDeSoins>();
        while (!copieFiches.isEmpty()) {  //tant que c'est pas vide, on affiche la fiche minimale qu'on en date et on la supprime
            // on cherche la fiche de soins de date minimale :
            int imin = 0;
            FicheDeSoins f1 = copieFiches.get(imin);
            for (int i = 1; i < copieFiches.size(); i++) {
                FicheDeSoins f2 = copieFiches.get(i);
                if (f2.getDate().compareTo(f1.getDate()) < 0) {
                    imin = i;
                    f1 = f2;
                }
            }
            // on affiche la fiche de soins trouvee :
            f1.afficher();
            System.out.println(Constants.SEPARATION.getValue());
            //on copie dans copieLocale et on la supprime de la liste :
            copieLocale.add(copieFiches.get(imin));
            copieFiches.remove(imin);
        }
        fiches = copieLocale;
    }

    // tri generique :
    public void trier(ComparaisonFiches c) {  //comparaisonfiche ne sera pas le parametre, le parametre sera comparaisonfichecout/date
        Vector<FicheDeSoins> copieFiches = new Vector<FicheDeSoins>(fiches);
        Vector<FicheDeSoins> copieLocale = new Vector<FicheDeSoins>();

        while (!copieFiches.isEmpty()) {
            // on cherche la fiche de soins minimale :
            int imin = 0;
            FicheDeSoins f1 = copieFiches.get(imin);
            for (int i = 1; i < copieFiches.size(); i++) {
                FicheDeSoins f2 = copieFiches.get(i);
                if (c.comparer(f2, f1) < 0) {
                    imin = i;
                    f1 = f2;
                }
            }
            // on affiche la fiche de soins trouvee :
            f1.afficher();
            System.out.println(Constants.SEPARATION.getValue());
            //on la supprime de la liste apès avoir copier dans copie locale :
            copieLocale.add(copieFiches.get(imin));
            copieFiches.remove(imin);
        }
        fiches = copieLocale;

    }

    public void trierEntreDeuxDates(Date d1, Date d2, ComparaisonFiches c) {
        Vector<FicheDeSoins> copieFiches = new Vector<FicheDeSoins>(fiches);
        Vector<FicheDeSoins> copieLocale = new Vector<FicheDeSoins>();

        while (!copieFiches.isEmpty()) {
            // on cherche la fiche de soins minimale :
            int imin = 0;
            FicheDeSoins f = fiches.get(imin);
            Date d = f.getDate();
            if (d.compareTo(d1) >= 0 && d.compareTo(d2) <= 0) {
                for (int i = 1; i < copieFiches.size(); i++) {
                    FicheDeSoins f2 = copieFiches.get(i);
                    if (c.comparer(f2, f) < 0) {
                        imin = i;
                        f = f2;
                    }
                }
            }
            // on affiche la fiche de soins trouvee :
            f.afficher();
            System.out.println(Constants.SEPARATION.getValue());
            //on la supprime de la liste après avoir copié dans copieLocale:
            copieLocale.add(copieFiches.get(imin));
            copieFiches.remove(imin);
        }
        fiches = copieLocale;

    }

    //ajout methode getListe utilisee dans DossierPatient
    public List<FicheDeSoins> getListe() {
        return fiches;
    }

    //rechercher patient à partir de son numèro de sécu
    public Patient rechercherPatientViaSecu(String numSecu) {
        int i = 0;
        while (i < lp.size() && lp.get(i).getNumSecu() != numSecu) {
            i++;
        }
        if (i == lp.size()) {
            return null;
        } else {
            return lp.get(i);
        }

    }

    //donne toutes les fiches de soins d'un patient
    public List<FicheDeSoins> rechercherfichesDUnPatient(String num) {
        Vector<FicheDeSoins> lfs = new Vector<FicheDeSoins>();
        for (int i = 0; i < fiches.size(); i++) {
            if (num.equals(fiches.get(i).getPatient().getNumSecu())) {
                lfs.add(fiches.get(i));
            }
        }
        if (lfs.isEmpty()) {
            return null;
        }else{
            return lfs;
        }
        
    }
    

    //donne la fiche d'un patient à un temps t
    public FicheDeSoins rechercherFiche(Patient patient, Date date) {
        int i = 0;
        while (i < fiches.size() && !patient.equals(fiches.get(i).getPatient()) && !date.equals(fiches.get(i).getDate())) {
            i++;
        }
        if (i == fiches.size()) {
            return null;
        } else {
            return fiches.get(i);
        }
    }

    /*
    public Patient rechercher(String nom, String prenom, Date dateNaissance, int numSecu) {
        int i = 0;
        Patient p = new Patient(nom, prenom, dateNaissance, numSecu);
        while (lp.get(i).getNom() != nom && lp.get(i).getPrenom() != prenom) {
            i++;
        }
        p = lp.get(i);
        return p;
    }*/
}
