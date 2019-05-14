package com.epita.tests;


import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FileXMLDAOMain {
	
	private static final String XML_FILE = "data.xml";
	
	public static void main(String[] args) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
			Document document = documentBuilder.parse(new File(XML_FILE));
			Element rootElement = document.getDocumentElement();
			NodeList listOfNames = document.getElementsByTagName("name");
			for (int i=0; i<listOfNames.getLength(); i++) {
				Element element = (Element ) listOfNames.item(i);
				System.out.println(element.getTextContent());
			}

		} catch (SAXException | IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException pce) {
			
		}
		
		
	}

}
