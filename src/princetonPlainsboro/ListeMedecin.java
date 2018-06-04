package princetonPlainsboro;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ListeMedecin {

    private List<Medecin> lm;
    private final static String repBase = "src/donnees/";
    /// nom du document XML a analyser
    private String nomFichier = "listeMedecin.xml";

    public ListeMedecin() {
        this.lm = new ArrayList<Medecin>();
    }

    public void ajouterMedecin(Medecin paces) {
        this.lm.add(paces);
    }

    public Medecin rechercherMedecin(String nom, String prenom) {
        for(Medecin medecin : lm){
            if(medecin.getNom().equals(nom) && medecin.getPrenom().equals(prenom)){
                return medecin;
            }
        }
        return null;
    }

    public void afficherMedecin() { //affiche toutes les fiches de la liste
        System.out.println("Liste Medecin  :");
        System.out.println("-----------------------------");
        for (Medecin listeMedecin : lm) {
            System.out.println(listeMedecin);
            System.out.println("-----------------------------");
        }
    }



    // optionnel, recherche tout les medecins d'une specialite
    public List<Medecin> rechercherLesMedecinsDUneSpecialite(String specialite) {
        //if (specialite.toUpperCase() = ) {   //check si la specialite ecrite existe
        List<Medecin> lms = new ArrayList<Medecin>();
        for (int i = 0; i < lm.size(); i++) {
            if (specialite.equals(lm.get(i).getSpecialite())) {
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

    public Medecin getMedecin() {
        DossierMedical dossierCourant = null;
        Date date = null;
        Medecin medecinCourant = null;
        Patient patientCourant = null;
        List<Acte> actes = new Vector<Acte>();
        String donneesCourantes = "";
        String nomCourant = "";
        String prenomCourant = "";
        String mdpCourant = "";
        String specialiteCourante = "";
        Code codeCourant = null;
        String numTel = "";
        int coefCourant = 0;

        // analyser le fichier par StAX
        try {
            // instanciation du parser
            InputStream in = new FileInputStream(repBase + nomFichier);
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader parser = factory.createXMLStreamReader(in);

            // lecture des evenements
            for (int event = parser.next(); event != XMLStreamConstants.END_DOCUMENT; event = parser.next()) {
                // traitement selon l'evenement
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if(parser.getLocalName().equals("medecin")) {
                            medecinCourant = new Medecin(nomCourant, prenomCourant, specialiteCourante, numTel, mdpCourant);}
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        donneesCourantes = parser.getText();
                        break;
                } // end switch
            } // end while
            parser.close();
        } catch (XMLStreamException ex) {
            System.out.println("Exception de type 'XMLStreamException' lors de la lecture du fichier : " + nomFichier);
            System.out.println("Details :");
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Exception de type 'IOException' lors de la lecture du fichier : " + nomFichier);
            System.out.println("Verifier le chemin.");
            System.out.println(ex.getMessage());
        }

        return medecinCourant;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public List<String> repertoire() {
        String donneesCourantes = "";
        List<String> repertoire = null;
        setNomFichier("authentifications.xml");
        try {
            InputStream in = new FileInputStream(repBase + nomFichier);
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader parser = factory.createXMLStreamReader(in);

            for (int event = parser.next(); event != XMLStreamConstants.END_DOCUMENT; event = parser.next()) {
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if (parser.getLocalName().equals("root")) {
                            repertoire = new ArrayList<String>();
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if (parser.getLocalName().equals("id")) {
                            repertoire.add(donneesCourantes);
                        }
                        if (parser.getLocalName().equals("mdp")) {
                            repertoire.add(donneesCourantes);
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        donneesCourantes = parser.getText();
                        break;
                }
            }
            in.close();
            parser.close();
        } catch (XMLStreamException ex) {
            System.out.println("Exception de type 'XMLStreamException' lors de la lecture du fichier : " + nomFichier);
            System.out.println("Details :");
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println("Exception de type 'IOException' lors de la lecture du fichier : " + nomFichier);
            System.out.println("Verifier le chemin.");
            System.out.println(ex.getMessage());
        }
        return repertoire;
    }

}
