package com.ven.leetcode.feb2021.challenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ven.leetcode.tree.TreeNode;

/**
 * Given an integer n, return all the structurally unique BST's (binary search
 * trees), which has exactly n nodes of unique values from 1 to n. Return the
 * answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3 Output:
 * [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * Example 2:
 * 
 * Input: n = 1 Output: [[1]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 8
 * 
 * @author Venkatesh Manohar
 *
 */
public class UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> l = new ArrayList<TreeNode>();
		Set<Integer> s = new HashSet<>();
		for (int i = 1; i <= n; i++) {
			s.add(i);
			TreeNode root = new TreeNode(i);
			helper(1, root, n, l, s, root);
			s.remove(i);
		}

		return l;
	}

	private void helper(int i, TreeNode t, int n, List<TreeNode> l, Set<Integer> s, TreeNode node) {
		if (i == n) {
			l.add(t);
			return;
		}
		for (int j = 1; j <= n; j++) {
			if (s.contains(j)) {
				continue;
			}
			int val = node.val;
			if (j > val) {
				s.add(j);
				TreeNode child = new TreeNode(j);
				node.right = child;
				helper(i+1, t, n, l, s, child);
				//node.right = null;
				s.remove(j);
			} else {
				s.add(j);
				TreeNode child = new TreeNode(j);
				node.left = child;
				helper(i+1, t, n, l, s, child);
				//node.left = null;
				s.remove(j);
			}
		}
	}
	
	public static void main(String[] args) {
		UniqueBinarySearchTreesII u = new UniqueBinarySearchTreesII();
		System.out.println(u.generateTrees(3));
	}
}
