package com.akudrin.networkaddressing;

import java.io.IOException;
import java.util.function.Supplier;

public class Test {

	public static void main(String[] args) {
		Supplier<String> socketInput = () -> {
				return "Hello World";
		};
		System.out.println(socketInput.get());
		
		
	}

}
