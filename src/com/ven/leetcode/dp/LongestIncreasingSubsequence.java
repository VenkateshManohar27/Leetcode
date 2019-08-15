package com.ven.leetcode.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	public int countIncreasingSubsequence(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int max = 0;
		int[] arr = new int[nums.length];
		Arrays.fill(arr, 1);
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				System.out.println("-----------------------------------------------");
				System.out.println("nums[i]:"+nums[i]);
				System.out.println("nums[j]:"+nums[j]);
				System.out.println("arr[i]:"+arr[i]);
				System.out.println("arr[j]:"+arr[j]);

				if(nums[i] > nums[j] && arr[i] < arr[j] + 1) {
					arr[i] = arr[j]+1;
					if(arr[i]> max) {
						max = arr[i];
					}
				}
				System.out.println("after");
				System.out.println("arr[i]:"+arr[i]);
				System.out.println("max: "+max);
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int nums[] = { 10, 22, 9, 33, 21, 50, 41, 60 }; 
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        System.out.println(lis.countIncreasingSubsequence(nums));
	}
}
