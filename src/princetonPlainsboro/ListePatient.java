package princetonPlainsboro;


import java.util.ArrayList;
import java.util.List;

class ListePatient {
    private List<Patient> lp;

    public  ListePatient(){
        this.lp = new ArrayList<Patient>();
    }

    public Patient rechercher(String nom, String prenom, Date dateNaissance, int numSecu){
        int i=0;
        Patient p =new Patient(nom,prenom, dateNaissance, numSecu);
        while(lp.get(i).getNom()!=nom && lp.get(i).getPrenom()!=prenom){
            i++;
        }
        p=lp.get(i);
        return p;
    }
}