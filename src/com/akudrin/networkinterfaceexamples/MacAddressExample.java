/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akudrin.networkinterfaceexamples;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Enumeration;

/**
 *
 * @author andreikudrin
 */
public class MacAddressExample {

    public static void main(String[] args) throws UnknownHostException, SocketException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("IP address: " + address.getHostAddress());
        NetworkInterface network
                = NetworkInterface.getByInetAddress(address);
        System.out.println("MAC address: "
                + getMACIdentifier(network));

        Enumeration<NetworkInterface> interfaceEnum
                = NetworkInterface.getNetworkInterfaces();
        System.out.println("Name MAC Address");
        for (NetworkInterface element
                : Collections.list(interfaceEnum)) {
            System.out.printf("%-6s %s\n",
                    element.getName(), getMACIdentifier(element));
        }
        //using Java 8 syntax
        interfaceEnum = NetworkInterface.getNetworkInterfaces();
        Collections
                .list(interfaceEnum)
                .stream()
                .forEach((inetAddress) -> {
                    System.out.printf("%-6s %s\n",
                            inetAddress.getName(),
                            getMACIdentifier(inetAddress));
                });

    }

    public static String getMACIdentifier(NetworkInterface network) {
        StringBuilder identifier = new StringBuilder();
        try {
            byte[] macBuffer = network.getHardwareAddress();
            if (macBuffer != null) {
                for (int i = 0; i < macBuffer.length; i++) {
                    identifier.append(
                            String.format("%02X%s", macBuffer[i],
                                    (i < macBuffer.length - 1) ? "-" : ""));
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
