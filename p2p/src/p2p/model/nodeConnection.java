/*
 * Author      : Hongyi Zhang
 * Version     : 1.0
 * Copyright   : All rights reserved. Do not distribute. 
 * You are welcomed to modify the code.
 * But any commercial use you need to contact me
 */
package p2p.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 *
 * @author Hongyi Zhang
 */
public class nodeConnection extends Thread{
    String nodeIP;
    public static boolean NODE_STATE;
    public static String NODE_RTT;
    public nodeConnection(String nodeIP){
        this.nodeIP = nodeIP;
    }
    
    @Override
    public void run(){
        NODE_STATE = false; 
        String IP = nodeIP;
        Runtime runtime = Runtime.getRuntime();    
        Process process;    
        try {    
            process = runtime.exec("ping -c 1 " + IP);    
            InputStream is = process.getInputStream();     
            InputStreamReader isr = new InputStreamReader(is);     
            BufferedReader br = new BufferedReader(isr);     
            String line = null;     
            StringBuffer sb = new StringBuffer();     
            while ((line = br.readLine()) != null) {     
                sb.append(line);     
            }
            
            
            is.close();     
            isr.close();     
            br.close();     
     
            if (null != sb && !sb.toString().equals("")) {         
                if (sb.toString().indexOf("ttl") > 0) {     
                    NODE_STATE = true;
                    NODE_RTT = sb.toString().substring(sb.toString().indexOf("time=") + 5, sb.toString().indexOf(" ms"));
                    System.out.println("RTT: " + NODE_RTT + " ms");
                } else {          
                    NODE_STATE = false;   
                    System.out.println("Network Unreachable !");
                }     
            }     
        } catch (IOException e) {    
            e.printStackTrace();    
        }     
    }
    
    
}
