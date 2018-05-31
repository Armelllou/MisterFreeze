package princetonPlainsboro;

import java.awt.*;

class Test {

    public static void main(String[] args) {
        afficherDossiersConsole();

        InterfaceSecretaireMedical f = new InterfaceSecretaireMedical();
        f.setMinimumSize(new Dimension(700, 700));

        // InterfaceAdministration I = new InterfaceAdministration();
    }

    private static void afficherDossiersConsole() {
        LectureXML test = new LectureXML("dossiers.xml");


        DossierMedical dm = test.getDossier();
        dm.afficher();

        System.out.println("\n********\n");

        Patient p1 = new Patient("Bole", "Pat");
        System.out.println("> cout de " + p1.toString() + " : " + dm.coutPatient(p1));

        System.out.println("\n********\n");

        String spe = "Cardiologue";
        System.out.println("> cout de la specialite '" + spe + "' : " + dm.coutSpecialite(spe));

        System.out.println("\n********\n");

        Medecin m1 = new Medecin("Deblouze", "Agathe", "Cardiologue");
        dm.afficherListePatients(m1); //affiche les patients du medecins

        System.out.println("\n********\n");

        Date d1 = new Date(1, 11, 2005);
        Date d2 = new Date(5, 1, 2006);
        System.out.println("> nombre de fiches entre " + d1 + " et " + d2 + " : " + dm.nombreFichesIntervalle(d1, d2));

        System.out.println("\n********\n");

        System.out.println();
        System.out.println("Dossier trie selon les dates :");
        dm.trierDates();  // trie par dates des fiches de soins

        System.out.println("\n********\n");

        System.out.println();
        System.out.println("Dossier trie selon les couts :");  //trie fiches selon les couts
        dm.trier(new ComparaisonFichesCouts());

        DossierPatient dp = new DossierPatient(p1,"16 rue de la chapelle" , 2970499);

        Patient p2 = new Patient("Bole", "Maggy");
        Date d3 = new Date(5, 1, 2007);
        FicheDeSoins fiche1 = new FicheDeSoins (p1,m1,d1);
        FicheDeSoins fiche3 = new FicheDeSoins (p1,m1,d2);
        FicheDeSoins fiche2 = new FicheDeSoins (p1,m1,d3);
        dp.ajoutFiche(fiche1);
        dp.ajoutFiche(fiche2);
        dp.ajoutFiche(fiche3);
        dp.afficherListeMedecins(p1);
        dp.afficherParCout(); //affiche pas acte médical
        dp.trierParDates(d1, d2);
        dp.trierParDates(d1, d2);

    }
}
