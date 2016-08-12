package br.com.any.exception;

public class FieldNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FieldNotFoundException(String mensagem) {
		super(mensagem);
	}

	public FieldNotFoundException(Throwable throwable) {
		super(throwable);
	}

	public FieldNotFoundException(String mensagem, Throwable throwable) {
		super(mensagem, throwable);
	}
}
