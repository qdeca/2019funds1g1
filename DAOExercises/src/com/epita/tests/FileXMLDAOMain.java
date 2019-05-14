package com.epita.tests;


import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

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

		} catch (SAXException | IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException pce) {
			
		}	

		
	}

}
