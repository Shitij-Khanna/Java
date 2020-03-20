package com.practice.java8;

public class MyLambdaExp_2 {

	public static void main(String[] args) {
		MyFunctionalInterface_2 func = (name, age) -> {
			System.out.println("Name : " + name);
			System.out.println("Age is : " + age);
		};
		func.printNameAndAge("Shitij", 30);
		

		// We use lambda function to provide implementation of the method here, and
		// assign it to a variable func. So, func is a lambda function.
		// Similarly, another implementation can be given and provided to another
		// function based on another requirement.

	}
}
