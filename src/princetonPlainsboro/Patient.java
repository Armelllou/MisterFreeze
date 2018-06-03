package princetonPlainsboro;

class Patient {

    private String nom;
    private String prenom;
    private Date dateNaissance;
    private int numSecu;

    public Patient(String nom, String prenom, Date dateNaissance, int numSecu) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.numSecu = numSecu;

    }

    public String toString() {
        return prenom + " " + nom + ", nee le " + dateNaissance + " et ayant pour numero de securite sociale " + numSecu;
    }

    public boolean equals(Object o) {
        if (o instanceof Patient) {
            Patient p = (Patient) o;
            return nom.equals(p.nom) && prenom.equals(p.prenom);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + nom.hashCode();
        result = 31 * result + prenom.hashCode();
        return result;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getNumSecu() {
        return numSecu;
    }
}
