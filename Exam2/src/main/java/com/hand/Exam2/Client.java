package com.hand.Exam2;

import java.io.DataInputStream;  
import java.io.DataOutputStream;  
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;  
import java.net.Socket;  
  
public class Client {  
    public static final String IP_ADDR = "localhost";//服务器地址   
    public static final int PORT = 12345;//服务器端口号    
      
    public static void write(byte[] img, String fileName){
		try {
			File file = new File("E:\\" + fileName);
			FileOutputStream fops = new FileOutputStream(file);
			fops.write(img);
			fops.flush();
			fops.close();
			System.out.println("文档已经写入到E盘");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    
    public static void main(String[] args) {    
        System.out.println("客户端启动...");    
        while (true) {    
            Socket socket = null;  
            try {  
                socket = new Socket(IP_ADDR, PORT);    
                    
                DataInputStream input = new DataInputStream(socket.getInputStream()); 
                
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());    
    
                    
                String ret = input.readUTF();     
                System.out.println("服务器端返回过来的是: " + ret);    
 
                  
                out.close();  
                input.close();  
            } catch (Exception e) {  
            } finally {  
                if (socket != null) {  
                    try {  
                        socket.close();  
                    } catch (IOException e) {  
                        socket = null;   
                    }  
                }  
            }  
        }    
    }    
}    