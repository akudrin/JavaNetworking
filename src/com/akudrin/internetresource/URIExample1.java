package com.akudrin.internetresource;

import java.net.URI;
import java.net.URISyntaxException;

public class URIExample1 {
	public static void main(String[] args) throws URISyntaxException {
		URI uri = new URI("https://en.wikipedia.org/wiki/" + "URL_normalization#Normalization_process");
		displayURI(uri);
	}

	private static void displayURI(URI uri) {
		System.out.println("getAuthority: " + uri.getAuthority());
		System.out.println("getScheme: " + uri.getScheme());
		System.out.println("getSchemeSpecificPart: " + uri.getSchemeSpecificPart());
		System.out.println("getHost: " + uri.getHost());
		System.out.println("getPath: " + uri.getPath());
		System.out.println("getQuery: " + uri.getQuery());
		System.out.println("getFragment: " + uri.getFragment());
		System.out.println("getUserInfo: " + uri.getUserInfo());
		System.out.println("normalize: " + uri.normalize());
	}
}
