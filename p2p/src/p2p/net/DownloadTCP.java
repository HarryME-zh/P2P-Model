/*
 * Author      : Hongyi Zhang
 * Version     : 1.0
 * Copyright   : All rights reserved. Do not distribute. 
 * You are welcomed to modify the code.
 * But any commercial use you need to contact me
 */
package p2p.net;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;
/**
 *
 * @author Hongyi Zhang
 */
public class DownloadTCP {
       
public static void userTCPDownload(String SERVER_IP, String fileName) throws Exception{
    
    String userFilePath = "/Users/harry/Desktop/p2p";
    Socket s = new Socket(SERVER_IP,10006);
    File file = new File(userFilePath+"/"+fileName);
    InputStream in = s.getInputStream();

    FileOutputStream fos = new FileOutputStream(file);

    byte[] buffile = new byte[2048];

    int len = 0;

    while ((len = in.read(buffile)) != -1) 
        {
            fos.write(buffile, 0, len);
        }

    fos.close();
    s.close();

}
}
