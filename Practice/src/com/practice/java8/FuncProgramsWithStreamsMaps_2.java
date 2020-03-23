package com.practice.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FuncProgramsWithStreamsMaps_2 {

	public static void main(String[] args) {
		List<Integer> numberList = new ArrayList<>(Arrays.asList(10, 2, 3, 4, 5, 6, 7, 7, 7, 7, 6, 11, 10, 56, 44, 10));

		List<String> courseList = Arrays.asList("Spring Boot", "Docker", "Kubernetes", "Jenkins", "CI-CD", "Spring MVC",
				"GIT");

		System.out.println(printSumOfOddNumInFunctionalProgram(numberList));
		printCubeOddNumbersInFunctionalProgram(numberList);
		System.out.println(printMinNumberInFunctionalProgram(numberList));
		;
	}

//Functional Program approach to print sum of odd number
	public static int printSumOfOddNumInFunctionalProgram(List<Integer> numberList) {
		return numberList.stream().filter(number -> number % 2 != 0).reduce(0, (x, y) -> x + y);
	}

	// Functional Program approach print cube of odd number
	public static void printCubeOddNumbersInFunctionalProgram(List<Integer> numberList) {

		System.out.println("Cubes of odd numbers");
		numberList.stream().filter(number -> number % 2 != 0).map(number -> number * number * number)
				.forEach(System.out::println);

	}

	// Functional Program approach to print minimum number in the list using
	// reduce
	public static int printMinNumberInFunctionalProgram(List<Integer> numberList) {
		return numberList.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y);

		// Print max number
		// return numberList.stream().reduce(Integer.MIN_VALUE, (x, y) -> x > y ? x :
		// y);
	}
}
