package com.ven.leetcode.dec.challenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.ven.leetcode.tree.TreeNode;

/**
 * Given a non-empty binary tree, return the average value of the nodes on each
 * level in the form of an array. Example 1: Input: 3 / \ 9 20 / \ 15 7 Output:
 * [3, 14.5, 11] Explanation: The average value of nodes on level 0 is 3, on
 * level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11]. Note: The
 * range of node's value is in the range of 32-bit signed integer.
 * 
 * @author Venkatesh Manohar
 *
 */
public class AveragLevelsBinaryTree {
	public List<Double> averageOfLevels(TreeNode root) {
        List<Double> l = new ArrayList<>();
        if(root == null){
            return l;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            int divisor = size;
            double sum = 0;
            while(size > 0){
                TreeNode n = q.poll();
                sum += n.val;
                if(n.left != null)
                    q.offer(n.left);
                if(n.right != null)
                    q.offer(n.right);
                size--;
            }
            l.add(sum/divisor);
            
        }
        return l;
    }
}
