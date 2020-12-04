package com.ven.leetcode.dec.challenge;

/**
 * Given an array of integers nums.
 * 
 * A pair (i,j) is called good if nums[i] == nums[j] and i < j.
 * 
 * Return the number of good pairs.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,1,1,3] Output: 4 Explanation: There are 4 good pairs
 * (0,3), (0,4), (3,4), (2,5) 0-indexed. Example 2:
 * 
 * Input: nums = [1,1,1,1] Output: 6 Explanation: Each pair in the array are
 * good. Example 3:
 * 
 * Input: nums = [1,2,3] Output: 0
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 100 1 <= nums[i] <= 100
 * 
 * @author Venkatesh Manohar
 *
 */
public class NumberOfGoodPairs {
	public int numIdenticalPairs(int[] nums) {
		int[] n = new int[101];
		for (int i = 0; i < nums.length; i++) {
			n[nums[i]]++;
		}
		int count = 0;
		for (int i = 0; i < n.length; i++) {
			// System.out.println(n[i]);
			if (n[i] > 1) {
				count += ((n[i] * (n[i] - 1)) / 2);
			}
		}
		return count;
	}
}
