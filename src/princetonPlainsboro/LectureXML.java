/*
 * LectureXML.java
 *
 * Created on 5 janvier 2006, 18:26
 *
 * Lecture d'un document XML et transformation en instances Java
 */
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

/**
 * Lecture d'un document XML et transformation en instances Java.
 *
 * @author promayon
 */
public class LectureXML {

    /// nom du document XML a analyser
    private String nomFichier;
    /// nom du document XML a analyser
    private String nomFichier1 = "listeMedecin.xml";
    private String nomFichier2 = "listePatient.xml";

    // 'nomFichier' est le nom d'un fichier XML se trouvant dans le repertoire 'REP_BASE' a lire :
    public LectureXML(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public DossierMedical getDossier() {
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
        String adresseCourant = "";
        String numSecuCourant = "";

        // analyser le fichier par StAX
        try {
            // instanciation du parser
            InputStream in = new FileInputStream(Constants.REB_BASE.getValue() + nomFichier);
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader parser = factory.createXMLStreamReader(in);

            // lecture des evenements
            for (int event = parser.next(); event != XMLStreamConstants.END_DOCUMENT; event = parser.next()) {
                // traitement selon l'evenement
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if (parser.getLocalName().equals("dossiers")) {
                            dossierCourant = new DossierMedical();
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if (parser.getLocalName().equals("acte")) {
                            actes.add(new Acte(codeCourant, coefCourant));
                        }
                        if (parser.getLocalName().equals("code")) {
                            codeCourant = Code.valueOf(donneesCourantes);
                        }
                        if (parser.getLocalName().equals("coef")) {
                            coefCourant = Integer.parseInt(donneesCourantes);
                        }
                        if (parser.getLocalName().equals("date")) {
                            int annee = Integer.parseInt(donneesCourantes.substring(0, donneesCourantes.indexOf('-')));
                            int mois = Integer.parseInt(donneesCourantes.substring(donneesCourantes.indexOf('-') + 1, donneesCourantes.lastIndexOf('-')));
                            int jour = Integer.parseInt(donneesCourantes.substring(donneesCourantes.lastIndexOf('-') + 1, donneesCourantes.length()));

                            date = new Date(jour, mois, annee);
                        }
                        if (parser.getLocalName().equals("ficheDeSoins")) {
                            FicheDeSoins f = new FicheDeSoins(patientCourant, medecinCourant, date);
                            // ajout des actes
                            for (int i = 0; i < actes.size(); i++) {
                                Acte a = (Acte) actes.get(i);
                                f.ajouterActe(a);
                            }
                            // effacer tous les actes de la liste
                            actes.clear();
                            // ajouter la fiche de soin au dossiers
                            dossierCourant.ajouterFiche(f);
                        }
                        if (parser.getLocalName().equals("medecin")) {
                            medecinCourant = new Medecin(nomCourant, prenomCourant, specialiteCourante, numTel, mdpCourant);
                        }
                        if (parser.getLocalName().equals("nom")) {
                            nomCourant = donneesCourantes;
                        }
                        if (parser.getLocalName().equals("patient")) {
                            patientCourant = new Patient(nomCourant, prenomCourant, adresseCourant, numSecuCourant, date);
                        }
                        if (parser.getLocalName().equals("prenom")) {
                            prenomCourant = donneesCourantes;
                        }
                        if (parser.getLocalName().equals("specialite")) {
                            specialiteCourante = donneesCourantes;
                        }


                        break;
                    case XMLStreamConstants.CHARACTERS:
                        donneesCourantes = parser.getText();
                        break;
                } // end switch
            } // end while
            parser.close();
            in.close();
        } catch (XMLStreamException ex) {
            System.out.println(Constants.XMLEXC.getValue() + nomFichier);
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(Constants.IOEXC.getValue() + nomFichier);
            System.out.println(ex.getMessage());
        } catch (Exception e) {
            System.out.println(("Impossible de trouver le code d'acte = " + donneesCourantes));
        }

        return dossierCourant;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public List<String> repertoire() {
        String donneesCourantes = "";
        List<String> repertoire = null;
        //setNomFichier("listeMedecin.xml");
        try {
            InputStream in = new FileInputStream(Constants.REB_BASE.getValue() + nomFichier);
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader parser = factory.createXMLStreamReader(in);

            for (int event = parser.next(); event != XMLStreamConstants.END_DOCUMENT; event = parser.next()) {
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if (parser.getLocalName().equals("dossier")) {
                            repertoire = new ArrayList<String>();
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if (parser.getLocalName().equals("nom")) {
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
            System.out.println(Constants.XMLEXC.getValue() + nomFichier);
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(Constants.IOEXC.getValue() + nomFichier);
            System.out.println(ex.getMessage());
        }
        return repertoire;
    }

    public List<String> repertoire2() {
        String donneesCourantes = "";
        List<String> repertoire = null;
        //setNomFichier("authentifications.xml");
        try {
            InputStream in = new FileInputStream(Constants.REB_BASE.getValue() + nomFichier);
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
            System.out.println(Constants.XMLEXC.getValue() + nomFichier);
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(Constants.IOEXC.getValue() + nomFichier);
            System.out.println(ex.getMessage());
        }
        return repertoire;
    }

    public ListeMedecin getListeMedecin() {
        ListeMedecin listeMedecinCourant = new ListeMedecin();
        Medecin medecinCourant = null;
        String donneesCourantes = "";
        String nomCourant = "";
        String prenomCourant = "";
        String mdpCourant = "";
        String specialiteCourante = "";
        String numTel = "";
        // analyser le fichier par StAX
        try {
            // instanciation du parser
            InputStream in = new FileInputStream(Constants.REB_BASE.getValue() + nomFichier1);
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader parser = factory.createXMLStreamReader(in);

            // lecture des evenements
            for (int event = parser.next(); event != XMLStreamConstants.END_DOCUMENT; event = parser.next()) {
                // traitement selon l'evenement
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if (parser.getLocalName().equals("dossiers")) {
                            break;
                        }
                    case XMLStreamConstants.END_ELEMENT:
                        if (parser.getLocalName().equals("medecin")) {
                            listeMedecinCourant.ajouterMedecin(new Medecin(nomCourant, prenomCourant, specialiteCourante, numTel, mdpCourant));
                        }
                        if (parser.getLocalName().equals("nom")) {
                            nomCourant = donneesCourantes;
                        }
                        if (parser.getLocalName().equals("prenom")) {
                            prenomCourant = donneesCourantes;
                        }
                        if (parser.getLocalName().equals("specialite")) {
                            specialiteCourante = donneesCourantes;
                        }
                        if (parser.getLocalName().equals("numeroTelephone")) {
                            numTel = donneesCourantes;
                        }
                        if (parser.getLocalName().equals("mdp")) {
                            mdpCourant = donneesCourantes;
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        donneesCourantes = parser.getText();
                        break;
                } // end switch
            } // end while
            parser.close();
            in.close();
        } catch (XMLStreamException ex) {
            System.out.println(Constants.XMLEXC.getValue() + nomFichier);
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(Constants.IOEXC.getValue() + nomFichier);
            System.out.println(ex.getMessage());
        }

        return listeMedecinCourant;
    }

    public ListePatient getListePatient() {
        ListePatient listePatientCourant = new ListePatient();
        Patient patientCourant = null;
        String donneesCourantes = "";
        String nomCourant = "";
        String prenomCourant = "";
        Date dateCourante = null;
        String numSecu = "";
        String adresseCourant = "";
        // analyser le fichier par StAX
        try {
            // instanciation du parser
            InputStream in = new FileInputStream(Constants.REB_BASE.getValue() + nomFichier);
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader parser = factory.createXMLStreamReader(in);

            // lecture des evenements
            for (int event = parser.next(); event != XMLStreamConstants.END_DOCUMENT; event = parser.next()) {
                // traitement selon l'evenement
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if (parser.getLocalName().equals("dossiers")) {
                            break;
                        }
                    case XMLStreamConstants.END_ELEMENT:
                        if (parser.getLocalName().equals("patient")) {
                            listePatientCourant.ajouterPatient(new Patient(nomCourant, prenomCourant, adresseCourant, numSecu, dateCourante));
                        }
                        if (parser.getLocalName().equals("nom")) {
                            nomCourant = donneesCourantes;
                        }
                        if (parser.getLocalName().equals("prenom")) {
                            prenomCourant = donneesCourantes;
                        }
                        if (parser.getLocalName().equals("numeroSecurite")) {
                            numSecu = donneesCourantes;
                        }
                        if (parser.getLocalName().equals("dateNaissance")) {
                            int annee = Integer.parseInt(donneesCourantes.substring(0, donneesCourantes.indexOf('-')));
                            int mois = Integer.parseInt(donneesCourantes.substring(donneesCourantes.indexOf('-') + 1, donneesCourantes.lastIndexOf('-')));
                            int jour = Integer.parseInt(donneesCourantes.substring(donneesCourantes.lastIndexOf('-') + 1, donneesCourantes.length()));

                            dateCourante = new Date(jour, mois, annee);
                        }
                        if (parser.getLocalName().equals("adresse")) {
                            adresseCourant = donneesCourantes;
                        }

                        break;
                    case XMLStreamConstants.CHARACTERS:
                        donneesCourantes = parser.getText();
                        break;
                } // end switch
            } // end while
            parser.close();
            in.close();

        } catch (XMLStreamException ex) {
            System.out.println(Constants.XMLEXC.getValue() + nomFichier);
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(Constants.IOEXC.getValue() + nomFichier);
            System.out.println(ex.getMessage());
        }

        return listePatientCourant;
    }
}
