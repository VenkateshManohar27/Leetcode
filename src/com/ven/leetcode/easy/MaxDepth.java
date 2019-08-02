package com.ven.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
	}
	
	public int maxDepthIterative(TreeNode root) {
		// Base Case 
        if (root == null) 
            return 0; 
   
        // Create an empty queue for level order tarversal 
        Queue<TreeNode> q = new LinkedList<TreeNode>(); 
   
        // Enqueue Root and initialize height 
        q.add(root); 
        int height = 0; 
   
        while (true)  
        { 
            // nodeCount (queue size) indicates number of nodes 
            // at current lelvel. 
            int nodeCount = q.size(); 
            if (nodeCount == 0) 
                return height; 
            height++; 
   
            // Dequeue all nodes of current level and Enqueue all 
            // nodes of next level 
            while (nodeCount > 0)  
            { 
            	TreeNode newnode = q.peek(); 
                q.remove(); 
                if (newnode.left != null) 
                    q.add(newnode.left); 
                if (newnode.right != null) 
                    q.add(newnode.right); 
                nodeCount--; 
            } 
        } 
	}
}