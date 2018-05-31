package princetonPlainsboro;

//comparaison croissante
class ComparaisonFichesCouts implements ComparaisonFiches {
    public int comparer(FicheDeSoins fiche1, FicheDeSoins fiche2) {
        Double c1 = fiche1.coutTotal();
        Double c2 = fiche2.coutTotal();

        return c1.compareTo(c2);
    }
}
