package com.hand.Exam1;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test1 {
	
	public static void write(byte[] img, String fileName){
		try {
			File file = new File("E:\\" + fileName);
			FileOutputStream f = new FileOutputStream(file);
			f.write(img);
			f.flush();
			f.close();
			System.out.println("文档已经写入到E盘");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static byte[] getPdf(String strUrl){
		try {
			URL url = new URL(strUrl);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5 * 1000);
			InputStream in = conn.getInputStream();
			
			byte[] b1 = read(in);
			return b1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static byte[] read(InputStream in) throws Exception{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while( (len=in.read(buffer)) != -1 ){
			out.write(buffer, 0, len);
		}
		in.close();
		return out.toByteArray();
	}
	

	public static void main(String[] args) {
		String url = "http://www.manning.com/gsmith/SampleChapter1.pdf";
		byte[] b = getPdf(url);
		if(null != b && b.length > 0){			
			String fileName = "xukaidi.pdf";
			write(b, fileName);
		}else{
			System.out.println("没有获得文件");
		}
	}
}
