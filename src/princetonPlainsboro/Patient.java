package princetonPlainsboro;

class Patient {

    private String nom;
    private String prenom;
    private String adresse;
    private String numSecu;
    private Date dateNaissance;

    public Patient(String nom, String prenom, String adresse, String numSecu, Date dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numSecu = numSecu;
        this.dateNaissance=dateNaissance;


    }

    public String toString() {
        return prenom + " " + nom + ", Adresse :  " + adresse + ", et ayant pour numero de securite sociale " + numSecu + ", né(e) le : " + dateNaissance;
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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumSecu() {
        return numSecu;
    }

    public void setNumSecu(String numSecu) {
        this.numSecu = numSecu;
    }

    public String getAdresse() {
        return adresse;
    }


    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }
}
