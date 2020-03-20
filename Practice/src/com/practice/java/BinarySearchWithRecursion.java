package com.practice.java;

import java.util.Arrays;

public class BinarySearchWithRecursion {
	public static void main(String[] args) {

		int[] arr1 = { 2, 45, 234, 567, 876, 900, 976, 999 };
		int index = recursiveBinarySearch(arr1, 0, arr1.length, 45);
		System.out.println("Found 45 at " + index + " index");
		index = recursiveBinarySearch(arr1, 0, arr1.length, 999);
		System.out.println("Found 999 at " + index + " index");
		index = recursiveBinarySearch(arr1, 0, arr1.length, 876);
		System.out.println("Found 876 at " + index + " index");
	}

	private static int recursiveBinarySearch(int[] arr, int start, int end, int key) {
		Arrays.sort(arr);
		int location = -1;
			int mid = start + (end - start) / 2;
			if (arr[mid] == key) {
				location = mid + 1;
				return location;
			} else if (arr[mid] > key) {
				end = mid;
				location = recursiveBinarySearch(arr, start, end, key);
				return location;
			} else if (arr[mid] < key) {
				start = mid;
				location = recursiveBinarySearch(arr, start, end, key);
				return location;
			}
		return location;
	}
}