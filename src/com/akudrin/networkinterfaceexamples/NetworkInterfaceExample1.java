/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akudrin.networkinterfaceexamples;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

/**
 *
 * @author andreikudrin
 */
public class NetworkInterfaceExample1 {

    public static void main(String[] args) throws SocketException {
        try {
            Enumeration<NetworkInterface> interfaceEnum = NetworkInterface.getNetworkInterfaces();
            System.out.printf("Name Display name\n");
            for (NetworkInterface element : Collections.list(interfaceEnum)) {
                System.out.printf("%-8s %-32s\n",
                        element.getName(), element.getDisplayName());
            }
        } catch (SocketException ex) {
            // Handle exceptions
        }

        Enumeration<NetworkInterface> interfaceEnum
                = NetworkInterface.getNetworkInterfaces();
        System.out.printf("Name Display name\n");
        for (NetworkInterface element
                : Collections.list(interfaceEnum)) {
            System.out.printf("%-8s %-32s\n",
                    element.getName(), element.getDisplayName());
            Enumeration<InetAddress> addresses
                    = element.getInetAddresses();
            for (InetAddress inetAddress
                    : Collections.list(addresses)) {
                System.out.printf(" InetAddress: %s\n",
                        inetAddress);
            }
            //using Java 8 syntax
            addresses = element.getInetAddresses();
            Collections
                    .list(addresses)
                    .stream()
                    .forEach((inetAddress) -> {
                        System.out.printf(" InetAddress: %s\n",
                                inetAddress);
                    });

        }
    }
}
