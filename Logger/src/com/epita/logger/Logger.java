package com.epita.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
	
	

	public static void log(String message, LoggingLevel logLevel) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(DateFormatting.LOGGING_FORMAT);
		switch (logLevel) {
		case DEBUG : 
			System.out.println(sdf.format(date) + " - DEBUG - " + message);
			break;
		case INFO : 
			System.out.println(sdf.format(date) + "INFO - " + message);
			break;
		case WARNING : 
			System.out.println(sdf.format(date) + "WARNING - " + message);
			break;
		case ERROR : 
			System.out.println(sdf.format(date) + "ERROR - " + message);
			break;
		case FATAL : 
			System.out.println(sdf.format(date) + "FATAL - " + message);
			break;
		
		
		}

	}
}
