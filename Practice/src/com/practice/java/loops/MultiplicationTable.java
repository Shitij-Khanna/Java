package com.practice.java.loops;

public class MultiplicationTable {
	public static void main(String[] args) {
		printMultiplicationTable(5);
	}
	
	public static void printMultiplicationTable(int N) {
		for (int i=1; i<=10; i++) {
			System.out.println(N + " * " + i +  " = " + N*i);
		}
	}
}
