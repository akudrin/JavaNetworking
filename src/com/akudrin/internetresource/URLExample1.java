package com.akudrin.internetresource;

import java.net.MalformedURLException;
import java.net.URL;

public class URLExample1 {
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://www.google.com");
		displayURL(url);
	}

	private static void displayURL(URL url) {
		System.out.println("URL: " + url);
		System.out.printf(" Protocol: %-32s Host: %-32s\n", url.getProtocol(), url.getHost());
		System.out.printf(" Port: %-32d Path: %-32s\n", url.getPort(), url.getPath());
		System.out.printf(" Reference: %-32s File: %-32s\n", url.getRef(), url.getFile());
		System.out.printf(" Authority: %-32s Query: %-32s\n", url.getAuthority(), url.getQuery());
		System.out.println(" User Info: " + url.getUserInfo());
	}

}
