package com.ven.sorting;

import com.ven.utility.ArrayUtility;

public class InsertionSort {
	public int[] sort(int[] a) {
		
		for (int i = 1; i < a.length; i++) {
			int val = a[i];
			int ind = i;
			while(ind > 0 && a[ind-1]>val) {
				a[ind] = a[ind-1];
				ind --;
			}
			a[ind] = val;
		}
		return a;
	}
	
	public static void main(String[] args) {
		InsertionSort b = new InsertionSort();
		
		ArrayUtility.print(b.sort(new int[] {9,8,7,4,3,1}));
	}
}
