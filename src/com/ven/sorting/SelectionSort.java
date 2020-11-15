package com.ven.sorting;

import com.ven.utility.ArrayUtility;

public class SelectionSort {
	
	public int[] sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i+1; j < arr.length; j++) {
				if(arr[j] <arr[min]) {
					min = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
		return arr;
	}

	public static void main(String[] args) {
		SelectionSort s = new SelectionSort();
		
		ArrayUtility.print(s.sort(new int[] {9,8,7,4,3,1}));
	}
}
