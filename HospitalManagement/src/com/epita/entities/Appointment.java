package com.epita.entities;

import java.util.Date;
import java.util.List;

public abstract class Appointment {

	private Date appointmentDate;
	
	private Patient patient;
	
	private Doctor doctor;

	public Appointment(Date date, Patient patient, Doctor doctor) {
		this.setAppointmentDate(date);
		this.setPatient(patient);
		this.setDoctor(doctor);
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

}
