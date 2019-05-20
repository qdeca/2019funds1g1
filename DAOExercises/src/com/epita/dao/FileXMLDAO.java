package com.epita.dao;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.epita.entities.User;

public class FileXMLDAO {

	public static final String XML_FILE = "data.xml";

	public Document initXmlDocument() {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); // fetch a factory
			DocumentBuilder documentBuilder = dbf.newDocumentBuilder(); // create a document builder from the factory
			Document document = documentBuilder.parse(new File(XML_FILE)); // parse the given file into the Document
																			// object
			return document;
		} catch (Exception e) { // BAD PRACTICE
			e.printStackTrace();
		}
		return null; // BAD PRACTICE
	}

	public void transformXmlDocument(Document doc) {
		try {
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
			transformer.transform(new DOMSource(doc), new StreamResult(XML_FILE)); // updates the xml file
			// according to the document java object
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	public void createNewUser(User user) {
		Document doc = initXmlDocument(); // contains all data pertaining to xml file
		Element rootElement = doc.getDocumentElement();

		Element newUserElement = doc.createElement("user"); // create new user element

		Element newNameElement = doc.createElement("name"); // create element for each attribute
		newNameElement.setTextContent(user.getName()); // set value equals to that of the parameter

		Element newHeightElement = doc.createElement("height");
		newHeightElement.setTextContent(String.valueOf(user.getHeight()));

		Element newAdressElement = doc.createElement("adress");
		newAdressElement.setTextContent(user.getAdress());

		Element newBirthDateElement = doc.createElement("birthdate");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		newBirthDateElement.setTextContent(sdf.format(user.getBirthdate()));

		// rearrange elements in xml file : all the attributes under the new user
		// and the new user under the root element
		newUserElement.appendChild(newNameElement);
		newUserElement.appendChild(newHeightElement);
		newUserElement.appendChild(newAdressElement);
		newUserElement.appendChild(newBirthDateElement);
		rootElement.appendChild(newUserElement);

		transformXmlDocument(doc); // invoke a method to update xml file with new java document object

	}

	public User searchForUserByName(String name) {
		try {
			Document doc = initXmlDocument();
			NodeList listOfNames = doc.getElementsByTagName("name");
			for (int i = 0; i < listOfNames.getLength(); i++) {
				Element nameElement = (Element) listOfNames.item(i);
				if (nameElement.getTextContent().equals(name)) {
					Element userElement = (Element) nameElement.getParentNode(); // get the parent element of the name
																					// that matched

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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deleteUser(User user) {
		Document doc = initXmlDocument(); // get all the data of the xml file in the java object
		Element rootElement = doc.getDocumentElement();
		Element elementToRemove;
		NodeList listOfNames = doc.getElementsByTagName("name"); // get all names
		for (int i = 0; i < listOfNames.getLength(); i++) {
			Element nameElement = (Element) listOfNames.item(i);
			if (nameElement.getTextContent().equals(user.getName())) { // see if the name matches the one of the user
				elementToRemove = (Element) nameElement.getParentNode(); // get the parent element of the name that
																			// matched
				rootElement.removeChild(elementToRemove); // remove the user
			}
		}

		transformXmlDocument(doc);
	}

	public void updateUser(User user) {
		Document doc = initXmlDocument();
		NodeList listOfNames = doc.getElementsByTagName("name");
		for (int i = 0; i < listOfNames.getLength(); i++) {
			Element nameElement = (Element) listOfNames.item(i);
			if (nameElement.getTextContent().equals(user.getName())) {
				Element userElement = (Element) nameElement.getParentNode();

				// set the new height from the user
				Element heightElement = (Element) userElement.getElementsByTagName("height").item(0);
				heightElement.setTextContent(String.valueOf(user.getHeight()));

				// set the new adress from the user
				Element adressElement = (Element) userElement.getElementsByTagName("adress").item(0);
				adressElement.setTextContent(user.getAdress());

				// set the new birthdate from the user
				Element birthDateElement = (Element) userElement.getElementsByTagName("birthdate").item(0);
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // format it back to a date
				birthDateElement.setTextContent(sdf.format(user.getBirthdate()));

			}

		}
		transformXmlDocument(doc);
	}

}
