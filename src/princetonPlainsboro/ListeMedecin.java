package princetonPlainsboro;

import java.util.ArrayList;
import java.util.List;

public class ListeMedecin {

    private List<Medecin> lm;

    public ListeMedecin() {
        this.lm = new ArrayList<Medecin>();
    }

    public void ajouterMedecin(Medecin paces) {
        this.lm.add(paces);
    }

    public Medecin rechercherMedecin(String nom, String prenom) {
        int i = 0;
        while (i < lm.size() && lm.get(i).getNom() != nom && lm.get(i).getPrenom() != prenom) {
            i++;
        }
        if (i == lm.size()) {
            return null;
        } else {
            return lm.get(i);
        }
    }

    // optionnel, recherche tout les medecins d'une specialite
    public List<Medecin> rechercherLesMedecinsDUneSpecialite(String specialite) {
        //if (specialite.toUpperCase() = ) {   //check si la specialite ecrite existe
        List<Medecin> lms = new ArrayList<Medecin>();
        for (int i = 0; i < lm.size(); i++) {
            if (specialite == lm.get(i).getSpecialite()) {
                lms.add(lm.get(i));
            }
        }
        return lms;
    }

    /*

        public Medecin rechercher(String nom, String prenom, String specialite, String numTel, String mdp){
            int i=0;
            Medecin m =new Medecin(nom,prenom,specialite,numTel,mdp);
            while(lm.get(i).getNom()!=nom && lm.get(i).getPrenom()!=prenom && lm.get(i).getSpecialite()!=specialite){
                i++;
            }
            m=lm.get(i);
            return m;
        }*/
}
