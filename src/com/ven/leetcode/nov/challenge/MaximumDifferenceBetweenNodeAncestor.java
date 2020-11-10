package com.ven.leetcode.nov.challenge;

/**
 * Given the root of a binary tree, find the maximum value V for which there
 * exist different nodes A and B where V = |A.val - B.val| and A is an ancestor
 * of B.
 * 
 * A node A is an ancestor of B if either: any child of A is equal to B, or any
 * child of A is an ancestor of B.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [8,3,10,1,6,null,14,null,null,4,7,13] Output: 7 Explanation: We
 * have various ancestor-node differences, some of which are given below : |8 -
 * 3| = 5 |3 - 7| = 4 |8 - 1| = 7 |10 - 13| = 3 Among all possible differences,
 * the maximum value of 7 is obtained by |8 - 1| = 7. Example 2:
 * 
 * 
 * Input: root = [1,null,2,null,0,3] Output: 3
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [2, 5000]. 0 <= Node.val <=
 * 105
 * 
 * @author Venkatesh Manohar
 *
 */
public class MaximumDifferenceBetweenNodeAncestor {
	private int max = Integer.MIN_VALUE;

	public int maxAncestorDiff(TreeNode root) {
		helper(root);
		return max;
	}

	private MinMax helper(TreeNode node) {
		if (node.left == null && node.right == null) {
			return new MinMax(node.val, node.val);
		}

		MinMax left = (node.left != null) ? helper(node.left) : new MinMax();
		MinMax right = (node.right != null) ? helper(node.right) : new MinMax();
		// check min max for all sub tree
		if (left.min != Integer.MAX_VALUE) {
			max = Math.max(max, Math.abs(node.val - left.min));
		}
		if (left.max != Integer.MIN_VALUE) {
			max = Math.max(max, Math.abs(node.val - left.max));
		}
		if (right.min != Integer.MAX_VALUE) {
			max = Math.max(max, Math.abs(node.val - right.min));
		}
		if (right.max != Integer.MIN_VALUE) {
			max = Math.max(max, Math.abs(node.val - right.max));
		}
		MinMax m = new MinMax(node.val, node.val);
		m.min = Math.min(m.min, left.min);
		m.min = Math.min(m.min, right.min);
		m.max = Math.max(m.max, left.max);
		m.max = Math.max(m.max, right.max);
		// System.out.println("min:"+m.min+", max:"+m.max);
		return m;
	}
}

class MinMax {
	int min = Integer.MAX_VALUE;
	int max = Integer.MIN_VALUE;

	public MinMax() {

	}

	public MinMax(int min, int max) {
		this.min = min;
		this.max = max;
	}
}
