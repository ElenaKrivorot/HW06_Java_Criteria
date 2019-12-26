package by.tc.task01.service;

public class ServiceException extends Exception {

	private static final long serialVersionUID = -3966886708431706203L;

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

}
