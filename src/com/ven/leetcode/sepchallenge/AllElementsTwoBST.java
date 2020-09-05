package com.ven.leetcode.sepchallenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

/**
 * Given two binary search trees root1 and root2.
 * 
 * Return a list containing all the integers from both trees sorted in ascending
 * order.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root1 = [2,1,4], root2 = [1,0,3] Output: [0,1,1,2,3,4] Example 2:
 * 
 * Input: root1 = [0,-10,10], root2 = [5,1,7,0,2] Output: [-10,0,0,1,2,5,7,10]
 * Example 3:
 * 
 * Input: root1 = [], root2 = [5,1,7,0,2] Output: [0,1,2,5,7] Example 4:
 * 
 * Input: root1 = [0,-10,10], root2 = [] Output: [-10,0,10] Example 5:
 * 
 * 
 * Input: root1 = [1,null,8], root2 = [8,1] Output: [1,1,8,8]
 * 
 * @author Venkatesh Manohar
 *
 */
public class AllElementsTwoBST {
	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		List<Integer> li1 = new ArrayList<>();
		traverse(root1, li1);
		List<Integer> li2 = new ArrayList<>();
		traverse(root2, li2);
		li1.addAll(li2);
		Collections.sort(li1);
		return li1;
	}

	private void traverse(TreeNode node, List<Integer> li) {
		if (node == null) {
			return;
		}
		li.add(node.val);
		traverse(node.left, li);
		traverse(node.right, li);
	}

	public List<Integer> invoke(Integer[] a, Integer[] b) {
		TreeNode root1 = buildTree(a, 1, a.length);
		TreeNode root2 = buildTree(b, 1, b.length);
		return getAllElements(root1, root2);
	}

	private TreeNode buildTree(Integer[] a, int start, int end) {
		if (start > end || a[start-1] == null) {
			return null;
		}
		TreeNode node = new TreeNode(a[start-1]);
		node.left = buildTree(a, start * 2, end);
		node.right = buildTree(a, start * 2 + 1, end);
		return node;
	}

	public static void main(String[] args) {
		AllElementsTwoBST b = new AllElementsTwoBST();
		System.out.println(b.invoke(new Integer[] { 2, 1, 4 }, new Integer[] { 1, 0, 3 }));
		System.out.println(b.invoke(new Integer[] { 0, -10, 10 }, new Integer[] { 5, 1, 7, 0, 2 }));
		System.out.println(b.invoke(new Integer[] {}, new Integer[] { 5, 1, 7, 0, 2 }));
		System.out.println(b.invoke(new Integer[] { 0, -10, 10 }, new Integer[] {}));
		System.out.println(b.invoke(new Integer[] { 1, null, 8 }, new Integer[] { 8, 1 }));
	}
}
