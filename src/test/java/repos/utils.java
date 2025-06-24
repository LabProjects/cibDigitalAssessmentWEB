package repos;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;


// This class will cater for all supportive functions that will drive data-driven
// All methods that one can think of dbreader, dbupdate, excel reader/writter etc....
// Anything that will work without passing the webdriver
public class utils
{
    //The below function read the config file for constant values and easy the maintenance in the long run
    public static String xmlReader(String elementName) throws IOException, SAXException, ParserConfigurationException {
        File file = new File("Config/configPaths.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);
        doc.getDocumentElement().normalize();
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
        NodeList nodeList = doc.getElementsByTagName(elementName);
        String el1 = null;
        for (int itr = 0; itr < nodeList.getLength(); itr++) {
            Node node = nodeList.item(itr);
            System.out.println("\nNode Name :" + node.getNodeName());
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                String el = (eElement.getElementsByTagName("identifier").item(0).getTextContent());
                System.out.println("Identifier: " + el);
                el1 = (eElement.getElementsByTagName("path").item(0).getTextContent());
                System.out.println("Element Path: " + el1);
            }
        }
        return el1;
    }
}
