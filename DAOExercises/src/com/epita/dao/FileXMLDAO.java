package com.epita.dao;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.epita.entities.User;

public class FileXMLDAO {
	
	public static final String XML_FILE = "data.xml";
	
	public Document initXmlDocument() {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); // fetch a factory
			DocumentBuilder documentBuilder = dbf.newDocumentBuilder();   // create a document builder from the factory
			Document document = documentBuilder.parse(new File(XML_FILE)); // parse the given file into the Document object
			return document;
		} catch (Exception e) { // BAD PRACTICE 
			e.printStackTrace();
		}
		return null; //BAD PRACTICE
	}
	
	public User searchForUserByName(String name) {
		try {
			Document doc = initXmlDocument();
			NodeList listOfNames = doc.getElementsByTagName("name");
			for (int i=0; i<listOfNames.getLength(); i++) {
				Element nameElement = (Element) listOfNames.item(i);
				if (nameElement.getTextContent().equals(name)) {
					Element userElement = (Element) nameElement.getParentNode();  // get the parent element of the name that matched
					
					// get the height from the user
					Element heightElement = (Element) userElement.getElementsByTagName("height").item(0);
					Double height = Double.valueOf(heightElement.getTextContent()); // dont forget to change types

					
					// get the adress from the user
					Element adressElement = (Element) userElement.getElementsByTagName("adress").item(0);
					String adress = adressElement.getTextContent();
					
					// get the birthdate from the user
					Element birthDateElement = (Element) userElement.getElementsByTagName("birthdate").item(0);
					String birthDateString = birthDateElement.getTextContent();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // format it back to a date
					Date birthDate = sdf.parse(birthDateString);
					
					User user = new User(name, height, adress, birthDate); // recreate the user using all the attributes
					return user;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
