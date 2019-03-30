package com.akudrin.networkaddressing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionClass {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://akudrin.github.io/");
			URLConnection urlConnection = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
		} catch (IOException ex) {
			// Handle exceptions
		}
	}
}
