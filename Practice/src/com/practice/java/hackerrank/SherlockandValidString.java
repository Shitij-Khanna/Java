package com.practice.java.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class SherlockandValidString {
	public static void main(String[] args) {
		String s = "aaabbbcccdddeeefff";

		String result = isValid(s);
		System.out.print(result);
	}

	// Complete the isValid function below.
	static String isValid(String s) {
		String str[] = s.split("");
		List<String> charList = new ArrayList<String>();
		charList = Arrays.asList(str);
		Map<String, Long> charCountMap = charList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Collection<Long> countList = charCountMap.values();
		Map<Long, Long> countOfDistinctCountsMap = countList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//		System.out.println(charCountMap);
//		System.out.println(countOfDistinctCountsMap);
		int distinctCounts = countOfDistinctCountsMap.keySet().size();
		if (distinctCounts == 1) {
			return "YES";
		} else if (distinctCounts > 2) {
			return "NO";
		} else if (distinctCounts == 2) {
			Predicate<Map.Entry<Long, Long>> singleCountEntryPredicate = (Map.Entry<Long, Long> entryy) -> {
				if (entryy.getValue() == 1) {
					return true;
				}
				return false;
			};

			Predicate<Map.Entry<Long, Long>> multipleCountEntryPredicate = (Map.Entry<Long, Long> entryy) -> {
				if (entryy.getValue() != 1) {
					return true;
				}
				return false;
			};
			Optional<Entry<Long, Long>> singleSeparateElementOpt = countOfDistinctCountsMap.entrySet().stream()
					.filter(singleCountEntryPredicate).findFirst();
			Optional<Entry<Long, Long>> multiSeparateElementOpt = countOfDistinctCountsMap.entrySet().stream()
					.filter(multipleCountEntryPredicate).findFirst();
			if (singleSeparateElementOpt.isPresent()) {
				Entry<Long, Long> singleSeparateCount = singleSeparateElementOpt.get();
				Entry<Long, Long> multipleSeparateCount = multiSeparateElementOpt.get();
				Long singleValue = singleSeparateCount.getKey();
				Long multiValue = multipleSeparateCount.getKey();
				if (singleValue - 1 == 0 || singleValue - 1 == multiValue) {
					return "YES";
				} else {
					return "NO";
				}
			} else {
				return "NO";
			}
		} else {
			return "NO";
		}
	}
}
//
//{a=3, b=4, c=4, d=4, e=4, f=4}
//{3=1, 4=5}
//Diff : -1
//YES
