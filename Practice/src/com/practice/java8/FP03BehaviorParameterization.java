package com.practice.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03BehaviorParameterization {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 2, 3, 4, 5, 6, 7, 7, 7, 7, 6, 11, 10, 56, 44, 10));

		List<String> courseList = Arrays.asList("Spring Boot", "Docker", "Kubernetes", "Jenkins", "CI-CD", "Spring MVC",
				"GIT");
		
//		filterAndPrint(numbers, x -> x%2==0);

//		filterAndPrint(numbers, x -> x%2!=0);
//		
		filterAndPrint(numbers, x -> x%3==0);
//		
		Function<Integer, Integer> mappingFunction = x -> x*x;
//		
		List<Integer> squaredNumbers =  mapAndCreateNewList(numbers, mappingFunction);
		System.out.println("squaredNumbers :::: ");
		System.out.println(squaredNumbers);
		
		List<Integer> cubedNumbers =  mapAndCreateNewList(numbers, x -> x*x*x);
		System.out.println("cubedNumbers :::: ");
		System.out.println(cubedNumbers);
		
		List<Integer> doubledNumbers =  mapAndCreateNewList(numbers, x -> x + x);
		System.out.println("doubledNumbers :::: ");
		System.out.println(doubledNumbers);
		
	}

	private static List<Integer> mapAndCreateNewList(List<Integer> numbers,
			Function<Integer, Integer> mappingFunction) {
		return numbers.stream()
				.map(mappingFunction)
				.collect(Collectors.toList());
	}

	private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {
		numbers.stream()
		.filter(predicate)
		.forEach(System.out::println);
	}
}
