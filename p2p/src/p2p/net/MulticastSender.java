/*
 * Author      : Hongyi Zhang
 * Version     : 1.0
 * Copyright   : All rights reserved. Do not distribute. 
 * You are welcomed to modify the code.
 * But any commercial use you need to contact me
 */
package p2p.net;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
/**
 *
 * @author Hongyi Zhang
 */
public class MulticastSender extends Thread{
    MulticastSocket socket;
    InetAddress address;
    int port;
    String message;

    public MulticastSender(MulticastSocket socket , InetAddress address, int port, String message){
        this.socket = socket;
        this.address = address;
        this.port = port;
        this.message = message;
    }
    @Override
    public void run(){
        try {
            
            String info = message;

            byte[] output = info.getBytes();

            //System.out.println("Send："+info);
            socket.send(new DatagramPacket(output,output.length,address,port));
            //All the data should contain the address and the port since there is no connection.
            
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
    

