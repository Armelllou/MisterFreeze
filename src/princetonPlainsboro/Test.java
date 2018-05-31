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

        String separation = "\n********\n";

        Patient p1 = new Patient("Bole", "Pat");
        Patient p2 = new Patient("Bole", "Maggy");

        String spe = "Cardiologue";
        Medecin m1 = new Medecin("Deblouze", "Agathe", spe);
        Medecin m2 = new Medecin("Jared", "Curry", "Moche");
        Medecin m3 = new Medecin("Roussillon", "Julien", "Musicien");

        Date d1 = new Date(1, 11, 2005);
        Date d2 = new Date(5, 1, 2006);
        Date d3 = new Date(5, 1, 2007);
        Date d4 = new Date(4, 1, 2006);


        DossierMedical dm = test.getDossier();
        dm.afficher();

        System.out.println(separation);

        System.out.println("> cout de " + p1.toString() + " : " + dm.coutPatient(p1));

        System.out.println(separation);

        System.out.println("> cout de la specialite '" + spe + "' : " + dm.coutSpecialite(spe));

        System.out.println(separation);

        dm.afficherListePatients(m1); //affiche les patients du medecins

        System.out.println(separation);

        System.out.println("> nombre de fiches entre " + d1 + " et " + d2 + " : " + dm.nombreFichesIntervalle(d1, d2));

        System.out.println(separation);

        System.out.println();
        System.out.println("Dossier trie selon les dates :");
        dm.trierDates();  // trie par dates des fiches de soins

        System.out.println(separation);

        System.out.println();
        System.out.println("Dossier trie selon les couts :");  //trie fiches selon les couts
        dm.trier(new ComparaisonFichesCouts());


        DossierPatient dp = new DossierPatient(p1, "16 rue de la chapelle", 2970499);

        dp.ajoutFiche(new FicheDeSoins(p1, m1, d1));
        dp.ajoutFiche(new FicheDeSoins(p2, m2, d2));
        dp.ajoutFiche(new FicheDeSoins(p1, m3, d3));
        dp.ajoutFiche(new FicheDeSoins(p2, m1, d4));
        dp.afficherListeMedecins(p1);
        dp.afficherListeMedecins(p2);

        dp.afficherParCout(); //affiche pas acte médical
        System.out.println("\nAfficher date 1\n");
        dp.trierParDates(d1, d2);
        System.out.println("\nAfficher date 2\n");
        dp.trierParDates(d1, d3);

    }
}
