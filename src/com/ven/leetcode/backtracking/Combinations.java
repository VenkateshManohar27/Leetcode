package com.ven.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> combinations = new ArrayList<>();
		helper(n, k,0, new ArrayList<Integer>(), combinations);
		return combinations;
	}

	private void helper(int n, int k,int idx, List<Integer> li, List<List<Integer>> combinations) {
		if (k == li.size()) {
			combinations.add(new ArrayList<>(li));
			return;
		}

		for (int i = idx; i < n; i++) {
			List<Integer> p = new ArrayList<>(li);
			p.add(i+1);
			helper(n, k, idx+1, p, combinations);
			

		}
	}

	public List<List<Integer>> combine2(int n, int k) {
		List<Integer> nums = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			nums.add(i);
		}
		List<List<Integer>> ret = new ArrayList<>();
		dfs(nums, k, 0, new ArrayList<>(), ret);
		return ret;
	}

	private void dfs(List<Integer> nums, int k, int idx, List<Integer> path, List<List<Integer>> ret) {
		if (k == 0) {
			ret.add(path);
			return; // backtracking
		}
		for (int i = idx; i < nums.size(); i++) {
			List<Integer> p = new ArrayList<>(path);
			p.add(nums.get(i));
			dfs(nums, k - 1, i + 1, p, ret);
		}
	}

	public static void main(String[] args) {
		Combinations c = new Combinations();
		System.out.println(c.combine(4, 2));
	}
}
