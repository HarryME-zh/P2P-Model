/*
 * Author      : Hongyi Zhang
 * Version     : 1.0
 * Copyright   : All rights reserved. Do not distribute. 
 * You are welcomed to modify the code.
 * But any commercial use you need to contact me
 */
package p2p.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *
 * @author Hongyi Zhang
 */
public class ThreadTcpDownload extends Thread implements Runnable{
    private String userFileName;
    public ThreadTcpDownload(String userFileName){
    this.userFileName = userFileName;
}   
    
    @Override
public void run() {
    try {
        String folderPath = null;

        

        ServerSocket sSocket=new ServerSocket(10006);
        Socket s= sSocket.accept();
      
        File file = new File(folderPath+userFileName);

        FileInputStream fis = new FileInputStream(file);


        OutputStream out = s.getOutputStream();

        byte[] buf = new byte[2048];
        int len = 0;

        while ((len = fis.read(buf)) != -1)
        {
            out.write(buf, 0, len);
        }
        s.shutdownOutput();
        s.close();
        sSocket.close();

        System.out.println("Download success! Filename: "+userFileName);
                 
        } catch (IOException ex) {
       
    }
}
    
}
