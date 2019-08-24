package com.ven.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Stack<Integer> st = new Stack<>();
		if (candidates == null || candidates.length == 0) {
			return list;
		}
		combinationSum(candidates, 0, target, st, list);
		return list;
	}

	private void combinationSum(int[] candidates, int index, int target, Stack<Integer> st, List<List<Integer>> list) {
		if (target == 0) {
			List<Integer> sumlist = new ArrayList<>();
			sumlist.addAll(st);
			list.add(sumlist);
			return;
		}
		
		if (target < 0) {
			return;
		}
		
		if (index < candidates.length) {
			int value = candidates[index];
			st.push(value);
			combinationSum(candidates, index, target - value, st, list);
			st.pop();
			combinationSum(candidates, index + 1, target, st, list);
		}
	}

	public static void main(String[] args) {
		CombinationSum sum = new CombinationSum();
		List<List<Integer>> list = sum.combinationSum(new int[] { 2, 3, 5 }, 8);
		System.out.println(list);
	}
}
