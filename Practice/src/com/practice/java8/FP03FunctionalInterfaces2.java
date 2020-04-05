package com.practice.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FP03FunctionalInterfaces2 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 2, 3, 4, 5, 6, 7, 7, 7, 7, 6, 11, 10, 56, 44, 10));

		List<String> courseList = Arrays.asList("Spring Boot", "Docker", "Kubernetes", "Jenkins", "CI-CD", "Spring MVC",
				"GIT");

		System.out.println("--------------------------------------------");
		Predicate<Integer> isEvenPredicate = (Integer x) -> x % 2 == 0;
		Function<Integer, Integer> squareFunction = x -> x * x;
		
		Function<Integer, String> stringOutpuFunction = x -> x + " ";

		Consumer<Integer> sysoutConsumer = x -> System.out.println(x);

		BinaryOperator<Integer> sumBinaryOperator = (x, y) -> x + y;
		System.out.println("--------------------------------------------");
		
		//No input > Return Something
		Supplier<Integer> randomIntegerSupplier = () -> {
			Random random = new Random();
			return random.nextInt(1000);
		};
		System.out.println("--------------------------------------------");
		System.out.println("Random supply : "+randomIntegerSupplier.get());
		System.out.println("--------------------------------------------");
		
		UnaryOperator<Integer> unaryOperator = x -> 3 * x;
		System.out.println("UnaryOperator : ");
		System.out.println(unaryOperator.apply(10));
		
		BiPredicate<Integer, String> biPredicate = (number,str) -> {
			return number<10 && str.length()>5;
		};
		
		System.out.println("biPredicate test: "+biPredicate.test(10, "Shitij Khanna"));
		System.out.println("--------------------------------------------");
		
		BiFunction<Integer, String, String> biFunction = (number,str) -> {
			return number + " " + str;
		};
		
		System.out.println("biFunction test : "+biFunction.apply(15, "Shitij Khanna"));
		System.out.println("--------------------------------------------");
		
		BiConsumer<Integer, String> biConsumer = (s1,s2) -> {
			System.out.println("biConsumer :: ");
			System.out.println(s1);
			System.out.println(s2);
		};
		
		biConsumer.accept(25, "Shitij Khanna");
		
		BinaryOperator<Integer> sumBinaryOperator2 = (x, y) -> x + y;
		
		IntBinaryOperator intBinaryOperator = (x,y) -> x + y;
		int a = intBinaryOperator.applyAsInt(1, 3);
		System.out.println("Int binary operator ::" + a);
		//IntBinaryOperator
		//IntConsumer
		//IntFunction
		//IntPredicate
		//IntSupplier
		//IntToDoubleFunction
		//IntToLongFunction
		//IntUnaryOperator
		
		//Long, Double, Int
		

		//numbers.stream().filter(isEvenPredicate).map(squareFunction).forEach(sysoutConsumer);

		//int sum = numbers.stream().reduce(0, sumBinaryOperator);
	}
}
