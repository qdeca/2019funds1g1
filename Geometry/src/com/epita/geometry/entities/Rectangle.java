package com.epita.geometry.entities;


public class Rectangle implements Shape{
	
	private double height;
	
	private double length;
	
	

	public Rectangle(double height, double length) {
		this.height = height;
		this.length = length;
	}

	public double getPerimeter() {
		return 2* height + 2* length;
	}

	public double getArea() {
		return height * length;
	}
	
}
