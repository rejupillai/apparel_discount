package com.socgen.challenge.apparel.exception;

/**
 * @author reju.pillai@gmail.com
 * 
 * Class to handle Generic Exceptions
 *
 */
public class GenericException extends Exception {
	
	public GenericException(String message) {
		super();
		this.message = message;
	}

	/**
	 * 
	 */
	private String message ;

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	} 

}
