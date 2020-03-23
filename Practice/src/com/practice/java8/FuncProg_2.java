package com.practice.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FuncProg_2 {

	public static void main(String[] args) {

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		numbers.add(7);
		numbers.add(8);
		numbers.add(9);
		
//		List<Integer> squaredNumbers = squareList(numbers);
		
		List<Integer> evenNumbersOnly = numbers.stream()
										.filter(x -> x%2==0)
										.collect(Collectors.toList());
		
		//System.out.println(squaredNumbers);
//		System.out.println(evenNumbersOnly);
		
		 int sum = addListFunctional(numbers);
		
		 System.out.println("sum : " + sum);

	}
	
	private static List<Integer> squareList(List<Integer> numbers) {
		//1 , 5, 6
		//1 -> 1
		//5 -> 25
		//6 -> 36
		
		return numbers.stream()
				.map(number -> number * number)
				.collect(Collectors.toList());
	}

	private static int addListFunctional(List<Integer> numbers) {
		//Stream of number -> One result value
		  //Combine them into one result => One Value
		  // 0 and FP02Functional::sum
		return numbers.stream()
				.parallel()
		  //.reduce(0, FP02Functional::sum);	
		  // .reduce(0, (x,y) -> x + y);
			.reduce(0, Integer::sum);
	}
}