package io.app.Exceptions;

public class NotFoundException extends RuntimeException {
	public NotFoundException(String messege) {
		super(messege);
	}
}
