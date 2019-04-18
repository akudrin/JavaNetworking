package com.akudrin.datatransfer;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class BufferExamples {
	public static void main(String[] args) {
		// A view mirrors the data in another buffer.
		String contents = "Book";
		ByteBuffer buffer = ByteBuffer.allocate(32);
		buffer.put(contents.getBytes());
		ByteBuffer duplicateBuffer = buffer.duplicate();
		duplicateBuffer.put(0, (byte) 0x4c); // 'L'
		System.out.println("buffer: " + buffer.get(0));
		System.out.println("duplicateBuffer: " + duplicateBuffer.get(0));

		System.out.println(contents.getBytes());
		System.out.println(Charset.defaultCharset());

		String str = new String("Hello");
		byte[] array1 = str.getBytes();
		System.out.println("Default Charset encoding:");
		for (byte b : array1) {
			System.out.println(b);
		}

		byte b1 = 76;
		char char1 = (char) b1;
		System.out.println(char1);

		/*
		 * A buffer, by default, is read-write. However, it can be read-only or
		 * read-write. To create a read-only buffer, use the buffer class’s
		 * asReadOnlyBuffer method.
		 */
		
		ByteBuffer bufferRO = ByteBuffer.allocate(32);
		ByteBuffer readOnlyBuffer = bufferRO.asReadOnlyBuffer();
		System.out.println("Read-only: " +
				readOnlyBuffer.isReadOnly());
		
	}
}
