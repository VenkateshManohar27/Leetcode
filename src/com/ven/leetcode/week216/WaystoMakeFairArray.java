package com.ven.leetcode.week216;

/**
 * You are given an integer array nums. You can choose exactly one index
 * (0-indexed) and remove the element. Notice that the index of the elements may
 * change after the removal.
 * 
 * For example, if nums = [6,1,7,4,1]:
 * 
 * Choosing to remove index 1 results in nums = [6,7,4,1]. Choosing to remove
 * index 2 results in nums = [6,1,4,1]. Choosing to remove index 4 results in
 * nums = [6,1,7,4]. An array is fair if the sum of the odd-indexed values
 * equals the sum of the even-indexed values.
 * 
 * Return the number of indices that you could choose such that after the
 * removal, nums is fair.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,1,6,4] Output: 1 Explanation: Remove index 0: [1,6,4] ->
 * Even sum: 1 + 4 = 5. Odd sum: 6. Not fair. Remove index 1: [2,6,4] -> Even
 * sum: 2 + 4 = 6. Odd sum: 6. Fair. Remove index 2: [2,1,4] -> Even sum: 2 + 4
 * = 6. Odd sum: 1. Not fair. Remove index 3: [2,1,6] -> Even sum: 2 + 6 = 8.
 * Odd sum: 1. Not fair. There is 1 index that you can remove to make nums fair.
 * Example 2:
 * 
 * Input: nums = [1,1,1] Output: 3 Explanation: You can remove any index and the
 * remaining array is fair. Example 3:
 * 
 * Input: nums = [1,2,3] Output: 0 Explanation: You cannot make a fair array
 * after removing any index.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105 1 <= nums[i] <= 104
 * 
 * @author Venkatesh Manohar
 *
 */
public class WaystoMakeFairArray {
	public int waysToMakeFair(int[] nums) {

		int[] le = new int[nums.length];
		int[] lo = new int[nums.length];
		int[] re = new int[nums.length];
		int[] ro = new int[nums.length];

		for (int i = 0, j = nums.length - 1; i < ro.length && j >= 0; i++, j--) {
			if (i % 2 == 0) {
				le[i] = nums[i] + ((i > 0) ? le[i - 1] : 0);
				lo[i] = (i > 0) ? lo[i - 1] : 0;
			} else {
				lo[i] = nums[i] + lo[i - 1];
				le[i] = le[i - 1];
			}
			if (j % 2 == 0) {
				re[j] = nums[j] + ((j < nums.length - 1) ? re[j + 1] : 0);
				ro[j] = ((j < nums.length - 1) ? ro[j + 1] : 0);
			} else {
				ro[j] = nums[j] + ((j < nums.length - 1) ? ro[j + 1] : 0);
				re[j] = ((j < nums.length - 1) ? re[j + 1] : 0);
			}

		}
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int even = ((i > 0) ? le[i - 1] : 0) + ((i < nums.length - 1) ? ro[i + 1] : 0);
			int odd = ((i > 0) ? lo[i - 1] : 0) + ((i < nums.length - 1) ? re[i + 1] : 0);
			if (even == odd)
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		WaystoMakeFairArray w = new WaystoMakeFairArray();
		System.out.println(w.waysToMakeFair(new int[] { 2, 1, 6, 4 }));
		System.out.println(w.waysToMakeFair(new int[] { 1, 1, 1 }));
	}
}
