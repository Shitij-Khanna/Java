package com.practice.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FP03FunctionalInterfaces {
	
	/*
	 
	 boolean isEven(int x) {
	 	return x%2==0;
	 }
	 
	 int squared(int x) {
	 	return x * x;
	 }
	  
	 */

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 2, 3, 4, 5, 6, 7, 7, 7, 7, 6, 11, 10, 56, 44, 10));

		List<String> courseList = Arrays.asList("Spring Boot", "Docker", "Kubernetes", "Jenkins", "CI-CD", "Spring MVC",
				"GIT");
				
		
		System.out.println("--------------------------------------------");
		Predicate<Integer> isEvenPredicate = x -> x%2 ==0;
//		
		Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
			
			@Override
			public boolean test(Integer t) {
				return t % 2==0;
			}
		};
		
		
		Function<Integer, Integer> squareFunction = x -> x * x;
		
		Function<Integer, Integer> squareFunction2 = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer x) {
				return x*x;
			}
			
		};
		
		System.out.println("--------------------------------------------");
		Consumer<Integer> sysoutConsumer = System.out::println;
		
		Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() {
			public void accept(Integer x) {
				System.out.println(x);
			}
		};
		
		numbers.stream()
			.filter(isEvenPredicate)
			.map(squareFunction)
			.forEach(sysoutConsumer2);
		
		System.out.println("--------------------------------------------");
		BinaryOperator<Integer> sumBinaryOperator = Integer::sum;
		//BinaryOperator<Integer> sumBinaryOperator = (x,y) => x + y;
		
		
		BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>() {
			@Override
			public Integer apply(Integer a, Integer b) {
				return a + b;
			}
			
		};
		
		System.out.println("--------------------------------------------");
		int sum = numbers.stream()
			.reduce(0, sumBinaryOperator);
		System.out.print("Sum : "+sum);

	}
}
