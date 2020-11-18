package br.com.compasso.studentChallanger.exception;

public class IdNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	private String msg;

	public IdNotFoundException(String msg) {
		super(msg);
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}
}
