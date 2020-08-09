package com.ven.leetcode.augchallenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers, 1 <= a[i] <= n (n = size of array), some elements
 * appear twice and others appear once.
 * 
 * Find all the elements that appear twice in this array.
 * 
 * Could you do it without extra space and in O(n) runtime?
 * 
 * Example: Input: [4,3,2,7,8,2,3,1]
 * 
 * Output: [2,3]
 * 
 * @author Venkatesh Manohar
 *
 */
public class FindAllDuplicatesArray {
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> li = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] < 0) {
				li.add(index+1);
			} else {
				nums[index] = -nums[index];
			}
		}
		return li;
	}

	public static void main(String[] args) {
		FindAllDuplicatesArray fd = new FindAllDuplicatesArray();
		System.out.println(fd.findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
	}

}
