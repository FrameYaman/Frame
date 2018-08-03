package br.com.report.exception;

/**
 * 
 * Name: {@link ReportException}
 * 
 * Prop?sito: Exception
 * 
 * @see RuntimeException
 * 
 * @version 1.0
 *
 */
public class ReportException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor
	 * @param msg
	 */
	public ReportException(String msg) {
		super(msg);
	}
	
	/**
	 * Construtor
	 * @param e
	 */
	public ReportException(Exception e) {
		super(e);
	}
	
	/**
	 * Construtor
	 * @param msg
	 * @param e
	 */
	public ReportException(String msg, Exception e) {
		super(msg, e);
	}

}
