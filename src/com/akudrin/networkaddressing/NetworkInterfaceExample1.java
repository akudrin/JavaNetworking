package com.akudrin.networkaddressing;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

public class NetworkInterfaceExample1 {
	public static void main(String[] args) {
		try {
			Enumeration<NetworkInterface> interfaceEnum = NetworkInterface.getNetworkInterfaces();
			System.out.printf("Name Display name\n");
			for (NetworkInterface element : Collections.list(interfaceEnum)) {
				System.out.printf("%-8s %-32s\n", element.getName(), element.getDisplayName());
			}
		} catch (SocketException ex) {
			// Handle exceptions
		}

	}

}
