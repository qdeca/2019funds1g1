package com.epita.geometry.entities;

public interface Shape {

	public double getPerimeter();   // no implementation of the method
									// because the interface will never
									// be instanciated in itself
	
									// forces all classes that implement the interface
									// to implement this method
	public double getArea();
}
