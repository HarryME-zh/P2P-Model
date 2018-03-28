/*
 * Author      : Hongyi Zhang
 * Version     : 1.0
 * Copyright   : All rights reserved. Do not distribute. 
 * You are welcomed to modify the code.
 * But any commercial use you need to contact me
 */
package p2p.view;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.util.*;
import p2p.net.MulticastSender;
import p2p.startup.MainProgram;
/**
 *
 * @author harry
 */
public class CommandInput extends Thread{
    
    @Override
    public void run(){
        while(true){
            Scanner sc = new Scanner(System.in);
            String Input = sc.nextLine();
            if(Input.equals("quit")){
                try{
                MulticastSocket socket = new MulticastSocket(6666);
                InetAddress address = InetAddress.getByName("226.0.0.6");
                socket.setNetworkInterface(NetworkInterface.getByName("en0"));
                socket.joinGroup(address);
        
                String localStateIP = MainProgram.LOCAL_IP + "-";
                new MulticastSender(socket,address,6666, localStateIP).start();
                }catch(Exception e){
                    e.printStackTrace();
                }
                System.exit(0);
            }
        }
    }
    
}
