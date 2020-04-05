package com.practice.java;

public class QuickSort {

	public static void main(String[] args) {
		int arr[] = { 10, 7, 8, 9, 1, 5, 4, 2 };
		quickSort(0, arr.length - 1, arr);
		for (int k = 0; k < arr.length; k++) {
			System.out.print(" " + arr[k]);
		}
	}

	public static void quickSort(int start, int end, int arr[]) {
		if (start < end) {
			/*
			 * pi is partitioning index, arr[pi] is now at right place
			 */
			int pi = partition(start, end, arr);

			// Recursively sort elements before
			// partition and after partition
			quickSort(start, pi - 1, arr);
			quickSort(pi + 1, end, arr);
		}
	}

	private static int partition(int start, int end, int[] arr) {
		int pivot = arr[end];
		int partitionIndex = (start - 1); // index of smaller element
		for (int i = start; i < end; i++) {
			// If current element is smaller than the pivot
			if (arr[i] < pivot) {
				partitionIndex++;

				// swap arr[i] and arr[partitionIndex]
				int temp = arr[partitionIndex];
				arr[partitionIndex] = arr[i];
				arr[i] = temp;
			}
		}

		// swap arr[partitionIndex+1] and arr[end] (or pivot)
		int temp = arr[partitionIndex + 1];
		arr[partitionIndex + 1] = arr[end];
		arr[end] = temp;

		return partitionIndex + 1;
	}
}
