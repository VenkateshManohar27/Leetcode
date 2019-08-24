package com.ven.sorting;

public class MergeSort {

	public void sort(int[] arr, int low, int high) {
		System.out.println("low:" + low + " , high:" + high);
		if (low < high) {
			int mid = low + (high - low) / 2;
			System.out.println("mid:" + mid);
			sort(arr, low, mid);
			sort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	}

	private void merge(int[] arr, int low, int mid, int high) {
		int length1 = (mid - low) + 1;
		int length2 = high - mid;
		int[] leftarray = new int[length1];
		int[] rightarray = new int[length2];
		for (int i = 0; i < leftarray.length; i++) {
			leftarray[i] = arr[low + i];
		}

		for (int i = 0; i < rightarray.length; i++) {
			rightarray[i] = arr[mid + 1 + i];
		}

		print(leftarray);
		print(rightarray);
		print(arr);
		int left = 0;
		int right = 0;
		int index = low;
		while (left < length1 && right < length2) {
			if (leftarray[left] <= rightarray[right]) {
				arr[index++] = leftarray[left++];
			} else if (leftarray[left] > rightarray[right]) {
				arr[index++] = rightarray[right++];
			}
		}
		while (left < length1) {
			arr[index++] = leftarray[left++];
		}
		while (right < length2) {
			arr[index++] = rightarray[right++];
		}
	}

	public static void print(int arr[]) {
		System.out.println("Array is : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " |");
		}
		System.out.println();
	}

	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };

		System.out.println("Given Array");
		print(arr);

		MergeSort ms = new MergeSort();
		ms.sort(arr, 0, arr.length - 1);

		System.out.println("\nSorted array");
		print(arr);
	}
}
