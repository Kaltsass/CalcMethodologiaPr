/*
package com.mkyong.xml.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
public class xmlWriter2 {

    public static void main(String[] args)
        throws ParserConfigurationException,TransformerException{

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("mathematical_equation");
            doc.appendChild(rootElement);

            doc.createElement("Number_one");
            rootElement.appendChild(doc.createTextNode(String.valueOf("n1")));
            //rootElement.appendChild(doc.createElement("n1"));

            doc.createElement("Operator");
            //rootElement.appendChild(doc.createElement("oper"));
            rootElement.appendChild(doc.createTextNode(String.valueOf('+')));

            doc.createElement("Number_two");
            rootElement.appendChild(doc.createTextNode(String.valueOf("n2        ")));

            doc.createElement("Result");
            rootElement.appendChild(doc.createTextNode(String.valueOf("n1 Operator n2 =")));

            //rootElement.appendChild(doc.createTextNode()
           try (FileOutputStream output= new FileOutputStream("C:\\Users\\lange\\IdeaProjects\\tests\\Calculator\\src\\myFile.xml")){
               writeXml(doc,output);
           } catch (IOException e){
               e.printStackTrace();
           }


    }
    private static void writeXml(Document doc, OutputStream output)throws TransformerException{

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);

        transformer.transform(source,result);
    }
}


*/

