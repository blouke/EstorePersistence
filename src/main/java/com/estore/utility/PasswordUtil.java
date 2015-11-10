package com.estore.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

public class PasswordUtil {
	public static String hashPassword(String password){
		try {
			MessageDigest msgDigest;
			msgDigest = MessageDigest.getInstance("SHA-256");
			byte[] rawPasswordHash = msgDigest.digest(password.getBytes());
			String encodedPasswordHash = Base64.getEncoder().encodeToString(rawPasswordHash);
			return encodedPasswordHash;
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}
	
	public static String getSalt(){
		Random r = new SecureRandom();
		byte[] salt = new byte[32];
		r.nextBytes(salt);
		return Base64.getEncoder().encodeToString(salt);
	}
}
