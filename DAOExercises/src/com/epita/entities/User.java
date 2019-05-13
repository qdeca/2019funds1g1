package com.epita.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {

	private String name;
	
	private double height;
	
	private String adress;
	
	private Date birthdate;
	
	

	public User(String name, double height, String adress, Date birthdate) {
		this.name = name;
		this.height = height;
		this.adress = adress;
		this.birthdate = birthdate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", height=" + height + ", adress=" + adress + ", birthdate=" + new SimpleDateFormat("yyyy/MM/yy").format(birthdate) + "] \n";
	}
	
	
	
}
