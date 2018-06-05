package princetonPlainsboro;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class EcrireXML {


    public static void saveToXML(String path, String type, Object obj) {

        Document dom;
        Element e;

        // instance of a DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            // use factory to get an instance of document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            // create instance of DOM
            dom = db.parse(new File(path));
            // create the root element
            Element root = dom.createElement(type);

            // create data elements and place them under root
            if (obj instanceof Medecin) {
                addMedecin(dom, root, (Medecin) obj);
            }
            if (obj instanceof Patient) {
                addPatient(dom, root, (Patient) obj);
            }

            dom.getFirstChild().appendChild(root);
            addToXML(dom, path);

        } catch (Exception pce) {
            System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
        }
    }

    public static void saveFicheDeSoinToXML(String path, Date date, Medecin medecin, Patient patient, List<Acte> actes) {
        Document dom;
        Element e;

        // instance of a DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            // use factory to get an instance of document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            // create instance of DOM
            dom = db.parse(new File(path));
            // create the root element
            Element root = dom.createElement("ficheDeSoins");

            addDate(dom, root, date);
            addMedecin(dom, root, medecin);
            addPatient(dom, root, patient);
            addActes(dom, root, actes);

            dom.getFirstChild().appendChild(root);

            addToXML(dom, path);

        } catch (Exception pce) {
            System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
        }
    }

    private static void addToXML(Node dom, String path) {
        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            tr.setOutputProperty(OutputKeys.METHOD, "xml");
            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            tr.transform(new DOMSource(dom),
                    new StreamResult(new File(path)));

        } catch (TransformerException te) {
            System.out.println(te.getMessage());
        } catch (Exception ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    private static void addDate(Document dom, Node root, Date date) {
        if (date != null) {
            Element e = dom.createElement("date");
            e.appendChild(dom.createTextNode(date.toXML()));
            root.appendChild(e);
        }
    }

    private static void addMedecin(Document dom, Node root, Medecin medecin) {
        if (medecin != null) {
            Element med = dom.createElement("medecin");
            Element e = dom.createElement("nom");
            e.appendChild(dom.createTextNode(medecin.getNom()));
            med.appendChild(e);
            e = dom.createElement("prenom");
            e.appendChild(dom.createTextNode(medecin.getPrenom()));
            med.appendChild(e);
            e = dom.createElement("specialite");
            e.appendChild(dom.createTextNode(medecin.getSpecialite()));
            med.appendChild(e);
            e = dom.createElement("numeroTelephone");
            e.appendChild(dom.createTextNode(medecin.getNumeroTel()));
            med.appendChild(e);
            e = dom.createElement("mdp");
            e.appendChild(dom.createTextNode(medecin.getMdp()));
            med.appendChild(e);

            root.appendChild(med);
        }
    }

    private static void addPatient(Document dom, Node root, Patient patient) {
        if (patient != null) {
            Element pat = dom.createElement("patient");
            Element e = dom.createElement("nom");
            e.appendChild(dom.createTextNode(patient.getNom()));
            pat.appendChild(e);
            e = dom.createElement("prenom");
            e.appendChild(dom.createTextNode(patient.getPrenom()));
            pat.appendChild(e);
            e = dom.createElement("numeroSecuriteSociale");
            e.appendChild(dom.createTextNode(patient.getNumSecu()));
            pat.appendChild(e);
            e = dom.createElement("Adresse");
            e.appendChild(dom.createTextNode(patient.getAdresse()));
            pat.appendChild(e);
            root.appendChild(pat);
        }
    }

    private static void addActes(Document dom, Node root, List<Acte> actes) {
        if (actes != null) {
            for (Acte acte : actes) {
                Element ac = dom.createElement("acte");
                Element e = dom.createElement("code");
                e.appendChild(dom.createTextNode(acte.getCode().getLibelle()));
                ac.appendChild(e);
                e = dom.createElement("coef");
                e.appendChild(dom.createTextNode("" + acte.getCoef()));
                ac.appendChild(e);
                root.appendChild(ac);
            }
        }
    }
}