package princetonPlainsboro;

class Medecin {

    private String nom;
    private String prenom;
    private String specialite;
    private String numeroTel;
    private String mdp;

    public Medecin(String nom, String prenom, String specialite, String numeroTel, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.numeroTel = numeroTel;
        this.mdp = mdp;
    }

    public String toString() {
        return "Dr " + prenom + " " + nom + ", " + specialite + ", " + numeroTel;
    }

    public boolean equals(Object o) {
        if (o instanceof Medecin) {
            Medecin p = (Medecin) o;
            return nom.equals(p.nom) && prenom.equals(p.prenom);
        } else {
            return false;
        }
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;

    }

    public String getSpecialite() {
        return specialite;
    }

}
