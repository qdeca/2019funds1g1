package com.epita.quizmanager.entities;


// CREATE TABLE TOPIC  (ID IDENTITY PRIMARY KEY, NAME VARCHAR(255), QUESTION_ID INT foreign key (QUESTION_ID) references QUESTION(ID))
public class Topic {

		private Question question; // FOREIGN KEY
		
		private String topicName;
}
