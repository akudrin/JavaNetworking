package com.akudrin.networkaddressing;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Enumeration;

public class NetworkInterfaceExample2 {
	public static void main(String[] args) throws IOException {

		Enumeration<NetworkInterface> interfaceEnum;
		try {
			interfaceEnum = NetworkInterface.getNetworkInterfaces();
			System.out.printf("Name Display name\n");
			for (NetworkInterface element : Collections.list(interfaceEnum)) {
				System.out.printf("%-8s %-32s\n", element.getName(), element.getDisplayName());
				Enumeration<InetAddress> addresses = element.getInetAddresses();
				/*
				 * for (InetAddress inetAddress : Collections.list(addresses)) {
				 * System.out.printf(" InetAddress: %s\n", inetAddress); }
				 */
				// Java 8 style
				addresses = element.getInetAddresses();
				Collections.list(addresses).stream().forEach((inetAddress) -> {
					System.out.printf(" InetAddress: %s\n", inetAddress);
				});
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		InetAddress address = InetAddress.getLocalHost();
		System.out.println("IP address: " + address.getHostAddress());
		NetworkInterface network = NetworkInterface.getByInetAddress(address);
		System.out.println("MAC address: " + getMACIdentifier(network));

	}

	public static String getMACIdentifier(NetworkInterface network) {
		StringBuilder identifier = new StringBuilder();
		try {
			byte[] macBuffer = network.getHardwareAddress();
			if (macBuffer != null) {
				for (int i = 0; i < macBuffer.length; i++) {
					identifier.append(String.format("%02X%s", macBuffer[i], (i < macBuffer.length - 1) ? "-" : ""));
				}
			} else {
				return "---";
			}
		} catch (SocketException ex) {
			ex.printStackTrace();
		}
		return identifier.toString();
	}

}
