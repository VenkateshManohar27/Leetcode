package com.ven.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find all possible combinations of k numbers that add up to a number n, given
 * that only numbers from 1 to 9 can be used and each combination should be a
 * unique set of numbers.
 * 
 * Note:
 * 
 * All numbers will be positive integers. The solution set must not contain
 * duplicate combinations. Example 1:
 * 
 * Input: k = 3, n = 7 Output: [[1,2,4]] Example 2:
 * 
 * Input: k = 3, n = 9 Output: [[1,2,6], [1,3,5], [2,3,4]]
 * 
 * @author Venkatesh Manohar
 *
 */
public class CombinationSumIII {

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> combinations = new ArrayList<List<Integer>>();
		if (k == 0 || n <= 0) {
			return combinations;
		}
		helper(k, 1, n, 0, new HashSet<Integer>(), combinations);
		return combinations;
	}

	private void helper(int k, int start, int number, int sum, Set<Integer> set,
			List<List<Integer>> combinations) {
		if (k == set.size()) {
			if (sum == number) {
				combinations.add(new ArrayList<Integer>(set));
			}
			return;
		}
		for (int i = start; i <= 9; i++) {
			if (set.contains(i)) {
				continue;
			}
			set.add(i);
			helper(k, i + 1, number, sum + i, set, combinations);
			set.remove(i);
		}

	}

	public static void main(String[] args) {
		CombinationSumIII cs = new CombinationSumIII();
		System.out.println(cs.combinationSum3(3, 7));
		System.out.println(cs.combinationSum3(3, 9));
		System.out.println(cs.combinationSum3(3, 0));

	}
}
