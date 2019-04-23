package com.akudrin.p2pnetworks;

import java.nio.charset.StandardCharsets;

import org.bouncycastle.jcajce.provider.digest.Keccak;
import org.bouncycastle.util.encoders.Hex;

public class SHA3 {
	public static void main(String[] args) {
		String originalString = "password";
		Keccak.Digest256 digest256 = new Keccak.Digest256();
		byte[] hashbytes = digest256.digest(
		  originalString.getBytes(StandardCharsets.UTF_8));
		String sha3_256hex = new String(Hex.encode(hashbytes));
		System.out.println("Hex format : " + sha3_256hex);
	}

}
