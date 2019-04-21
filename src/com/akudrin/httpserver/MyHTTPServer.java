package com.akudrin.httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.Set;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class MyHTTPServer {

	static class IndexHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			System.out.println(exchange.getRemoteAddress());
			String response = getResponse();
			System.out.println(response);
			exchange.sendResponseHeaders(200, response.length());
			OutputStream out = exchange.getResponseBody();
			out.write(response.toString().getBytes());
			out.close();
		}
	}

	static class DetailHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			String requestMethod = exchange.getRequestMethod();
			System.out.println(requestMethod);

			InputStream in = exchange.getRequestBody();
			if (in != null) {
				try (BufferedReader br = new BufferedReader(new InputStreamReader(in));) {
					String inputLine;
					StringBuilder response = new StringBuilder();
					while ((inputLine = br.readLine()) != null) {
						response.append(inputLine);
					}
					br.close();
					System.out.println(inputLine);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			} else {
				System.out.println("Request body is empty");
			}

			Headers requestHeaders = exchange.getRequestHeaders();
			Set<String> keySet = requestHeaders.keySet();
			for (String key : keySet) {
				List values = requestHeaders.get(key);
				String header = key + " = " + values.toString() + "\n";
				System.out.print(header);
			}
		}
	}

	public static String getResponse() {
		StringBuilder responseBuffer = new StringBuilder();
		responseBuffer.append("<html><h1>HTTPServer Home Page…. </h1><br>")
				.append("<b>Welcome to the new and improved web " + "server!</b><BR>").append("</html>");
		return responseBuffer.toString();
	}

	public static void main(String[] args) throws Exception {
		System.out.println("MyHTTPServer Started");
		HttpServer server = HttpServer.create(new InetSocketAddress(3000), 0);
		// server.createContext("/index", new MyHTTPServer.IndexHandler());
		server.createContext("/index", new DetailHandler());
		server.start();
	}

}
