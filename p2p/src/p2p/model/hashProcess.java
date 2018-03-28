/*
 * Author      : Hongyi Zhang
 * Version     : 1.0
 * Copyright   : All rights reserved. Do not distribute. 
 * You are welcomed to modify the code.
 * But any commercial use you need to contact me
 */
package p2p.model;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.io.*;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import p2p.net.MulticastSender;
import p2p.startup.MainProgram;
/**
 *
 * @author Hongyi Zhang
 */
public class hashProcess {
    
    
     public static String SHA1(String decript) {
        try {
            MessageDigest digest = java.security.MessageDigest
                    .getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // Change to Hex
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
     
    public static ArrayList<String> getFiles(String path) {
        ArrayList<String> files = new ArrayList<String>();
        File file = new File(path);
        File[] tempList = file.listFiles();

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                files.add(getCTX(tempList[i].toString()+")","/",")"));
            }
            if (tempList[i].isDirectory()) {
            }
        }
        return files;
    }
    
    public static String getCTX(String originalCTX,String firstSplit,String secondSplit){
        String resultCTX = originalCTX.substring(originalCTX.lastIndexOf(firstSplit), 
        originalCTX.lastIndexOf(secondSplit));
        resultCTX = resultCTX.substring(1,resultCTX.length());
        return resultCTX;
    }
    
    public static void hashTable(){
        ArrayList<String> fileNames;
        fileNames = getFiles(MainProgram.P2P_FILEPATH);
        System.out.println("Your local file: " + fileNames);
        
        for(int i=0;i<fileNames.size();i++){
            String temp = fileNames.get(i);
            temp = SHA1(temp);
            MainProgram.RESOURCE_HASH.add(MainProgram.LOCAL_IP +":"+temp);
        }
        
        System.out.println("Generated Local Resourses DHT: "+MainProgram.RESOURCE_HASH);
        
    }
    
    public static void uploadTable() throws Exception{
        
        MulticastSocket socket = new MulticastSocket(6666);
        InetAddress address = InetAddress.getByName("226.0.0.6");
        socket.setNetworkInterface(NetworkInterface.getByName("en0"));
        socket.joinGroup(address);
        
        for (int i = 0; i < MainProgram.RESOURCE_HASH.size(); i++){
            new MulticastSender(socket,address, 6666, "#"+MainProgram.RESOURCE_HASH.get(i)).start();
           // System.out.println("Upload Sucess");
        }
        
    }
   
    
    
}
