package com.epita.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.epita.entities.Box;
import com.epita.entities.SavingsAccount;

public class TestMain {

	public static void main(String[] args) {
		String test = "test";
		Box<String> randomBox = new Box<>(test);
		randomBox.displayWithFormatting();
		
		List<String> seasons = Arrays.asList("spring", "summer", "autumn", "winter");
		for (String season : seasons) {
			if ("autumn".equals(season)) {
				boolean containsAutumn = true;
			}
		}
		//boolean containsAutumn = seasons.contains("autumn");
		boolean containsAutumn = seasons.stream().anyMatch(s -> "autumn".equals(s));
		seasons.stream().map(s -> s.substring(0, 2));
		
		for (String season : seasons) {
			System.out.println(season);
		}
		seasons.forEach(System.out::println);
		
		

		
		
	}
}
