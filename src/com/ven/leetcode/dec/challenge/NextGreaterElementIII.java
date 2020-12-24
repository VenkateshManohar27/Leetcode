package com.ven.leetcode.dec.challenge;

/**
 * Given a positive integer n, find the smallest integer which has exactly the
 * same digits existing in the integer n and is greater in value than n. If no
 * such positive integer exists, return -1.
 * 
 * Note that the returned integer should fit in 32-bit integer, if there is a
 * valid answer but it does not fit in 32-bit integer, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 12 Output: 21 Example 2:
 * 
 * Input: n = 21 Output: -1
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 231 - 1
 * 
 * @author Venkatesh Manohar
 *
 */
public class NextGreaterElementIII {
	public int nextGreaterElement(int n) {
		String s = String.valueOf(n);
		char[] arr = s.toCharArray();
		int i, j;
		for (i = arr.length - 1; i > 0; i--) {
			if (arr[i] > arr[i - 1])
				break;
		}

		if (i == 0)
			return -1;
		int num = arr[i - 1], smallest = i;

		for (j = i + 1; j < arr.length; j++)
			if (arr[j] > num && arr[j] <= arr[smallest])
				smallest = j;

		swap(arr, i - 1, smallest);
		reverse(arr, i, arr.length - 1);

		long val = Long.parseLong(new String(arr));
		return (val <= Integer.MAX_VALUE) ? (int) val : -1;
	}

	private void reverse(char[] arr, int left, int right) {
		while (left < right) {
			swap(arr, left, right);
			left++;
			right--;
		}
	}

	private void swap(char[] arr, int left, int right) {
		char tmp = arr[left];
		arr[left] = arr[right];
		arr[right] = tmp;
	}
}
