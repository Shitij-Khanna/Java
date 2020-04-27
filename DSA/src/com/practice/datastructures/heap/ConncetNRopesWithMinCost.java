package com.practice.datastructures.heap;

import java.util.PriorityQueue;

/**
 * @author shitijkhanna 
 *         https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
 *         https://www.youtube.com/watch?v=Z0qmsZefzXA&list=PLt4nG7RVVk1j4vPcIqLqUZLOlOyd8KHw5&index=12
 */
public class ConncetNRopesWithMinCost {

	public static void main(String[] args) {
		int arr[] = { 3, 4, 7, 2 };
		System.out.println(ConncetNRopesWithMinCost.connectRopeWithMinimumCost(arr));
	}

	private static int connectRopeWithMinimumCost(int[] arr) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

		for (int i = 0; i < arr.length; i++) {
			minHeap.add(arr[i]);
		}

		int cost = 0;
		while (minHeap.size() > 1) {
			int tempCost = minHeap.poll() + minHeap.poll();
			cost += tempCost;
			minHeap.add(tempCost);
		}
		return cost;
	}
}
