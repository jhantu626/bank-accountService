package io.app.Exceptions;

public class InsufficientBalance extends RuntimeException {
	public InsufficientBalance(String insufficientBalance) {
		super(insufficientBalance);
	}
}
