package com.epita.quizmanager.entities;

import java.util.List;

//CREATE TABLE QUESTION (ID IDENTITY PRIMARY KEY, QUESTION VARCHAR(255))
public class Question {
	private String question;
	
	private int difficulty;
	
	private List<Topic> topics;
	
}
