package logexample;

import org.apache.log4j.Logger;

public class LogExample {

	final static Logger logger = Logger.getLogger(LogExample.class);

	public static void main(String[] args) {

		logger.trace("Trace Message XXXXX!");
		logger.debug("Debug Message YYYYY!");
		logger.info("Info Message!");
		logger.warn("Warn Message!");
		logger.error("Error Message!");
		logger.fatal("Fatal Message!");
		
		try {
			int i=10/0;
		}catch (ArithmeticException exception) {
			logger.error(exception.getMessage());
		}
	}

}
