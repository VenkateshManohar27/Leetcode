package com.ven.leetcode.nov.challenge;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root node of a binary search tree, return the sum of values of all
 * nodes with a value in the range [low, high].
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15 Output: 32 Example 2:
 * 
 * 
 * Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10 Output: 23
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 2 * 104]. 1 <= Node.val
 * <= 105 1 <= low <= high <= 105 All Node.val are unique.
 * 
 * @author Venkatesh Manohar
 *
 */
public class RangeSumBST {
	public int rangeSumBST(TreeNode root, int low, int high) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		int sum = 0;
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (node.val >= low && node.val <= high)
				sum += node.val;

			if (node.left != null && node.val > low) {
				q.offer(node.left);
			}

			if (node.right != null && node.val < high) {
				q.offer(node.right);
			}

		}
		return sum;
	}
}
