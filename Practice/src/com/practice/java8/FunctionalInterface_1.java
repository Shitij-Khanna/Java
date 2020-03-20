package com.practice.java8;

import java.util.ArrayList;
import java.util.List;

public class FunctionalInterface_1 {

	public static void main(String[] args) {
		// Runnable is a functional interface, so it can be instantiated using a lambda
		// expression
		// Func interface is one with judt one abstract method, so we don't need to
		// create a whole anonymous class or new class to implement it and override the
		// method, lambda function makes it easy.
		Runnable r = () -> {
			System.out.println("This my my run method");
		};
		Thread mythread = new Thread(r);
		mythread.start();

		// Functional interface and lambda using method reference
		List<String> list = new ArrayList<String>();
		list.add("Shitij");
		list.add("Akshit");
		list.add("Neha");

		// for each takes Consumer interface as paramter
		// Consumer interface has accept method, which we can initialize here as an
		// anonymos class and provide the implementation
		// on the other hand, we can just use lambda to implement it instead of writing
		// the anonymous class and initializing it
		list.forEach(
//				(name) -> {System.out.println(name);
				System.out::println
//		}
				
	);
	}
}
