package com.vm.logicmojo.array;

/**
 * We rotate an ascending order sorted array at some point unknown to user. So
 * for instance, 3 4 5 6 7 might become 5 6 7 3 4. Modify binary search
 * algorithm to find an element in the rotated array in O(log n) time and O(1)
 * Space complexity
 * 
 * Example:
 * 
 * array[] = {3,4,5,6,7,8,9,10,1,2} Search Number = 1 Output: 8 [Hint: Use
 * Binary Search] Problem level: Medium
 * 
 * @author Venkatesh Manohar
 *
 */
public class SearchRotatedSortedArray {
	static int findNumber(int array[], int start, int end, int value) {
		int pivot = findIndex(array, start, end);
		if (pivot == -1) {
			return binarySearch(start, end, value, array);
		}

		if (array[pivot] == value) {
			return pivot;
		}

		if (array[0] <= value)
			return binarySearch(0, pivot - 1, value, array);

		return binarySearch(pivot + 1, end, value, array);
	}

	private static int binarySearch(int start, int end, int value, int[] a) {
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (a[mid] == value) {
				return mid;
			} else if (a[mid] > value) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	private static int findIndex(int[] a, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = (start + (end - start) / 2);
		if (mid < end && a[mid] > a[mid + 1]) {
			return mid;
		}
		if (mid > start && a[mid] < a[mid - 1]) {
			return mid - 1;
		}

		if (a[start] > a[mid]) {
			return findIndex(a, start, mid - 1);
		} else {
			return findIndex(a, mid + 1, end);
		}
	}

	public static void main(String args[]) {
		int array[] = { 3, 4, 5, 6, 7, 8, 9, 1, 2 };
		int n = array.length;
		int value = 1;
		int i = findNumber(array, 0, n - 1, value);
		if (i != -1)
			System.out.println("Index: " + i);
		else
			System.out.println("Value not found");
	}
}
