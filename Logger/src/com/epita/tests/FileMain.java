package com.epita.tests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileMain {

	
	public static void main(String[] args) {
		try {
			List<String> logLines = Files.readAllLines(Paths.get("app.log"));
			// FileReader
			
			for(String line : logLines) {
				System.out.println(line);
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
