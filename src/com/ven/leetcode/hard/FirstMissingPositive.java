package com.ven.leetcode.hard;

import java.util.Arrays;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 * 
 * Example 1:
 * 
 * Input: [1,2,0] Output: 3 Example 2:
 * 
 * Input: [3,4,-1,1] Output: 2 Example 3:
 * 
 * Input: [7,8,9,11,12] Output: 1 Follow up:
 * 
 * Your algorithm should run in O(n) time and uses constant extra space.
 * 
 * @author Venkatesh Manohar
 *
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 1;
		}
		int[] numbers = new int[nums.length];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i+1;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] > 0 && nums[i] < nums.length) {
				numbers[nums[i]-1] = 0;
			}
		}
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] != 0)
				return numbers[i];
		}
		return 0;
	}
	
	public int firstMissingPositiveOptimized(int[] nums) 
    {
        for(int i = 0; i < nums.length; i++) 
        {
            while(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
        }
        
        for(int i = 0; i < nums.length; i++)
        {    
            if(nums[i] != i + 1)
                return i + 1;
        }
        return nums.length + 1;
    }

    private void swap(int[] A, int i, int j) 
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

	public static void main(String[] args) {
		FirstMissingPositive fmp = new FirstMissingPositive();
		System.out.println(fmp.firstMissingPositive(new int[] { 1, 2, 0 }));
		System.out.println(fmp.firstMissingPositive(new int[] { 3, 4, -1, 1 }));
		System.out.println(fmp.firstMissingPositive(new int[] { 7, 8, 9, 11, 12 }));
		
		System.out.println(fmp.firstMissingPositiveOptimized(new int[] { 1, 2, 0 }));
		System.out.println(fmp.firstMissingPositiveOptimized(new int[] { 3, 4, -1, 1 }));
		System.out.println(fmp.firstMissingPositiveOptimized(new int[] { 7, 8, 9, 11, 12 }));
	}
}
