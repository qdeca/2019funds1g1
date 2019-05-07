package com.epita.entities;

import java.util.Date;
import java.util.List;

public class Intervention extends Appointment {

	private List<Nurse> nurses;
	
	public Intervention(Date date, Patient patient, Doctor doctor, List<Nurse> nurses) {
		super(date, patient, doctor);
		this.setNurses(nurses);
	}

	public List<Nurse> getNurses() {
		return nurses;
	}

	public void setNurses(List<Nurse> nurses) {
		this.nurses = nurses;
	}

}
