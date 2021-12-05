package com.ven.leetcode.dec2021.challenge;

import java.util.HashMap;

import com.ven.leetcode.tree.TreeNode;

/**
 * The thief has found himself a new place for his thievery again. There is only
 * one entrance to this area, called root.
 * 
 * Besides the root, each house has one and only one parent house. After a tour,
 * the smart thief realized that all houses in this place form a binary tree. It
 * will automatically contact the police if two directly-linked houses were
 * broken into on the same night.
 * 
 * Given the root of the binary tree, return the maximum amount of money the
 * thief can rob without alerting the police.
 * 
 * Example 1:
 * 
 * Input: root = [3,2,3,null,3,null,1] Output: 7 Explanation: Maximum amount of
 * money the thief can rob = 3 + 3 + 1 = 7. Example 2:
 * 
 * Input: root = [3,4,5,1,3,null,1] Output: 9 Explanation: Maximum amount of
 * money the thief can rob = 4 + 5 = 9.
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 104]. 0 <= Node.val <=
 * 104
 * 
 * @author Venkatesh Manohar
 *
 */
public class HouseRobberIII {
	HashMap<TreeNode, Integer> robResult = new HashMap<>();
    HashMap<TreeNode, Integer> notRobResult = new HashMap<>();

    public int helper(TreeNode node, boolean parentRobbed) {
        if (node == null) {
            return 0;
        }
        if (parentRobbed) {
            if (robResult.containsKey(node)) {
                return robResult.get(node);
            }
            int result = helper(node.left, false) + helper(node.right, false);
            robResult.put(node, result);
            return result;
        } else {
            if (notRobResult.containsKey(node)) {
                return notRobResult.get(node);
            }
            int rob = node.val + helper(node.left, true) + helper(node.right, true);
            int notRob = helper(node.left, false) + helper(node.right, false);
            int result = Math.max(rob, notRob);
            notRobResult.put(node, result);
            return result;
        }
    }
    public int rob(TreeNode root) {
        return helper(root, false);
    }
}
