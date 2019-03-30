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
		System.out.println(address.isReachable(10000));
	}

}
