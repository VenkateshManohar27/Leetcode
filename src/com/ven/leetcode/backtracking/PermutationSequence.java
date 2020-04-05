package com.ven.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * he set [1,2,3,...,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, we get the
 * following sequence for n = 3:
 * 
 * "123" "132" "213" "231" "312" "321" Given n and k, return the kth permutation
 * sequence.
 * 
 * Note:
 * 
 * Given n will be between 1 and 9 inclusive. Given k will be between 1 and n!
 * inclusive. Example 1:
 * 
 * Input: n = 3, k = 3 Output: "213" Example 2:
 * 
 * Input: n = 4, k = 9 Output: "2314"
 * 
 * @author Venkatesh Manohar
 *
 */
public class PermutationSequence {
	public String getPermutation(int n, int k) {
		int[] nums = new int[n];
		Arrays.setAll(nums, i -> i + 1);
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		return helper(new int[] { k }, new ArrayList<>(), nums, used);

	}

	private String helper(int[] k, ArrayList<Integer> list, int[] nums, boolean[] used) {
		if (list.size() == nums.length) {
			if (--k[0] == 0) {
				return list.stream().map(i -> Integer.toString(i)).reduce("", String::concat);
			}
		} else if (list.size() < nums.length) {
			for (int i = 0; i < nums.length; i++) {
				if (!used[i]) {
					if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
						continue;
					}
					used[i] = true;
					list.add(nums[i]);
					String res = helper(k, list, nums, used);
					if (!res.isEmpty()) {
						return res;
					}
					list.remove(list.size() - 1);
					used[i] = false;
				}

			}
		}
		return "";
	}

	public static void main(String[] args) {
		PermutationSequence ps = new PermutationSequence();
		System.out.println(ps.getPermutation(3, 3));
		System.out.println(ps.getPermutation(4, 9));
	}
}
