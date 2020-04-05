package com.practice.java;

//Java program for implementation of QuickSort 
public class QuickSort2 {

	// Driver program
	public static void main(String args[]) {
		int arr[] = { 10, 7, 8, 9, 1, 5, 3, 2 };
		int n = arr.length;

		QuickSort2 ob = new QuickSort2();
		ob.quickSort(arr, 0, n - 1);

		System.out.println("sorted array : ");
		printArray(arr);
	}

	/*
	 * This function takes last element as pivot, places the pivot element at its
	 * correct position in sorted array, and places all smaller (smaller than pivot)
	 * to left of pivot and all greater elements to right of pivot
	 */
	int partition(int arr[], int start, int end) {
		int pivot = arr[end];
		int partitionIndex = (start - 1); 
		for (int i = start; i < end; i++) {
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

	/*
	 * The main function that implements QuickSort() arr[] --> Array to be sorted,
	 * low --> Starting index, high --> Ending index
	 */
	void quickSort(int arr[], int start, int end) {
		if (start < end) {
			int pi = partition(arr, start, end);
			quickSort(arr, start, pi - 1);
			quickSort(arr, pi + 1, end);
		}
	}

	/* A utility function to print array of size n */
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
