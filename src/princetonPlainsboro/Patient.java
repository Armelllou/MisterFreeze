package princetonPlainsboro;

class Patient {

    private String nom;
    private String prenom;
    private String adresse;
    private String numSecu;

    public Patient(String nom, String prenom, String adresse, String numSecu) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numSecu = numSecu;

    }

    public String toString() {
        return prenom + " " + nom + ", nee le " + getAdresse() + " et ayant pour numero de securite sociale " + numSecu;
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

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumSecu() {
        return numSecu;
    }

    /**
     * @param numSecu the numSecu to set
     */
    public void setNumSecu(String numSecu) {
        this.numSecu = numSecu;
    }

    /**
     * @return the dateNaissance
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param dateNaissance the dateNaissance to set
     */



}
