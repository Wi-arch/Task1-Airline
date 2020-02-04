package by.education.airline.exception;

public class InvalidPlaneValueException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidPlaneValueException() {
	}

	public InvalidPlaneValueException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidPlaneValueException(String message) {
		super(message);
	}

	public InvalidPlaneValueException(Throwable cause) {
		super(cause);
	}

}
