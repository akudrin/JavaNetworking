package com.akudrin.networkaddressing;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressClass {
	public static void main(String[] args) throws UnknownHostException, IOException {
		InetAddress address = InetAddress.getByName("www.bbc.co.uk");
		System.out.println(address);
		System.out.println("CanonicalHostName: " + address.getCanonicalHostName());
		System.out.println("HostAddress: " + address.getHostAddress());
		System.out.println("HostName: " + address.getHostName());
		// System.out.println(address.isReachable(10000));

		InetAddress localAddress = InetAddress.getLocalHost();
		System.out.println("Local Host Name: " + localAddress.getHostName());
		System.out.println("Local Host: " + InetAddress.getLocalHost());
		System.out.println("Local Host Address: " + localAddress.getHostAddress());

		InetAddress names[] = InetAddress.getAllByName("www.google.com");
		for (InetAddress element : names) {
			System.out.println(element);
		}

		String URLAddress = "www.google.com";
		InetAddress[] addresses = InetAddress.getAllByName(URLAddress);
		for (InetAddress inetAddress : addresses) {
			try {
				if (inetAddress.isReachable(10000)) {
					System.out.println(inetAddress + " is reachable");
				} else {
					System.out.println(inetAddress + " is not reachable");
				}
			} catch (IOException ex) {
				// Handle exceptions
			}
		}

	}

}
