package com.epita.geometry.tests;


import java.util.InputMismatchException;
import java.util.Scanner;

import com.epita.geometry.entities.Circle;
import com.epita.geometry.entities.Rectangle;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		try {
			double radius = scanner.nextDouble(); 		
			// take user input to determine the radius
			Circle circle = new Circle(radius); 		
			// create a circle
			double area = circle.getArea();
			System.out.printf("Circle's area : %.2f \n", area);
							// % corresponds to a parameter in the printf
							// argument (here, it's area)
							// .2f means that only 2 numbers after the comma
							// are displayed
			// display area
			System.out.println("Circle's perimeter : " + circle.getPerimeter());
			// display perimeter


			
			double height = scanner.nextDouble();
			double length = scanner.nextDouble();
			Rectangle rectangle = new Rectangle(height, length);
			if  (height == length) {
				System.out.println("This rectangle is a square");
			} else {
				System.out.println("This rectangle is not a square");
			}
			
			
			
		} catch(InputMismatchException e) {
			System.out.println("Please type a valid number");
		} 
		finally {
			scanner.close();
		}

	}
}
