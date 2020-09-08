package com.ven.leetcode.bweek34;

import java.util.TreeMap;

/**
 * Given an integer array arr, remove a subarray (can be empty) from arr such
 * that the remaining elements in arr are non-decreasing.
 * 
 * A subarray is a contiguous subsequence of the array.
 * 
 * Return the length of the shortest subarray to remove.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [1,2,3,10,4,2,3,5] Output: 3 Explanation: The shortest subarray
 * we can remove is [10,4,2] of length 3. The remaining elements after that will
 * be [1,2,3,3,5] which are sorted. Another correct solution is to remove the
 * subarray [3,10,4]. Example 2:
 * 
 * Input: arr = [5,4,3,2,1] Output: 4 Explanation: Since the array is strictly
 * decreasing, we can only keep a single element. Therefore we need to remove a
 * subarray of length 4, either [5,4,3,2] or [4,3,2,1]. Example 3:
 * 
 * Input: arr = [1,2,3] Output: 0 Explanation: The array is already
 * non-decreasing. We do not need to remove any elements. Example 4:
 * 
 * Input: arr = [1] Output: 0
 * 
 * 
 * Constraints:
 * 
 * 1 <= arr.length <= 10^5 0 <= arr[i] <= 10^9
 * 
 * @author Venkatesh Manohar
 *
 */
public class ShortestSubarrayRemovedMakeArraySorted {
	public int findLengthOfShortestSubarray(int[] arr) {
		int n = arr.length;
		int s = 0, e = n - 1, i, max, min;
		TreeMap<Integer, Integer> firstHalf = new TreeMap<>();
		// step 1(a) of above algo
		for (s = 0; s < n - 1; s++) {
			firstHalf.put(arr[s], s);
			if (arr[s] > arr[s + 1])
				break;
		}
		if (s == n - 1) {
			return 0;
		}
		TreeMap<Integer, Integer> secHalf = new TreeMap<>();
		// step 1(b) of above algo
		for (e = n - 1; e > 0; e--) {
			secHalf.put(arr[e], e);
			if (arr[e] < arr[e - 1])
				break;
		}
		int length = Integer.MAX_VALUE;
		for (int l = e; l < n; l++) {
			if(firstHalf.ceilingEntry(arr[e])==null) {
				
			}
			
		}
		return length;
	}

	public static void main(String[] args) {
		ShortestSubarrayRemovedMakeArraySorted s = new ShortestSubarrayRemovedMakeArraySorted();
		System.out.println(s.findLengthOfShortestSubarray(new int[] { 1, 2, 3, 10, 4, 2, 3, 5 }));
		System.out.println(s.findLengthOfShortestSubarray(new int[] { 5, 4, 3, 2, 1 }));
		System.out.println(s.findLengthOfShortestSubarray(new int[] { 1, 2, 3 }));
		System.out.println(s.findLengthOfShortestSubarray(new int[] { 1 }));
	}
}
