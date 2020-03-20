package com.practice.java;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequencyTest {
	public static void main(String[] args) {
		List<String> wordList = Arrays.asList("Apple", "Ananas", "Bananas", "Mango", "Cherry", "Bananas", "Apple",
				"Bananas", "Apple", "Cherry", "Mango", "Bananas");
		
//		ConcurrentMap<String, Integer> wordCountMap = wordList.stream().
//				collect(Collectors.toConcurrentMap(w->w, w->1, Integer::sum));
//		
//		System.out.println(wordCountMap);
		Map<String, Integer> wordCountMap = wordList.stream().collect(Collectors.toMap(w -> w, w-> 1, Integer::sum));
		System.out.println(wordCountMap);
 
	}
}