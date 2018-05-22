package com.algorithms.sort;

public class InsertionSort {

	public static void main(String[] args) {
		InsertionSort inStr = new InsertionSort();
		int arr[] = { 3, 5, 6, -1, 0, 5, 7, 2, 8 };
		int sortedArr[] = inStr.insertionSort(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(sortedArr[i] + ",");
		}
	}

	private int[] insertionSort(int[] arr) {
		int length = arr.length;

		for (int i = 1; i < length; i++) {
			int data = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > data) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = data;
		}
		return arr;
	}

}
