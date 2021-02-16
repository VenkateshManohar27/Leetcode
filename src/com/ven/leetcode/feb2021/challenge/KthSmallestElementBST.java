package com.ven.leetcode.feb2021.challenge;

import java.util.ArrayList;
import java.util.List;

import com.ven.leetcode.tree.TreeNode;

/**
 * Given the root of a binary search tree, and an integer k, return the kth
 * (1-indexed) smallest element in the tree.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,1,4,null,2], k = 1 Output: 1 Example 2:
 * 
 * 
 * Input: root = [5,3,6,2,4,null,null,1], k = 3 Output: 3
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is n. 1 <= k <= n <= 104 0 <= Node.val <= 104
 * 
 * 
 * Follow up: If the BST is modified often (i.e., we can do insert and delete
 * operations) and you need to find the kth smallest frequently, how would you
 * optimize?
 * 
 * @author Venkatesh Manohar
 *
 */
public class KthSmallestElementBST {
	public int kthSmallest(TreeNode root, int k) {
		List<Integer> l = new ArrayList<>();
		populate(root, l);
		// Collections.sort(l);
		return l.get(k - 1);
	}

	private void populate(TreeNode node, List<Integer> l) {
		if (node == null) {
			return;
		}
		populate(node.left, l);
		l.add(node.val);
		populate(node.right, l);
	}
}
