package com.ven.leetcode.june2021.challenge;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * You are given an integer array matchsticks where matchsticks[i] is the length
 * of the ith matchstick. You want to use all the matchsticks to make one
 * square. You should not break any stick, but you can link them up, and each
 * matchstick must be used exactly one time.
 * 
 * Return true if you can make this square and false otherwise.
 * 
 * Example 1:
 * 
 * Input: matchsticks = [1,1,2,2,2] Output: true Explanation: You can form a
 * square with length 2, one side of the square came two sticks with length 1.
 * Example 2:
 * 
 * Input: matchsticks = [3,3,3,3,4] Output: false Explanation: You cannot find a
 * way to form a square with all the matchsticks.
 * 
 * Constraints:
 * 
 * 1 <= matchsticks.length <= 15 1 <= matchsticks[i] <= 108
 * 
 * @author Venkatesh Manohar
 *
 */
public class MatchstickstoSquare {
	public List<Integer> nums;
	public int[] sums;
	public int possibleSquareSide;

	public MatchstickstoSquare() {
		this.sums = new int[4];
	}

	// Depth First Search function.
	public boolean dfs(int index) {

		// If we have exhausted all our matchsticks, check if all sides of the square
		// are of equal length
		if (index == this.nums.size()) {
			return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
		}

		// Get current matchstick.
		int element = this.nums.get(index);

		// Try adding it to each of the 4 sides (if possible)
		for (int i = 0; i < 4; i++) {
			if (this.sums[i] + element <= this.possibleSquareSide) {
				this.sums[i] += element;
				if (this.dfs(index + 1)) {
					return true;
				}
				this.sums[i] -= element;
			}
		}

		return false;
	}

	public boolean makesquare(int[] nums) {
		// Empty matchsticks.
		if (nums == null || nums.length == 0) {
			return false;
		}

		// Find the perimeter of the square (if at all possible)
		int L = nums.length;
		int perimeter = 0;
		for (int i = 0; i < L; i++) {
			perimeter += nums[i];
		}

		this.possibleSquareSide = perimeter / 4;
		if (this.possibleSquareSide * 4 != perimeter) {
			return false;
		}

		// Convert the array of primitive int to ArrayList (for sorting).
		this.nums = Arrays.stream(nums).boxed().collect(Collectors.toList());
		Collections.sort(this.nums, Collections.reverseOrder());
		return this.dfs(0);
	}
}
