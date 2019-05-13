package com.epita.tests;

import com.epita.dao.FileDAO;

public class FileDAOMain {
	
	
	public static void main(String[] args) {
		
		FileDAO fileDAO = new FileDAO();
		fileDAO.searchUserByName("Test");
	}

}
