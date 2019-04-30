package com.epita.main;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LoopMain {

	
	public void tutorial() {
		String[] seasons =  new String[4];
		seasons[0] = "spring";
		seasons[1] = "summer";
		seasons[2] = "autumn";
		seasons[3] = "winter";
		
		for (int i=0; i<seasons.length; i++) {
			String season = seasons[i];
			System.out.println(season);
		}
			
		List<String> seasonList = new ArrayList<>();
		// ordered collection, allows duplicates
		Set<String> seasonSet = new HashSet<>();
		// not ordered collection (by default, can implement ordering)
		// doesn't allow duplicates
		
		seasonList.add("spring");
		seasonList.add("summer");
		seasonList.add("autumn");
		seasonList.add("winter");

		for (String season : seasonList) {
			System.out.println(season);
		}
		
		
		Map<Integer, String> seasonMap = new HashMap<>();
		// maps a key to value
		// keys are unique
		// use the method get to fetch the value associated to the key
		
		seasonMap.put(1, "spring");
		seasonMap.get(1);
	}
	
	public static void main(String[] args) {
		
		
		
	}
	
	public int factorial(int number) {
		// implement
	}
	public int secondFactorial(int number) {
		// implement
	}
	public int thirdFactorial(int number) {
		// implement
	}
	
	
}
