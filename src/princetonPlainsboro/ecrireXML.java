package princetonPlainsboro;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
import java.util.Map;

public class EcrireXML {


    public static void saveToXML(Map<String, String> toSave) {

        Document dom;
        Element e;

        // instance of a DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            // use factory to get an instance of document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            // create instance of DOM
            dom = db.parse(new File("src/donnees/dossiers2.xml"));
            // create the root element
            Element rootEle = dom.createElement(toSave.get(null));
            toSave.remove(null);

            // create data elements and place them under root
            for (Map.Entry<String, String> entry : toSave.entrySet()) {
                e = dom.createElement(entry.getKey());
                e.appendChild(dom.createTextNode(entry.getValue()));
                rootEle.appendChild(e);
            }
            //dom.appendChild(rootEle);
            //Element element = dom.getElementById("dossier");
            dom.getFirstChild().appendChild(rootEle);

            try {
                Transformer tr = TransformerFactory.newInstance().newTransformer();
                tr.setOutputProperty(OutputKeys.INDENT, "yes");
                tr.setOutputProperty(OutputKeys.METHOD, "xml");
                tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

                // send DOM to file
                tr.transform(new DOMSource(dom),
                        new StreamResult(new File("src/donnees/dossiers2.xml")));

            } catch (TransformerException te) {
                System.out.println(te.getMessage());
            } catch (Exception ioe) {
                System.out.println(ioe.getMessage());
            }
        } catch (Exception pce) {
            System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
        }
    }

    public static void saveFicheDeSoinToXML(Date date, Medecin medecin, Patient patient, List<Acte> actes) {
        Document dom;
        Element e;

        // instance of a DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            // use factory to get an instance of document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            // create instance of DOM
            dom = db.parse(new File("src/donnees/dossiers2.xml"));
            // create the root element
            Element rootEle = dom.createElement("ficheDeSoins");

            if(date != null){
                e = dom.createElement("date");
                e.appendChild(dom.createTextNode(date.toXML()));
                rootEle.appendChild(e);
            }
            if(medecin != null){
                Element med = dom.createElement("medecin");
                e = dom.createElement("nom");
                e.appendChild(dom.createTextNode(medecin.getNom()));
                med.appendChild(e);
                e = dom.createElement("prenom");
                e.appendChild(dom.createTextNode(medecin.getPrenom()));
                med.appendChild(e);
                e = dom.createElement("specialite");
                e.appendChild(dom.createTextNode(medecin.getSpecialite()));
                med.appendChild(e);
                rootEle.appendChild(med);
            }
            if(patient != null){
                Element pat = dom.createElement("patient");
                e = dom.createElement("nom");
                e.appendChild(dom.createTextNode(patient.getNom()));
                pat.appendChild(e);
                e = dom.createElement("prenom");
                e.appendChild(dom.createTextNode(patient.getPrenom()));
                pat.appendChild(e);
                rootEle.appendChild(pat);
            }

            if(actes != null){
                for(Acte acte : actes){
                    Element ac = dom.createElement("acte");
                    e = dom.createElement("code");
                    e.appendChild(dom.createTextNode(acte.getCode().getLibelle()));
                    ac.appendChild(e);
                    e = dom.createElement("coef");
                    e.appendChild(dom.createTextNode("" + acte.getCoef()));
                    ac.appendChild(e);
                    rootEle.appendChild(ac);
                }
            }
            dom.getFirstChild().appendChild(rootEle);

            try {
                Transformer tr = TransformerFactory.newInstance().newTransformer();
                tr.setOutputProperty(OutputKeys.INDENT, "yes");
                tr.setOutputProperty(OutputKeys.METHOD, "xml");
                tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

                // send DOM to file
                tr.transform(new DOMSource(dom),
                        new StreamResult(new File("src/donnees/dossiers2.xml")));

            } catch (TransformerException te) {
                System.out.println(te.getMessage());
            } catch (Exception ioe) {
                System.out.println(ioe.getMessage());
            }
        } catch (Exception pce) {
            System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
        }
    }
}
