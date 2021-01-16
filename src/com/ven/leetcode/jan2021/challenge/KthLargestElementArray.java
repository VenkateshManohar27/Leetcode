package com.ven.leetcode.jan2021.challenge;

import java.util.Arrays;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * Example 1:
 * 
 * Input: [3,2,1,5,6,4] and k = 2 Output: 5 Example 2:
 * 
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4 Output: 4 Note: You may assume k is
 * always valid, 1 <= k <= array's length.
 * 
 * @author Venkatesh Manohar
 *
 */
public class KthLargestElementArray {
	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		for (int i = nums.length - 1; i >= 0; i--) {
			k--;
			if (k == 0) {
				return nums[i];
			}
		}
		return -1;
	}
}
