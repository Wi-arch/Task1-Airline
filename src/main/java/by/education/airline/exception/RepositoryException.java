package by.education.airline.exception;

public class RepositoryException extends Exception {

	private static final long serialVersionUID = 2787457882671327108L;

	public RepositoryException() {
	}

	public RepositoryException(String message, Throwable cause) {
		super(message, cause);
	}

	public RepositoryException(String message) {
		super(message);
	}

	public RepositoryException(Throwable cause) {
		super(cause);
	}

}
