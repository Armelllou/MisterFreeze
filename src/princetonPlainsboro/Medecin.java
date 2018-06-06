package princetonPlainsboro;

public class Medecin {

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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Dr.");
        if (nom.length() > 1) {
            builder.append(" ").append(nom);
        }
        if (prenom.length() > 1) {
            builder.append(" ").append(prenom);
        }
        if (specialite.length() > 1) {
            builder.append(", ").append(specialite);
        }
        if (numeroTel.length() > 1) {
            builder.append(", ").append(numeroTel);
        }
        return builder.toString();
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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;

    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMdp() {
        return mdp;

    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getNumeroTel() {
        return numeroTel;

    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

}
