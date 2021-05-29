package com.ven.leetcode.week16A;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences {
	public List<List<Integer>> findSubsequences(int[] nums) {
		List<List<Integer>> l = new ArrayList<>();
		helper(nums, 0, new ArrayList<>(), l);
		return l;
	}

	private void helper(int[] n, int ind, List<Integer> li, List<List<Integer>> l) {
		if (li.size() > 1) {
			l.add(new ArrayList<>(li));
		}

		Set<Integer> set = new HashSet<>();
		for (int i = ind; i < n.length; ++i) {
			if (!set.add(n[i]))
				continue;
			if (li.isEmpty() || n[i] >= li.get(li.size() - 1)) {
				li.add(n[i]);
				helper(n, i + 1, li, l);
				li.remove(li.size() - 1);
			}

		}
	}

	public static void main(String[] args) {
		IncreasingSubsequences i = new IncreasingSubsequences();
		System.out.println(i.findSubsequences(new int[] { 4, 6, 7, 7 }));

	}
}
