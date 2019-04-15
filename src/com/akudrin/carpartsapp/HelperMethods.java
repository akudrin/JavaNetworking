package com.akudrin.carpartsapp;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class HelperMethods {
	public static void sendMessage(SocketChannel socketChannel, String message) {
		try {
			ByteBuffer buffer = ByteBuffer.allocate(64);
			buffer.put(message.getBytes());
			buffer.flip();
			while (buffer.hasRemaining()) {
				socketChannel.write(buffer);
			}
			System.out.println("Sent: " + message);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static String receiveMessage(SocketChannel socketChannel) {
		String message = "";
		try {
			ByteBuffer byteBuffer = ByteBuffer.allocate(64);
			socketChannel.read(byteBuffer);
			byteBuffer.flip();
			while (byteBuffer.hasRemaining()) {
				message += (char) byteBuffer.get();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return message;
	}

}
