package com.epita.tests;

import java.util.Date;

import com.epita.dao.FileDAO;
import com.epita.entities.User;

public class FileDAOMain {
	
	
	public static void main(String[] args) {
		
		FileDAO fileDAO = new FileDAO();
		
//		fileDAO.createUser(new User("Bob", new Double(1.74), "1 rue de la paix", new Date()));
		User user = new User("Bob", new Double(1.78), "5 rue de la paix", new Date());
//		fileDAO.createUser(user);
//		fileDAO.createUser(new User("Jack", new Double(1.82), "3 rue de la paix", new Date()));
//		fileDAO.createUser(new User("Mary", new Double(1.88), "4 rue de la paix", new Date()));
		
//		fileDAO.deleteUser(user);
		
		fileDAO.updateUser(user);
	}

}
