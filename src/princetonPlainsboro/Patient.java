package princetonPlainsboro;

public class Patient {

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
        this.dateNaissance = dateNaissance;


    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (nom.length() > 1) {
            builder.append(" ").append(nom);
        }
        if (prenom.length() > 1) {
            builder.append(" ").append(prenom);
        }
        if (dateNaissance != null) {
            builder.append(", né(e) le : ").append(dateNaissance).append(".");
        }
        if (numSecu.length() > 1) {
            builder.append(" SS : ").append(numSecu);
        }
        if (adresse.length() > 1) {
            builder.append("\n Adresse : ").append(adresse);
        }
        return builder.toString();
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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}
