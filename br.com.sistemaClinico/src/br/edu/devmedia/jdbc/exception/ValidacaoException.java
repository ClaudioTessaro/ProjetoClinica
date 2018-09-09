package br.edu.devmedia.jdbc.exception;

public class ValidacaoException extends Exception {

	private static final long serialVersionUID = -8796457926599751430L;

	public ValidacaoException(String msg, Exception exception) {
		super(msg, exception);
	}

	public ValidacaoException(String msg) {
		super(msg);
	}

}
