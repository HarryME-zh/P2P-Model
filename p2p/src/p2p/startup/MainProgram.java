/*
 * Author      : Hongyi Zhang
 * Version     : 1.0
 * Copyright   : All rights reserved. Do not distribute. 
 * You are welcomed to modify the code.
 * But any commercial use you need to contact me
 */
package p2p.startup;
import java.awt.Robot;
import p2p.controller.MainProcess;
import java.net.*;
import java.util.ArrayList;
import p2p.model.hashProcess;
import p2p.view.CommandInput;
/**
 *
 * @author Hongyi Zhang
 */
public class MainProgram {    
     static String ipAddr = "226.0.0.6";
     static int port = 6666;
     public static int FILE_PORT = 8888;
     public static String LOCAL_IP;
     public static String P2P_FILEPATH = "/Users/harry/Desktop/p2p";
     public static ArrayList<String> NODE_IP = new ArrayList();
     public static ArrayList<String> RESOURCE_HASH = new ArrayList();
     
     public static void main(String[] args) throws Exception {        
        // TODO code application logic here
        new CommandInput().start();
        LOCAL_IP = InetAddress.getLocalHost().getHostAddress();
        MainProcess.queryIP(ipAddr, port);
        
        new Robot().delay(100);  

        hashProcess.hashTable();
        hashProcess.uploadTable();
        
        
        }
}
