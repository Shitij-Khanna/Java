package com.study.threads.parallelNSerialDemo;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.study.threads.parallelNSerialDemo.util.PatternFinder;

public class ParallelPatternFinder {

	public static void main(String[] args) throws Exception {

		String pattern = "Java";

		File dir = new File("./src/sample");
		File[] files = dir.listFiles();

		PatternFinder finder = new PatternFinder();

		// Fixed thread pool of size 3.
		ExecutorService executor = Executors.newFixedThreadPool(3);

		// Map to store the Future object against each
		// file search request, later once the result is obtained
		// the Future object will be
		// replaced with the search result.

		Map<String, Object> resultMap = new HashMap<String, Object>();

		long startTime = System.currentTimeMillis();

		for (File file : files) {

			// Submit a Callable task for the file.
			Future<List<Integer>> future = executor.submit(new Callable<List<Integer>>() {
				public List<Integer> call() {
					List<Integer> lineNumbers = finder.find(file, pattern);
					return lineNumbers;
				}
			});

			// Save the future object in the map for
			// fetching the result.

			resultMap.put(file.getName(), future);
		}

		// Wait for the requests to complete.
		waitForAll(resultMap);

		// Display the result.
		for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
			System.out.println(pattern + " found at - " + entry.getValue() + " in file " + entry.getKey());
		}

		System.out.println(" Time taken for search - " + (System.currentTimeMillis() - startTime));

	}

	private static void waitForAll(Map<String, Object> resultMap) throws Exception {

		Set<String> keys = resultMap.keySet();

		for (String key : keys) {
			Future<List<Integer>> future = (Future<List<Integer>>) resultMap.get(key);

			// wait till the future object tells that the thread has completed execution, so
			// that the return value can be updated into the map
			while (!future.isDone()) {

				// Passing the CPU to other
				// threads so that they can
				// complete the operation.
				// future.isDone() would give true when the future object has completed
				// execution.
				// With out this we are simply
				// keeping the CPU in loop and
				// wasting its time.

				Thread.yield();
			}

			// Replace the future object with the obtained result.
			resultMap.put(key, future.get());
		}

	}
}
