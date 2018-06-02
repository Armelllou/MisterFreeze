package princetonPlainsboro;


import java.util.ArrayList;
import java.util.List;

public class ListeMedecin {

        private List<Medecin> lm;

        public  ListeMedecin(){
            this.lm = new ArrayList<Medecin>();
        }

        public Medecin rechercher(String nom, String prenom, String specialite, String numTel){
            int i=0;
            Medecin m =new Medecin(nom,prenom,specialite,numTel);
            while(lm.get(i).getNom()!=nom && lm.get(i).getPrenom()!=prenom && lm.get(i).getSpecialite()!=specialite){
                i++;
            }
            m=lm.get(i);
            return m;
        }

    }
