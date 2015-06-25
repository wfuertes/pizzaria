package com.matera.pizzaria.dto;

public class TokenTransferDto {

	private final String token;

	public TokenTransferDto(String token) {
		this.token = token;
	}

	public String getToken() {
		return this.token;
	}

}
