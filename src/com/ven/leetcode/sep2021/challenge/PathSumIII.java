package com.ven.leetcode.sep2021.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * Given the root of a binary tree and an integer targetSum, return the number
 * of paths where the sum of the values along the path equals targetSum.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go
 * downwards (i.e., traveling only from parent nodes to child nodes).
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8 Output: 3
 * Explanation: The paths that sum to 8 are shown. Example 2:
 * 
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22 Output:
 * 3
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 1000]. -109 <= Node.val
 * <= 109 -1000 <= targetSum <= 1000
 * 
 * @author Venkatesh Manohar
 *
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class PathSumIII {
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

	public static void main(String[] args) {

	}

}
