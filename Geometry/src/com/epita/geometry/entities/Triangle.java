package com.epita.geometry.entities;

public class Triangle implements Shape {
	
	private double base; // also side A
	
	private double height;
	
	private double sideB;
	
	private double sideC;
	
	
	

	public Triangle(double base, double height, double sideB, double sideC) {
		this.base = base;
		this.height = height;
		this.sideB = sideB;
		this.sideC = sideC;
	}

	public double getPerimeter() {
		return base + sideB + sideC;
	}
	
	public double getArea() {
		return base * height / 2;
	}
	
}
