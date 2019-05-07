package com.epita.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Box<T> {   // Class using genericity with T class

	private T t;
	
	public Box(T t)  {
		this.t= t;
	}
	
	public void displayWithFormatting() {
		if (t instanceof String) {
			System.out.println(t);
		} else if (t instanceof Date) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println(sdf.format(t));
		} // ... and so on
	}
}
