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
import java.util.Map;

public class ecrireXML {


    public static void saveToXML(Map<String, String> toSave) {

        Document dom;
        Element e = null;

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


}
