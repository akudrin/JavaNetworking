package com.akudrin.p2pnetworks;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA2 {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		String originalString = "password";
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] encodedhash = digest.digest(
		  originalString.getBytes(StandardCharsets.UTF_8));
		String sha_256hex = bytesToHex(encodedhash);
		System.out.println("Hex format : " + sha_256hex);
	}
	
	private static String bytesToHex(byte[] hash) {
	    StringBuffer hexString = new StringBuffer();
	    for (int i = 0; i < hash.length; i++) {
	    String hex = Integer.toHexString(0xff & hash[i]);
	    if(hex.length() == 1) hexString.append('0');
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}

}
