/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akudrin.networkaddressing;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author andreikudrin
 */
public class Inet6AddressClassExample {

    public static void main(String[] args) {

        try {
            InetAddress names[]
                    = InetAddress.getAllByName("www.google.com");
            for (InetAddress address : names) {
                if ((address instanceof Inet6Address)
                        && ((Inet6Address) address)
                                .isIPv4CompatibleAddress()) {
                    System.out.println(address
                            + " is IPv4 Compatible Address");
                } else {
                    System.out.println(address
                            + " is not a IPv4 Compatible Address");
                }
            }
        } catch (UnknownHostException ex) {
        // Handle exceptions
        }
        
    
    
    }
}
