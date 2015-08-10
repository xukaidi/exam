package com.hand.Exam3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import net.sf.json.JSONObject;

public class Test3 {

	public static void getFile() {
		try {

			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();

			String surl = "http://hq.sinajs.cn/list=sz300170";
			URL url = new URL(surl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5 * 1000);

			InputStream isr = conn.getInputStream();
			InputStreamReader isrr = new InputStreamReader(isr);
			BufferedReader br = new BufferedReader(isrr);
			String lineString;
			StringBuilder builder = new StringBuilder();
			while ((lineString = br.readLine()) != null) {
				builder.append(lineString);
				System.out.println(lineString);
			}

			String b[] = builder.toString().split(",");

			JSONObject json = null;
			json = new JSONObject();

			for (int i = 0; i < b.length; i++) {
				if (i == 0) {
					json.put("name", b[i]);
				}
				if (i == 1) {
					json.put("open", b[i]);
				}
				if (i == 2) {
					json.put("close", b[i]);

				}
				if (i == 3) {
					json.put("current", b[i]);
				}
				if (i == 4) {
					json.put("high", b[i]);
				}
				if (i == 5) {
					json.put("low", b[i]);
				}
			}
			System.out.println("JSON数据为：" + json);

			// 保存为xml文件
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder1;
			builder1 = factory.newDocumentBuilder();
			Document document = builder1.newDocument();
			Element stock = document.createElement("stock");

			Element name = document.createElement("name");
			name.setTextContent(json.getString("name"));
			Element open = document.createElement("open");
			open.setTextContent(json.getString("open"));

			Element close = document.createElement("close");
			close.setTextContent(json.getString("close"));
			Element current = document.createElement("current");
			current.setTextContent(json.getString("current"));

			Element high = document.createElement("high");
			high.setTextContent(json.getString("high"));
			Element low = document.createElement("low");
			low.setTextContent(json.getString("low"));

			stock.appendChild(name);
			stock.appendChild(open);
			stock.appendChild(close);
			stock.appendChild(current);
			stock.appendChild(high);
			stock.appendChild(low);

			document.appendChild(stock);

			Transformer transformer = transformerFactory.newTransformer();
			Transformer transformer1 = transformerFactory.newTransformer();
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(document), new StreamResult(
					writer));
			transformer1.transform(new DOMSource(document), new StreamResult(
					new File("xukaidi")));
			System.out.println("xml数据为" + writer.toString());

		}

		catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		getFile();
	}

}
