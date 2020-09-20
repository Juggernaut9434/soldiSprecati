// InvalidLogicException.java
// An Exception for any invalid logic with customized message

package exceptions;

public class InvalidLogicException extends Exception {
	/**
	 * A IDE requested variable
	 */
	private static final long serialVersionUID = 1L;

	// constructor that utilizes super()
	public InvalidLogicException(String errorMessage)
	{
		super(errorMessage);
	}
	
	public InvalidLogicException(String errorMessage, Throwable err)
	{
		super(errorMessage, err);
	}
}
