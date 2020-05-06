package exceptions;

public class DefaultException extends Exception{


	private static final long serialVersionUID = 1L;

	public DefaultException(String mesage) {
		super(mesage);
	}
	
	public DefaultException(String mesage, Throwable cause) {
		super(mesage, cause);
	}
}
