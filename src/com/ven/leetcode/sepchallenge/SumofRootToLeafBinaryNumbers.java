package com.ven.leetcode.sepchallenge;

/**
 * Given a binary tree, each node has value 0 or 1. Each root-to-leaf path
 * represents a binary number starting with the most significant bit. For
 * example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent
 * 01101 in binary, which is 13.
 * 
 * For all leaves in the tree, consider the numbers represented by the path from
 * the root to that leaf.
 * 
 * Return the sum of these numbers.
 * 
 * @author Venkatesh Manohar
 *
 */
public class SumofRootToLeafBinaryNumbers {
	public int sumRootToLeafUtil(TreeNode root, int val) {
        if(root == null)
            return 0;
        
        val = val * 2 + root.val;
        
        //if leaf node
        if(root.left == null && root.right == null) {
            return val;
        }
        
        return sumRootToLeafUtil(root.left, val)
                 + sumRootToLeafUtil(root.right, val);
    }
    
    public int sumRootToLeaf(TreeNode root) {
        return sumRootToLeafUtil(root, 0);
    }

	public static void main(String[] args) {
		SumofRootToLeafBinaryNumbers s = new SumofRootToLeafBinaryNumbers();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(1);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(1);

		System.out.println(s.sumRootToLeaf(root));

		root = new TreeNode(1);
		root.left = new TreeNode(1);
		System.out.println(s.sumRootToLeaf(root));
	}
}
