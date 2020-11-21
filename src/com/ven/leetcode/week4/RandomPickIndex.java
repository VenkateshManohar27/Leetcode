package com.ven.leetcode.week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Given an array of integers with possible duplicates, randomly output the
 * index of a given target number. You can assume that the given target number
 * must exist in the array.
 * 
 * Note: The array size can be very large. Solution that uses too much extra
 * space will not pass the judge.
 * 
 * Example:
 * 
 * int[] nums = new int[] {1,2,3,3,3}; Solution solution = new Solution(nums);
 * 
 * // pick(3) should return either index 2, 3, or 4 randomly. Each index should
 * have equal probability of returning. solution.pick(3);
 * 
 * // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(1);
 * 
 * @author Venkatesh Manohar
 *
 */
public class RandomPickIndex {

	Map<Integer, List<Integer>> map = new HashMap<>();
	Random rand = new Random();

	public RandomPickIndex(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>());
            map.get(nums[i]).add(i);
        }
    }

	public int pick(int target) {
		int l = map.get(target).size();
		// pick an index at random
		int randomIndex = map.get(target).get(rand.nextInt(l));
		return randomIndex;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3,3,3};
		RandomPickIndex solution = new RandomPickIndex(nums);

		// pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
		System.out.println(solution.pick(3));

		// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
		System.out.println(solution.pick(1));
	}
}
