package com.ven.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Input:
 * 
 * 1 / \ 2 3 \ 5
 * 
 * Output: ["1->2->5", "1->3"]
 * 
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 * 
 * @author Venkatesh Manohar
 *
 */
public class BinaryTreePath {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new ArrayList<>();
		if (root == null) {
			return paths;
		}
		generatePaths(root, paths, new StringBuilder().append(root.val));
		return paths;
	}

	private void generatePaths(TreeNode node, List<String> paths, StringBuilder sb) {
		if (node == null) {
			return;
		}
		StringBuilder leftTreePath = new StringBuilder().append(sb);
		if (node.left != null) {
			leftTreePath.append("->").append(node.left.val);
		}
		generatePaths(node.left, paths, leftTreePath);

		StringBuilder rightTreePath = new StringBuilder().append(sb);
		if (node.right != null) {
			rightTreePath.append("->").append(node.right.val);
		}
		if (node.right != null) {
			generatePaths(node.right, paths, rightTreePath);
		}

		if (node.left == null && node.right == null) {
			paths.add(sb.toString());
		}
	}

	public List<String> binaryTreePathsOptimized(TreeNode root) {
		List<String> paths = new ArrayList<>();
		if (root == null) {
			return paths;
		}
		//generatePathsOptimized(root, paths, new StringBuilder());
		helper(paths, root, new StringBuilder());
		return paths;
	}

	private void generatePathsOptimized(TreeNode node, List<String> paths, StringBuilder sb) {
		if (node == null) {
			return;
		}
		int len = sb.length();
		sb.append(node.val);
		if (node.left == null && node.right == null) {
			paths.add(sb.toString());
		} else {
			sb.append("->");
			generatePaths(node.left, paths, sb);
			generatePaths(node.right, paths, sb);
		}
		sb.setLength(len);
	}
	
	private void helper(List<String> res, TreeNode root, StringBuilder sb) {
	    if(root == null) {
	        return;
	    }
	    int len = sb.length();
	    sb.append(root.val);
	    if(root.left == null && root.right == null) {
	        res.add(sb.toString());
	    } else {
	        sb.append("->");
	        helper(res, root.left, sb);
	        helper(res, root.right, sb);
	    }
	    sb.setLength(len);
	}
}
