package com.epita.main;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
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
		
		List<Integer> integerList = new LinkedList<>();
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
		System.out.println(factorial(5));
		System.out.println(secondFactorial(5));
		System.out.println(thirdFactorial(5));
		System.out.println(fourthFactorial(5));
		
		
	}
	
	public static int factorial(int number) { // while loop
		if (number == 0 || number == 1) return 1;

		int result = number;
		while(number > 1) {
			number--;
			result *= number;
		}
		return result;
	}
	public static int secondFactorial(int number) { // do while loop
		if (number == 0 || number == 1) return 1;
		int result = number;
		do {
			number--;
			result *= number;
		} while (number > 1);
		
		return result;
	}
	public static int thirdFactorial(int number) { // for loop
		if (number == 0 || number == 1) return 1;
		int result = 1;
		for (int i= number; i> 1;i--) {
			result *= i;
		}
		return result;
	}
	public static int fourthFactorial(int number) { // recursive method
		if (number == 0 || number == 1) {
			return 1;
		} else {
			return (number * fourthFactorial(number-1)); // we call our method 
													// but change the parameter each time
		}
	}
	
}
