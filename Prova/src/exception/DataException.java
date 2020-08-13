package provinha.src.exception;

import java.time.format.DateTimeParseException;

public class DataException extends DateTimeParseException {

	private static int errorIndex;

	public DataException(String message) {
		super(message, message, errorIndex);
		// TODO Auto-generated constructor stub
	}




}
