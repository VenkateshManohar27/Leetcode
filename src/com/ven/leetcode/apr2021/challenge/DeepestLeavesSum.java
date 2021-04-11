package com.ven.leetcode.apr2021.challenge;

import com.ven.leetcode.tree.TreeNode;

/**
 * Given the root of a binary tree, return the sum of values of its deepest
 * leaves.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8] Output: 15 Example
 * 2:
 * 
 * Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5] Output: 19
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 104]. 1 <= Node.val <=
 * 100
 * 
 * @author Venkatesh Manohar
 *
 */
public class DeepestLeavesSum {
	public int deepestLeavesSum(TreeNode root) {
        if(root == null)
            return 0;
        int max = findMaxDepth(root, 0);
        //System.out.println("max:"+ max);
        return findSum(root, 0, max);
    }
    
    private int findSum(TreeNode node, int level, int max){
        if(node == null)
            return 0;
        if(level == max)
            return node.val;
        
        return findSum(node.left, level+1, max) + findSum(node.right, level+1,max);
    }
    private int findMaxDepth(TreeNode node, int level){
        if(node == null)
            return 0;
        
        if(node.left == null && node.right == null){
            return level;
        }
        
        return Math.max(findMaxDepth(node.left, level+1), findMaxDepth(node.right, level+1));
    }
}
