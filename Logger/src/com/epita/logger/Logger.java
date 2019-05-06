package com.epita.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
	
	

	public static void log(String message, LoggingLevel logLevel) {
		Date date = new Date();
		StringBuilder log = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat(DateFormatting.LOGGING_FORMAT);
		log.append(sdf.format(date));
		switch (logLevel) {
		case DEBUG : 
			log.append(" - DEBUG - ");
			break;
		case INFO : 
			log.append(" - INFO - ");
			break;
		case WARNING : 
			log.append(" - WARNING - ");
			break;
		case ERROR : 
			log.append(" - ERROR - ");
			break;
		case FATAL : 
			log.append(" - FATAL - ");
			break;
		
		}
		log.append(message);
		System.out.println(log.toString());
	}
}
