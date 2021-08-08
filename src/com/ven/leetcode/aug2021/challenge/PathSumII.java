package com.ven.leetcode.aug2021.challenge;

import java.util.ArrayList;
import java.util.List;

import com.ven.leetcode.tree.TreeNode;

/**
 * Given the root of a binary tree and an integer targetSum, return all
 * root-to-leaf paths where each path's sum equals targetSum.
 * 
 * A leaf is a node with no children.
 * 
 * Example 1:
 * 
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22 Output:
 * [[5,4,11,2],[5,8,4,5]] Example 2:
 * 
 * Input: root = [1,2,3], targetSum = 5 Output: [] Example 3:
 * 
 * Input: root = [1,2], targetSum = 0 Output: []
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 5000]. -1000 <= Node.val
 * <= 1000 -1000 <= targetSum <= 1000
 * 
 * @author Venkatesh Manohar
 *
 */
public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, targetSum, res, new ArrayList<Integer>());
        return res;
    }
    
    private void helper(TreeNode n, int targetSum, List<List<Integer>> res, List<Integer> l){
        if(n == null){
            return;
        }
        l.add(n.val);
        if(targetSum == n.val && n.left == null && n.right == null){
            res.add(new ArrayList<>(l));
            return;
        }
        helper(n.left, targetSum-n.val, res, new ArrayList(l));
        helper(n.right, targetSum-n.val, res, new ArrayList(l));
    }
}
