package com.practice.datastructures.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author shitijkhanna
 * // Reference : https://thecodingsimplified.com/find-kth-largest-value-in-given-array/
   // https://www.youtube.com/watch?v=iiYmgrD4h6M&feature=youtu.be
 *
 */
public class KthLargestElmtArr {

	public static void main(String[] args) {
		 int[] arr = {10, 7, 11, 30, 20, 38, 2, 45};
		    int k = 3;
		    
		    System.out.println(KthLargestElmtArr.kthLargestElementInGivenArrayMinHeap(arr, k));
		    System.out.println(KthLargestElmtArr.kthLargestElementInGivenArrayMaxHeap(arr, k));
	}

	private static int kthLargestElementInGivenArrayMinHeap(int[] arr, int k) {
		if(arr.length < k) {
			System.out.println("Invalid case");
		}
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for(int i=0; i<k; i++) {
			minHeap.add(arr[i]);
		}
		
		for(int i=k; i<arr.length; i++) {
			if(arr[i] > minHeap.peek()) {
				minHeap.poll();
				minHeap.add(arr[i]);
			}
		}
		return minHeap.peek();
	}

	private static int kthLargestElementInGivenArrayMaxHeap(int[] arr, int k) {
		if(arr.length < k) {
			System.out.println("Invalid case");
		}
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i=0; i<arr.length; i++) {
			maxHeap.add(arr[i]);
		}
		
		for(int i=0; i<k-1; i++) {
			maxHeap.poll();
		}
		
		return maxHeap.peek();
	}
}

