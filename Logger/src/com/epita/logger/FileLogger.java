package com.epita.logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger {

	public void log(String methodName, String message, LoggingLevel logLevel) {
		try {

			Date date = new Date();
			StringBuilder log = new StringBuilder();
			SimpleDateFormat sdf = new SimpleDateFormat(DateFormatting.LOGGING_FORMAT);
			log.append(methodName);
			log.append(" - ");
			log.append(sdf.format(date));
			switch (logLevel) {
			case DEBUG:
				log.append(" - DEBUG - ");
				break;
			case INFO:
				log.append(" - INFO - ");
				break;
			case WARNING:
				log.append(" - WARNING - ");
				break;
			case ERROR:
				log.append(" - ERROR - ");
				break;
			case FATAL:
				log.append(" - FATAL - ");
				break;

			}
			log.append(message);
			log.append(" \n");
			Files.write(Paths.get("app.log"), log.toString().getBytes(), StandardOpenOption.APPEND);
			// other ways : FileWriter
			// and PrintWriter
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
