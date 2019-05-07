package com.epita.main;

import java.time.LocalDate;
import java.util.Date;

import com.epita.entities.Consultation;
import com.epita.entities.Doctor;
import com.epita.entities.Patient;

public class Main {
	
	public static void main(String[] args) {
		Patient patient = new Patient();
		Doctor doctor = new Doctor();
		Date date = new Date();
		Consultation consultation = new Consultation(date, patient, doctor);
		System.out.println(consultation);
	}

}
