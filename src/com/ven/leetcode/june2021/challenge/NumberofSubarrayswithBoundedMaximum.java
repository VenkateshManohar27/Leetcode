package com.ven.leetcode.june2021.challenge;

/**
 * We are given an array nums of positive integers, and two positive integers
 * left and right (left <= right).
 * 
 * Return the number of (contiguous, non-empty) subarrays such that the value of
 * the maximum array element in that subarray is at least left and at most
 * right.
 * 
 * Example: Input: nums = [2, 1, 4, 3] left = 2 right = 3 Output: 3 Explanation:
 * There are three subarrays that meet the requirements: [2], [2, 1], [3]. Note:
 * 
 * left, right, and nums[i] will be an integer in the range [0, 109]. The length
 * of nums will be in the range of [1, 50000].
 * 
 * @author Venkatesh Manohar
 *
 */
public class NumberofSubarrayswithBoundedMaximum {
	public int numSubarrayBoundedMax(int[] nums, int left, int right) {
		int count = 0;
        int i = 0;
        int j = 0;
        int windowSize = 0; 
        
        while(j < nums.length){
            if(nums[j]>=left && nums[j]<=right){
                windowSize = j - i + 1; 
            }else if(nums[j] > right){
                windowSize = 0;
                i = j + 1;
            }
            count+= windowSize;
            j++;
        }
        return count;
	}

	public static void main(String[] args) {
		NumberofSubarrayswithBoundedMaximum n = new NumberofSubarrayswithBoundedMaximum();
		System.out.println(n.numSubarrayBoundedMax(new int[] {2, 1, 4, 3}, 2, 3));
	}
}
