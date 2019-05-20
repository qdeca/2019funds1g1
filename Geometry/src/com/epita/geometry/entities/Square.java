package com.epita.geometry.entities;

public class Square extends Rectangle implements Shape {

//	private double side;
	
	public Square(double side) {
		super(side, side); // super is the equivalent of this for the parent class :
							// it refers to the instance of the parent class
		
	}
	
	public double getPerimeter() {
		return 0;
	}



	
	
}
