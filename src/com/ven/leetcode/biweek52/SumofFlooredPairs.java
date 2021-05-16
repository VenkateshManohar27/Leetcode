package com.ven.leetcode.biweek52;

/**
 * Given an integer array nums, return the sum of floor(nums[i] / nums[j]) for
 * all pairs of indices 0 <= i, j < nums.length in the array. Since the answer
 * may be too large, return it modulo 109 + 7.
 * 
 * The floor() function returns the integer part of the division.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,5,9] Output: 10 Explanation: floor(2 / 5) = floor(2 / 9) =
 * floor(5 / 9) = 0 floor(2 / 2) = floor(5 / 5) = floor(9 / 9) = 1 floor(5 / 2)
 * = 2 floor(9 / 2) = 4 floor(9 / 5) = 1 We calculate the floor of the division
 * for every pair of indices in the array then sum them up. Example 2:
 * 
 * Input: nums = [7,7,7,7,7,7,7] Output: 49
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105 1 <= nums[i] <= 105
 * 
 * @author Venkatesh Manohar
 *
 */
public class SumofFlooredPairs {
	public int sumOfFlooredPairs(int[] nums) {
		int MOD = 1_000_000_000 + 7;
		int n = nums.length;
		long res = 0;
		int[] count = new int[100_000 + 1];
		for (int num : nums) {
			count[num]++;
		}
		// preSum of counts, for getting range count
		int[] preSum = new int[100_000 + 2];
		for (int i = 1; i < preSum.length; i++) {
			preSum[i] = preSum[i - 1] + count[i - 1];
		}
		for (int i = 0; i < count.length; i++) {
			if (count[i] == 0) {
				continue;
			}
			int num = i;
			for (int p = 1; p * num <= 100_000; p++) {
				int max = num * (p + 1) - 1;
				int min = num * p;
				// how many nums in the range
				int c = preSum[Math.min(max + 1, preSum.length - 1)] - preSum[Math.min(min, preSum.length - 1)];
				long add = (long) c * p * count[num];
				res += add;
				res %= MOD;
			}
		}
		return (int) res;
	}
}
