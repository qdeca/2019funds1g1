package com.epita.geometry.entities;


public class Rectangle extends Quadrilateral implements Shape{

	

	public Rectangle(double height, double length) {
		super(height, length, height, length);
	}

	
	public double getHeight() {
		return super.getSideA();
		//return super.getSideC();
	}
	
	public void setHeight(double height) {
		super.setSideA(height);
		super.setSideC(height);
	}
	
	public double getLength() {
		return super.getSideB();
		//return super.getSideD();
	}
	
	public void setLength(double length) {
		super.setSideB(length);
		super.setSideD(length);
	}
	
	
	public double getPerimeter() {
		return 2* getHeight() + 2* getLength();
	}

	public double getArea() {
		return getHeight() * getLength();
	}
	
}
