package princetonPlainsboro;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

class ListePatient {

    private List<Patient> lp;
    private final static String repBase = "src/donnees/";
    /// nom du document XML a analyser
    private String nomFichier = "listePatient.xml";

    public ListePatient() {
        this.lp = new ArrayList<Patient>();
    }

    public void ajouterPatient(Patient p) {
        this.lp.add(p);
    }

    public Patient rechercher(String numSecu) {
        for(Patient patient : lp){
            if(patient.getNumSecu().equals(numSecu)){
                return patient;
            }
        }
        return null;
        /*int i = 0;
        Patient p = new Patient("", "", null, numSecu);
        while (i < lp.size() && lp.get(i).getNumSecu() != numSecu) {
            i++;
        }
        p = lp.get(i);
        return p;*/
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public Patient getPatient() {  //check si enlève des trucs
        DossierMedical dossierCourant = null;
        Date dateNaissance = null;
        Medecin medecinCourant = null;
        Patient patientCourant = null;
        List<Acte> actes = new Vector<Acte>();
        //List<FicheDeSoins> fiches = new Vector<FicheDeSoins>();
        String donneesCourantes = "";
        String nomCourant = "";
        String prenomCourant = "";
        String mdpCourant = "";
        String specialiteCourante = "";
        Code codeCourant = null;
        String numSecu = "";
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
                        if (parser.getLocalName().equals("patient")) {
                            patientCourant = new Patient(nomCourant, prenomCourant, dateNaissance, numSecu);
                        }
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

        return patientCourant;
    }



}
