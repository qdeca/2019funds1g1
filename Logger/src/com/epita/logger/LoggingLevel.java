package com.epita.logger;

public enum LoggingLevel {
	DEBUG(0, "Debug"),
	INFO(1, "Info"),
	WARNING(2, "Warning"),
	ERROR(3, "Error"),
	FATAL(4, "Fatal");
	
	private LoggingLevel(int severity, String value) {
		
	}
}


