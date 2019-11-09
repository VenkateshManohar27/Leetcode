package com.vm.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum
 * of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 * @author Venkatesh Manohar
 *
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> threesum = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 2) {
			return threesum;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			 int left = i+1;
	            int right = nums.length-1;
	            int x =  nums[i];
	            while(left < right) {
	                if((x + nums[left]+ nums[right]) == 0){
	                    
	                	threesum.add(Arrays.asList(x, nums[left], nums[right]));
	                    while(left < right && nums[left] == nums[left + 1]) left++;
					while(left < right && nums[right] == nums[right - 1]) right--;
	                    left++;
	                    right--;
	                } else if((x + nums[left]+ nums[right]) < 0){
	                    left++;
	                } else {
	                    right--;
	                }
	            }while (i < nums.length - 2 && nums[i] == nums[i+1]) i++;
		}

		return threesum;
	}
	
	public static void main(String[] args) {
		ThreeSum ts = new ThreeSum();
		System.out.println(ts.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
		
	}
}
