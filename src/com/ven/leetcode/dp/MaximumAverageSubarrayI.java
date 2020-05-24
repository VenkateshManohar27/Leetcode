package com.ven.leetcode.dp;

/**
 * Given an array consisting of n integers, find the contiguous subarray of
 * given length k that has the maximum average value. And you need to output the
 * maximum average value.
 * 
 * Example 1:
 * 
 * Input: [1,12,-5,-6,50,3], k = 4 Output: 12.75 Explanation: Maximum average is
 * (12-5-6+50)/4 = 51/4 = 12.75
 * 
 * 
 * Note:
 * 
 * 1 <= k <= n <= 30,000. Elements of the given array will be in the range
 * [-10,000, 10,000].
 * 
 * @author Venkatesh Manohar
 *
 */
public class MaximumAverageSubarrayI {
	public double findMaxAverage(int[] nums, int k) {
		if(nums.length == 0) {
			return 0;
		}
		double max = Double.NEGATIVE_INFINITY;
		double sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i >= k-1) {
				//add the current element from array
				sum += nums[i];
				
				max = Math.max(max, sum);
				// remove the first element for next iteration
				sum -= nums[i-(k-1)];
				
			} else {
				sum += nums[i];
			}
		}

		return max/k;
	}

	public static void main(String[] args) {
		MaximumAverageSubarrayI mas = new MaximumAverageSubarrayI();
		System.out.println(mas.findMaxAverage(new int[] { 1, 12, -5, -6, 50, 3 }, 4));
		
		System.out.println(mas.findMaxAverage(new int[] { 5 }, 1));
		System.out.println(mas.findMaxAverage(new int[] {  }, 1));
		System.out.println(mas.findMaxAverage(new int[] {  -1}, 1));
		System.out.println(mas.findMaxAverage(new int[] {1,2,3 ,4 }, 3));
	}
}
