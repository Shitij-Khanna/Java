package com.practice.java8;

public class Lambda_FunctionalInterfaceWithReturnVal {

	public static void main(String[] args) {
		FunctionalInterfaceWithReturnVal func = (a,b)->{
			return a>b;
		};
		System.out.println(func.findMax(40, 20));
	}
	
}
