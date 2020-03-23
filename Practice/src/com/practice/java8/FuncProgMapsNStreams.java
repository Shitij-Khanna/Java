package com.practice.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FuncProgMapsNStreams {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 6, 1, 10, 56, 44, 10));

		List<String> courseList = Arrays.asList("Spring Boot", "Docker", "Kubernetes", "Jenkins", "CI-CD", "Spring MVC",
				"GIT");

		// calculate the sum of squares of all elements in list
		Optional<Integer> opt = numbers.stream().map(a -> a * a).reduce((x, y) -> x + y);
		if (opt.isPresent()) {
			System.out.println(opt.get());
		} else {
			System.out.println("reduce failed");
		}

		// print distinct numbers from list
		System.out.println("Distinct numbers");
		numbers.stream().distinct().forEach(System.out::println);

		// sort all numbers in list
		System.out.println("Sorted numbers");
		numbers.stream().sorted().forEach(System.out::println);

		System.out.println("Distinct Sorted numbers");
		numbers.stream().distinct().sorted().forEach(System.out::println);

		System.out.println("Courses -----------");
		System.out.println("Sorted -----------");
		courseList.stream().sorted().forEach(System.out::println);
		
		System.out.println("Sorted reverse-----------");
		courseList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
		System.out.println("Sorted with length-----------");
		courseList.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);
		
		
		System.out.println("Sorted with length-----------");
		courseList.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);
	}

}
