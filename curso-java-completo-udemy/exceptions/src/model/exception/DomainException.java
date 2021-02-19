package model.exception;

public class DomainException extends RuntimeException {

	/**
	 * declara��o default de classe serializable
	 */
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {
		super(msg);
	}
}
