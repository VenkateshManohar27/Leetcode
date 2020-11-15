package com.ven.sorting;

import com.ven.utility.ArrayUtility;

public class BubbleSort {

	public static void main(String[] args) {
		BubbleSort b = new BubbleSort();
		
		ArrayUtility.print(b.sort(new int[] {9,8,7,4,3,1}));
	}

	public int[] sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 1; j < a.length; j++) {
				if(a[j-1]>a[j]) {
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				}
			}
		}
		return a;
	}
}
