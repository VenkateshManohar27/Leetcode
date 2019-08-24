package com.ven.searching;

public class BinarySearchIterative {
	public int binarySearch(int[] arr, int x) {
		int low = 0;
		int high = arr.length-1;
		while (low < high) {
			int mid = low+(high-low)/2;
			System.out.println("mid:"+mid);
			if(arr[mid] == x ) {
				return mid;
			}else if(arr[mid] <= x) {
				low=mid+1;
			}else {
				high = mid-1;
			}
			
		}
		return -1;
	}

	public static void main(String args[]) {
		BinarySearchIterative bs = new BinarySearchIterative();
		int arr[] = { 2, 3, 4, 10, 40 };
		int n = arr.length;
		int x = 10;
		int result = bs.binarySearch(arr, x);
		if (result == -1)
			System.out.println("Element not present");
		else
			System.out.println("Element found at " + "index " + result);
	}

}
