package com.ven.leetcode.dp;

import java.util.Arrays;

import com.ven.utility.ArrayUtility;

/**
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Example:
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4], Output: 6 Explanation: [4,-1,2,1] has the
 * largest sum = 6. Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * 
 * @author Venkatesh Manohar
 *
 */
public class MaximumSubarray {
	public static int maxSubArray(int[] nums) {
		int maxSum = nums[0];
		int sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum = Math.max(nums[i], sum + nums[i]);
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}
	
	static class MaxSum{
		int sum;
		int start;
		int end;
		public MaxSum(int sum, int start, int end) {
			super();
			this.sum = sum;
			this.start = start;
			this.end = end;
		}
		
		
	}
	public static int[] maxSubArrayAndReturnTheElements(int[] nums) {
		MaxSum ms = new MaxSum(nums[0], 0, 1);
		int sum = nums[0];
		int start = 0;
		int end = 0;
		for (int i = 1; i < nums.length; i++) {
			if( nums[i] > sum+nums[i]) {
				start = i;
				end =i;
				sum = nums[i];
			}else {
				end  = i;
				sum =  sum + nums[i];
			}
			if(ms.sum < sum) {
				ms.sum = sum;
				ms.start = start;
				ms.end = end;
			}
		}
		return Arrays.copyOfRange(nums, ms.start, ms.end+1);
	}

	public static void main(String[] args) {
		MaximumSubarray ms = new MaximumSubarray();
		ArrayUtility.print(ms.maxSubArrayAndReturnTheElements(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
	}
}
