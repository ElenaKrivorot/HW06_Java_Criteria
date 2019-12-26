package by.tc.task01.dao;

public class DAOException extends Exception{
	
	private static final long serialVersionUID = -2731743801846833535L;

	public DAOException(String message) {
		super(message);		
	}

	public DAOException(Throwable cause) {
		super(cause);		
	}

}
