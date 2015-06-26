package com.matera.pizzaria.support;

import java.security.SecureRandom;
import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

public class TokenUtils {

	private static final String SEPARATOR = ":";
	private static final String DIGEST_ALGORITHM = "SHA-256";
//	private static final String MAGIC_KEY = "obfuscate";
	
	public static byte[] sharedSecret;
	
	static {
		// Generate random 256-bit (32-byte) shared secret
		SecureRandom random = new SecureRandom();
		sharedSecret = new byte[64];
		random.nextBytes(sharedSecret);
	}
	
	public static String createJwtToken(UserDetails userDetails){
		Date now = new Date();
        JWTClaimsSet claimsSet = new JWTClaimsSet();
        claimsSet.setSubject(userDetails.getUsername());
        claimsSet.setIssueTime(now);
        claimsSet.setIssuer("my.site.com");
        claimsSet.setExpirationTime(new Date(getExpirationTime()));
        claimsSet.setNotBeforeTime(now);
        return signAndSerializeJWT(claimsSet, sharedSecret);
	}
	
	private static String signAndSerializeJWT(JWTClaimsSet claimsSet, byte[] secret) {
        JWSSigner signer = new MACSigner(secret);
        SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS512), claimsSet);
        try {
            signedJWT.sign(signer);
            return signedJWT.serialize();
        } catch(JOSEException e) {
            e.printStackTrace();
            return null;
        }
    }

//	public static String createToken(UserDetails userDetails) {
//
//		long expires = getExpirationTime();
//
//		StringBuilder tokenBuilder = new StringBuilder();
//		tokenBuilder.append(userDetails.getUsername());
//		tokenBuilder.append(SEPARATOR);
//		tokenBuilder.append(expires);
//		tokenBuilder.append(SEPARATOR);
//		tokenBuilder.append(TokenUtils.computeSignature(userDetails, expires));
//
//		return tokenBuilder.toString();
//	}

	private static long getExpirationTime() {
		/* Expires in one hour */
		return System.currentTimeMillis() + 1000L * 60 * 60;
	}

//	public static String computeSignature(UserDetails userDetails, long expires) {
//		StringBuilder signatureBuilder = new StringBuilder();
//		signatureBuilder.append(userDetails.getUsername());
//		signatureBuilder.append(SEPARATOR);
//		signatureBuilder.append(expires);
//		signatureBuilder.append(SEPARATOR);
//		signatureBuilder.append(userDetails.getPassword());
//		signatureBuilder.append(SEPARATOR);
//		signatureBuilder.append(TokenUtils.MAGIC_KEY);
//
//		MessageDigest digest;
//		try {
//			digest = MessageDigest.getInstance(DIGEST_ALGORITHM);
//		} catch (NoSuchAlgorithmException e) {
//			throw new IllegalStateException("No " + DIGEST_ALGORITHM
//					+ " algorithm available!");
//		}
//
//		return new String(Hex.encode(digest.digest(signatureBuilder.toString()
//				.getBytes())));
//	}

//	public static String getUserNameFromToken(String authToken) {
//		if (null == authToken) {
//			return null;
//		}
//
//		String[] parts = authToken.split(SEPARATOR);
//		return parts[0];
//	}

//	public static boolean validateToken(String authToken,
//			UserDetails userDetails) {
//		String[] parts = authToken.split(SEPARATOR);
//		long expires = Long.parseLong(parts[1]);
//		String signature = parts[2];
//
//		if (expires < System.currentTimeMillis()) {
//			return false;
//		}
//
//		return signature.equals(TokenUtils.computeSignature(userDetails,
//				expires));
//	}

}
