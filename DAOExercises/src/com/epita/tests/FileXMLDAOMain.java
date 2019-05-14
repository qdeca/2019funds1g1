package com.epita.tests;


import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FileXMLDAOMain {
	
	private static final String XML_FILE = "data.xml";
	
	
	
	public static void main(String[] args) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); // fetch a factory
			DocumentBuilder documentBuilder = dbf.newDocumentBuilder();   // create a document builder from the factory
			Document document = documentBuilder.parse(new File(XML_FILE)); // parse the given file into the Document object
			Element rootElement = document.getDocumentElement();   // get root Element of xml file
			NodeList listOfNames = document.getElementsByTagName("name"); // get all elements of the "name" tagname
			for (int i=0; i<listOfNames.getLength(); i++) { // loop on them
				Element element = (Element ) listOfNames.item(i);
				System.out.println(element.getTextContent()); // display their content
			}
			
			NodeList listUser= rootElement.getElementsByTagName("user");   //get all elements of the "user" tagname
			for (int i=0; i<listUser.getLength(); i++) {		// loop on them
				Element user = (Element) listUser.item(i); 
				System.out.println(user.getAttribute("id")); 	// display their attributes id
			}
			
			Element newUser = document.createElement("user");    // create a new element named user
			newUser.setAttribute("id", "83");					// give him an id attribute
			Element newName = document.createElement("name");	 // create a new element named name
			newName.setTextContent("Robert");					// give him text content
			newUser.appendChild(newName);						// place the new name element under the user
			rootElement.appendChild(newUser);					// place the new user under the root element
			
			try {
				TransformerFactory tf = TransformerFactory.newInstance(); 
				Transformer transformer = tf.newTransformer();
				transformer.transform(new DOMSource(document), new StreamResult(XML_FILE)); // updates the xml file
																				// according to the document java object
			} catch (TransformerException e) {
				e.printStackTrace();
			}

		} catch (SAXException | IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException pce) {
			
		}	

		
		
	}

}
