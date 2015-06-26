package com.matera.pizzaria.exception;

public class TokenExpiredException extends RuntimeException {

	public TokenExpiredException(String string) {
		super(string);
	}

}
