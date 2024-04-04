import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class xmlParser {

    public static void parseXML(String filePath, JTextField textField) {
        System.out.println("Parsing XML file...");
        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            // Get the root element
            Element root = document.getDocumentElement();
            NodeList nodeList = root.getElementsByTagName("Result");

            // Assume there's only one <Result> element
            if (nodeList.getLength() > 0) {
                Element resultElement = (Element) nodeList.item(0);
                String resultValue = resultElement.getTextContent();
                textField.setText(resultValue);
            } else {
                textField.setText("No result found in XML.");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print the exception trace
            textField.setText("Error occurred while parsing XML.");
        }
    }


}
