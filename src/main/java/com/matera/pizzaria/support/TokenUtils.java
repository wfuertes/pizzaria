package com.matera.pizzaria.support;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.codec.Hex;

public class TokenUtils {

	private static final String SEPARATOR = ":";
	private static final String DIGEST_ALGORITHM = "SHA-256";
	private static final String MAGIC_KEY = "obfuscate";

	public static String createToken(UserDetails userDetails) {

		long expires = getExpirationTime();

		StringBuilder tokenBuilder = new StringBuilder();
		tokenBuilder.append(userDetails.getUsername());
		tokenBuilder.append(SEPARATOR);
		tokenBuilder.append(expires);
		tokenBuilder.append(SEPARATOR);
		tokenBuilder.append(TokenUtils.computeSignature(userDetails, expires));

		return tokenBuilder.toString();
	}

	private static long getExpirationTime() {
		/* Expires in one hour */
		return System.currentTimeMillis() + 1000L * 60 * 60;
	}

	public static String computeSignature(UserDetails userDetails, long expires) {
		StringBuilder signatureBuilder = new StringBuilder();
		signatureBuilder.append(userDetails.getUsername());
		signatureBuilder.append(SEPARATOR);
		signatureBuilder.append(expires);
		signatureBuilder.append(SEPARATOR);
		signatureBuilder.append(userDetails.getPassword());
		signatureBuilder.append(SEPARATOR);
		signatureBuilder.append(TokenUtils.MAGIC_KEY);

		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance(DIGEST_ALGORITHM);
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException("No " + DIGEST_ALGORITHM
					+ " algorithm available!");
		}

		return new String(Hex.encode(digest.digest(signatureBuilder.toString()
				.getBytes())));
	}

	public static String getUserNameFromToken(String authToken) {
		if (null == authToken) {
			return null;
		}

		String[] parts = authToken.split(SEPARATOR);
		return parts[0];
	}

	public static boolean validateToken(String authToken,
			UserDetails userDetails) {
		String[] parts = authToken.split(SEPARATOR);
		long expires = Long.parseLong(parts[1]);
		String signature = parts[2];

		if (expires < System.currentTimeMillis()) {
			return false;
		}

		return signature.equals(TokenUtils.computeSignature(userDetails,
				expires));
	}

}
