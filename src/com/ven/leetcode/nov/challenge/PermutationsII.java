package com.ven.leetcode.nov.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Given a collection of numbers, nums, that might contain duplicates, return
 * all possible unique permutations in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,2] Output: [[1,1,2], [1,2,1], [2,1,1]] Example 2:
 * 
 * Input: nums = [1,2,3] Output:
 * [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 8 -10 <= nums[i] <= 10
 * 
 * @author Venkatesh Manohar
 *
 */
public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		helper(nums, new HashSet<Integer>(), new ArrayList<>(), l);
		return l;
	}

	private void helper(int[] nums, HashSet<Integer> s, ArrayList<Integer> li, List<List<Integer>> l) {
		if (li.size() == nums.length) {
			l.add(new ArrayList<>(li));
			return;
		}

		for (int i = 0; i < nums.length; i++) {

			if (s.contains(i)) {
				continue;
			}
			if (i > 0 && nums[i] == nums[i - 1] && !s.contains(i - 1)) {
				continue;
			}
			s.add(i);
			li.add(nums[i]);
			helper(nums, s, li, l);
			li.remove(li.size() - 1);
			s.remove(i);
		}
	}
}
