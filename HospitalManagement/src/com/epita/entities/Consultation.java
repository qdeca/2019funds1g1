package com.epita.entities;

import java.util.Date;

public class Consultation extends Appointment {

	public Consultation(Date date, Patient patient, Doctor doctor) {
		super(date, patient, doctor);
	}

	@Override
	public String toString() {
		return "Consultation [getAppointmentDate()=" + getAppointmentDate() + ", getPatient()=" + getPatient()
				+ ", getDoctor()=" + getDoctor() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
	
	
}
