package com.algorithms.sort;

public class BubbleSort {

	public static void main(String[] args) {
		int arr[] = { 3, -1, 5, 7, 8, 6, 0, 5 };
		// sort method
		int sortedArr[] = bubbleSort(arr);
		System.out.println("Sorted Array --> ");
		for (int i = 0; i < sortedArr.length; i++) {
			System.out.print(sortedArr[i]);
			if (i != sortedArr.length - 1) {
				System.out.print(",");
			}
		}
	}

	/**
	 * Perf worst: O(n^2), average: O(n^2), best = O(n) when array already sorted
	 * @param arr
	 * @return
	 */
	private static int[] bubbleSort(int[] arr) {
		int length = arr.length;
		boolean swapped = false;
		for (int i = 0; i < length; i++) {
			swapped = false;
			for (int j = 0; j < length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			if(!swapped) {
				break;
			}
		}

		return arr;
	}

}
