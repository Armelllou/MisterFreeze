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
        return "Dr " + prenom + " " + nom + ", " + specialite + ", " + numeroTel + ", " + mdp;
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

    public String getNumeroTel() {
        return numeroTel;

    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getSpecialite() {
        return specialite;
    }

}
