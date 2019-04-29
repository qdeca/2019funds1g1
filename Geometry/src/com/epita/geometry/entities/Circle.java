package com.epita.geometry.entities;

public class Circle implements Shape {
	
	public static final double PI = Math.PI;
	
	
	public Circle(double radius) {
		this.radius = radius;
	}

	private double radius;
	
	public double getPerimeter() {
		return radius * 2 * PI;
	}
	
	public double getArea() {
		return PI * radius * radius;
	}

}
