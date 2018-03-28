/*
 * Author      : Hongyi Zhang
 * Version     : 1.0
 * Copyright   : All rights reserved. Do not distribute. 
 * You are welcomed to modify the code.
 * But any commercial use you need to contact me
 */
package p2p.controller;

import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import p2p.net.MulticastReceiver;
import p2p.net.MulticastSender;
import p2p.startup.MainProgram;

public class MainProcess {
    
    public static void queryIP(String ipAddr, int port) throws Exception{
        MulticastSocket socket = new MulticastSocket(port);
        InetAddress address = InetAddress.getByName(ipAddr);
        socket.setNetworkInterface(NetworkInterface.getByName("en0"));
        socket.joinGroup(address);
        
        String localStateIP = MainProgram.LOCAL_IP + "+";
        
        new MulticastSender(socket,address,port, localStateIP).start(); //Start a new thread to send the data
        
        new MulticastReceiver(socket).start();
    } 
    
}
