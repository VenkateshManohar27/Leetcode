package com.ven.leetcode.oct.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen
 * numbers sum to target. You may return the combinations in any order.
 * 
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen
 * numbers is different.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: candidates = [2,3,6,7], target = 7 Output: [[2,2,3],[7]] Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple
 * times. 7 is a candidate, and 7 = 7. These are the only two combinations.
 * Example 2:
 * 
 * Input: candidates = [2,3,5], target = 8 Output: [[2,2,2,2],[2,3,3],[3,5]]
 * Example 3:
 * 
 * Input: candidates = [2], target = 1 Output: [] Example 4:
 * 
 * Input: candidates = [1], target = 1 Output: [[1]] Example 5:
 * 
 * Input: candidates = [1], target = 2 Output: [[1,1]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= candidates.length <= 30 1 <= candidates[i] <= 200 All elements of
 * candidates are distinct. 1 <= target <= 500
 * 
 * @author Venkatesh Manohar
 *
 */
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> combinations = new ArrayList<List<Integer>>();
		if (candidates == null || candidates.length == 0) {
			return combinations;
		}
		// Arrays.sort(candidates);
		helper(target, 0, candidates, new ArrayList<>(), combinations);
		return combinations;
	}

	private void helper(int target, int index, int[] candidates, List<Integer> list, List<List<Integer>> combinations) {
		if (target == 0) {
			combinations.add(new ArrayList<>(list));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			if (target - candidates[i] >= 0) {
				list.add(candidates[i]);
				helper(target - candidates[i], i, candidates, list, combinations);
				list.remove(list.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		CombinationSum c = new CombinationSum();
		System.out.println(c.combinationSum(new int[] { 2, 3, 6, 7 }, 7));
		System.out.println(c.combinationSum(new int[] { 2, 3, 5 }, 8));
		System.out.println(c.combinationSum(new int[] { 2 }, 1));
		System.out.println(c.combinationSum(new int[] { 1 }, 1));
		System.out.println(c.combinationSum(new int[] { 1 }, 2));
		System.out.println(c.combinationSum(new int[] { 2, 4, 6, 8 }, 9));
	}
}
