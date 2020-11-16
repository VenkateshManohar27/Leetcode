package com.ven.sorting;

import com.ven.utility.ArrayUtility;

public class MergeSortII {
	public int[] sort(int[] a, int start, int end) {
		if(start < end) {
			int mid = start + (end-start)/2;
			sort(a, start, mid);
			sort(a, mid+1, end);
			merge(a, start,mid, end);
		}
		return a;
	}
	
	
	private void merge(int[] a, int start, int mid, int end) {
		int[] temp = new int[end - start + 1];
		int i = start;
		int j = mid + 1;
		int index = 0;
		
		while(i <= mid && j<=end) {
			if(a[i] <= a[j]) {
				temp[index++] = a[i++];
			}else {
				temp[index++] = a[j++];
			}
		}
		
		while(i<=mid) {
			temp[index++] = a[i++];
		}
		while(j<=end) {
			temp[index++] = a[j++];
		}
		
		i = start;
		for (int k = 0; k < temp.length; k++) {
			a[i++] = temp[k];
		}
		
	}


	public static void main(String[] args) {
		MergeSortII m = new MergeSortII();
		
		ArrayUtility.print(m.sort(new int[] {9,8,7,4,3,1}, 0, 5));
	}

	
}
