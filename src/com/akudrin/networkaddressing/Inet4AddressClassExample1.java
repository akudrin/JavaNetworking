package com.akudrin.networkaddressing;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Inet4AddressClassExample1 {

	public static void main(String[] args) throws UnknownHostException {
		Inet4Address address;
		address = (Inet4Address) InetAddress.getByName("www.google.com");
		address = (Inet4Address) Inet4Address.getByName("www.google.com");

		address = (Inet4Address) Inet4Address.getByName("0.0.0.0");
		System.out.println(address.isAnyLocalAddress());
		address = (Inet4Address) Inet4Address.getByName("127.0.0.1");
		System.out.println(address.isLoopbackAddress());

		byte buffer[] = address.getAddress();
		if (buffer.length <= 4) {
			System.out.println("IPv4 Address");
		} else {
			System.out.println("IPv6 Address");
		}
		if (address instanceof Inet4Address) {
			System.out.println("IPv4 Address");
		} else {
			System.out.println("IPv6 Address");
		}

		try {
			InetAddress names[] = InetAddress.getAllByName("www.google.com");
			for (InetAddress addressName : names) {
				if ((addressName instanceof Inet6Address) && ((Inet6Address) addressName).isIPv4CompatibleAddress()) {
					System.out.println(addressName + " is IPv4 Compatible Address");
				} else {
					System.out.println(addressName + " is not a IPv4 Compatible Address");
				}
			}
		} catch (UnknownHostException ex) {
			// Handle exceptions
		}

		// Java 8 code

		InetAddress names[] = InetAddress.getAllByName("www.google.com");
		Arrays.stream(names).map(addressName -> {
			if ((addressName instanceof Inet6Address) && ((Inet6Address) addressName).isIPv4CompatibleAddress()) {
				return addressName + " is IPv4 Compatible Address";
			} else {
				return addressName + " is not IPv4 Compatible Address";
			}
		}).forEach(result -> System.out.println(result));
	}

}
