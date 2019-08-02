package com.ven.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {
	public int backtrack(TreeNode root, int sum, int target, Map<Integer, Integer> map) {
		if (root == null)
			return 0;
		sum += root.val;
		int res = map.getOrDefault(sum - target, 0); // See if there is a subarray sum equals to target
		map.put(sum, map.getOrDefault(sum, 0) + 1); // Extend to left and right child

		res += backtrack(root.left, sum, target, map) + backtrack(root.right, sum, target, map);
		map.put(sum, map.get(sum) - 1);
		// \\Remove the current node so it wont affect other path
		return res;
	}

	public int pathSum(TreeNode root, int sum) {
		Map<Integer, Integer> pathSum = new HashMap<>();
		pathSum.put(0, 1);
		return backtrack(root, pathSum, sum, 0);
	}

	private int backtrack(TreeNode node, Map<Integer, Integer> pathSum, int target, int sum) {
		if (node == null)
			return 0;
		sum += node.val;
		int res = pathSum.getOrDefault(sum - target, 0);
		pathSum.put(sum, pathSum.getOrDefault(sum, 0) + 1);
		res += backtrack(node.left, pathSum, target, sum) + backtrack(node.right, pathSum, target, sum);
		pathSum.put(sum, pathSum.get(sum) - 1);
		return res;
	}

}
