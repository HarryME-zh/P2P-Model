/*
 * Author      : Hongyi Zhang
 * Version     : 1.0
 * Copyright   : All rights reserved. Do not distribute. 
 * You are welcomed to modify the code.
 * But any commercial use you need to contact me
 */
package p2p.model;

import p2p.startup.MainProgram;
import java.awt.*;
/**
 *
 * @author Hongyi Zhang
 */
public class checkProcess {
    
    public static void checkAdd(String Receive){
        boolean jgFLG = true;
        String rcvData = getCTX(Receive+")","#",")");
        for (int i = 0; i < MainProgram.RESOURCE_HASH.size(); i++){
            if (rcvData.equals(MainProgram.RESOURCE_HASH.get(i))){
                jgFLG = false;
                break;
            }
        }
        
        if(jgFLG){
            MainProgram.RESOURCE_HASH.add(rcvData);
        }
        
        System.out.println("Current DHT: " + MainProgram.RESOURCE_HASH);
    }
    
    public static void nodeLatencyCheck(String rcvIP) throws Exception{
        String nodeIP = getCTX("("+rcvIP,"(","+");
        new nodeConnection(nodeIP).start();
        new Robot().delay(500);
        boolean addFLG = true;
        boolean deleFLG = true;
        if(nodeConnection.NODE_STATE){
            for(int i = 0; i < MainProgram.NODE_IP.size(); i++ ){
                if(MainProgram.NODE_IP.get(i).contains(nodeIP)){
                    MainProgram.NODE_IP.remove(i);
                    MainProgram.NODE_IP.add(nodeIP+":"+nodeConnection.NODE_RTT);
                    addFLG = false;
                    break;
                } 
            }
            if(addFLG){
                MainProgram.NODE_IP.add(nodeIP+":"+nodeConnection.NODE_RTT);
            }
            System.out.println("Current node & RTT Latency" + MainProgram.NODE_IP);
            
        }else{
            for(int i = 0; i < MainProgram.NODE_IP.size(); i++ ){
                if(MainProgram.NODE_IP.get(i).contains(nodeIP)){
                    MainProgram.NODE_IP.remove(i);
                    break;
                } 
            }
            while(deleFLG){
                deleFLG = false;
                for(int i = 0; i < MainProgram.RESOURCE_HASH.size(); i++ ){
                    if(MainProgram.RESOURCE_HASH.get(i).contains(nodeIP)){
                        MainProgram.RESOURCE_HASH.remove(i);
                        deleFLG = true;
                    }
                }
            }
            System.out.println("Current DHT: " + MainProgram.RESOURCE_HASH);
            System.out.println("Current node & RTT Latency" + MainProgram.NODE_IP);

        }
    }        
    
    public static void nodeQuit(String rcvData){
        String nodeIP = getCTX("("+rcvData,"(","-");
        boolean deleFLG = true;
        for(int i = 0; i < MainProgram.NODE_IP.size(); i++ ){
                if(MainProgram.NODE_IP.get(i).contains(nodeIP)){
                    MainProgram.NODE_IP.remove(i);
                    break;
            } 
        }
        while(deleFLG){
                deleFLG = false;
                for(int i = 0; i < MainProgram.RESOURCE_HASH.size(); i++ ){
                    if(MainProgram.RESOURCE_HASH.get(i).contains(nodeIP)){
                        MainProgram.RESOURCE_HASH.remove(i);
                        deleFLG = true;
                    }
                }
            }
        System.out.println("Current DHT: " + MainProgram.RESOURCE_HASH);
        System.out.println("Current node & RTT Latency" + MainProgram.NODE_IP);
        
    }
   
    
    
    public static String getCTX(String originalCTX,String firstSplit,String secondSplit){
        String resultCTX = originalCTX.substring(originalCTX.lastIndexOf(firstSplit), 
        originalCTX.lastIndexOf(secondSplit));
        resultCTX = resultCTX.substring(1,resultCTX.length());
        return resultCTX;
    }
    
}
