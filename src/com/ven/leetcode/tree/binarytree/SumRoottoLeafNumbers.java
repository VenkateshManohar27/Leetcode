package com.ven.leetcode.tree.binarytree;

import java.util.ArrayList;
import java.util.List;

import com.ven.leetcode.tree.TreeNode;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Input: [1,2,3] 1 / \ 2 3 Output: 25 Explanation: The root-to-leaf path 1->2
 * represents the number 12. The root-to-leaf path 1->3 represents the number
 * 13. Therefore, sum = 12 + 13 = 25. Example 2:
 * 
 * Input: [4,9,0,5,1] 4 / \ 9 0 / \ 5 1 Output: 1026 Explanation: The
 * root-to-leaf path 4->9->5 represents the number 495. The root-to-leaf path
 * 4->9->1 represents the number 491. The root-to-leaf path 4->0 represents the
 * number 40. Therefore, sum = 495 + 491 + 40 = 1026.
 * 
 * @author Venkatesh Manohar
 *
 */

public class SumRoottoLeafNumbers {
	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}

		List<Integer> li = new ArrayList<Integer>();
		helper(root, li, "");
		int sum = 0;
		for (Integer i : li) {
			sum += i;
		}
		return sum;
	}
	
	private void helper(TreeNode root, List<Integer> li, String s) {
		if(root == null) {
			return;
		}
		s += root.val;
		if (root.left == null && root.right == null) {
			li.add(Integer.parseInt(s));
			return;
		}
		
		helper(root.left, li, s);
		helper(root.right, li,  s);
	}
	
	class Sum {
		int sum = 0;
	}
	public int sumNumbersEfficient(TreeNode root) {
		if (root == null) {
			return 0;
		}

		Sum sum = new Sum();
		helperEfficient(root, 0, sum);
		return sum.sum;
	}
	
	private void helperEfficient(TreeNode root, int num, Sum finalSum) {
		if(root == null) {
			return;
		}
		num = num* 10 + root.val;
		if (root.left == null && root.right == null) {
			finalSum.sum += num;
			return;
		}
		
		helperEfficient(root.left, num, finalSum);
		helperEfficient(root.right, num,  finalSum);
	}

	/*private void helper(TreeNode root, List<Integer> li, String s) {
		if (root.left == null && root.right == null) {
			li.add(Integer.parseInt(s));
			return;
		}
		int length = s.length();
		helper(root.left, li, (root.left != null) ? s+root.left.val: s);
		s = s.substring(0, length);
		helper(root.right, li, (root.right != null) ? s + root.right.val : s);
	}*/

}
