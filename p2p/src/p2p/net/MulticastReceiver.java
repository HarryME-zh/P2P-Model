/*
 * Author      : Hongyi Zhang
 * Version     : 1.0
 * Copyright   : All rights reserved. Do not distribute. 
 * You are welcomed to modify the code.
 * But any commercial use you need to contact me
 */
package p2p.net;

import java.awt.Robot;
import java.net.DatagramPacket;
import java.net.MulticastSocket;
import p2p.model.checkProcess;
import p2p.model.hashProcess;
/**
 *
 * @author Hongyi Zhang
 */
public class MulticastReceiver extends Thread{
    
    MulticastSocket socket;

    public MulticastReceiver(MulticastSocket socket){
        this.socket = socket; 
    }

   @Override
    public void run(){
        try {
        byte[] input = new byte[1024]; //Only input 1024 bytes
        DatagramPacket inPacket = new DatagramPacket(input,input.length);

        while (true){
            socket.receive(inPacket);//block at here
            String Receive = new String(input,0,inPacket.getLength());
            if(Receive.contains("#")){
              //  System.out.println("Receive："+ Receive);
                checkProcess.checkAdd(Receive);
            }else if(Receive.contains("+")){
                System.out.println("A node join："+ Receive);
                new Robot().delay(500);  
                hashProcess.uploadTable();
                checkProcess.nodeLatencyCheck(Receive);
            }else if(Receive.contains("-")){
                System.out.println("A node quit："+ Receive);
                checkProcess.nodeQuit(Receive);
            }
        }
    }catch(Exception e){
        e.printStackTrace();
    }
        
}
    
}
