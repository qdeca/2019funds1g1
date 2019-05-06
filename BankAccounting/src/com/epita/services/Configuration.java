package com.epita.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

	private Properties properties;
	
	private static Configuration configuration;
	
	private Configuration() {
		properties = new Properties();
		try {
			InputStream input = new FileInputStream("config.properties");
			properties.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static Configuration getInstance() {
		if (configuration == null) {
			configuration = new Configuration();
		} 
		return configuration;
	}
	
	public String getPropertyValue(String key) {
		return properties.getProperty(key);
	}
	
}
