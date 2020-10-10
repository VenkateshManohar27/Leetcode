package com.ven.leetcode.oct.challenge;

import java.util.LinkedList;
import java.util.Queue;

import com.ven.leetcode.tree.TreeNode;

/**
 * Serialization is converting a data structure or object into a sequence of
 * bits so that it can be stored in a file or memory buffer, or transmitted
 * across a network connection link to be reconstructed later in the same or
 * another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary search tree. There
 * is no restriction on how your serialization/deserialization algorithm should
 * work. You need to ensure that a binary search tree can be serialized to a
 * string, and this string can be deserialized to the original tree structure.
 * 
 * The encoded string should be as compact as possible.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: root = [2,1,3] Output: [2,1,3] Example 2:
 * 
 * Input: root = [] Output: []
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 104]. 0 <= Node.val <=
 * 104 The input tree is guaranteed to be a binary search tree.
 * 
 * @author Venkatesh Manohar
 *
 */
// works faster
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        
        return sb.toString(); 
    }
    
    private void serializeHelper(TreeNode root, StringBuilder sb) {
         if(root==null)
            return;
        sb.append(root.val).append(',');   
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);  
    }
    

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.isEmpty())
            return null;
        String[] arr = data.split(",");
        int[] nums = new int[arr.length];
        int i=0;
        for(String s: arr)
            nums[i++] = Integer.valueOf(s);
        
        return deserializeHelper(nums, new int[]{0},
                                 Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode deserializeHelper(int[] nums, int[] index, int lo, int hi) {
       int currIndex = index[0];
        if(currIndex >= nums.length)
            return null;
         
        if(nums[currIndex] > hi || nums[currIndex] < lo) {
            --index[0];
            return null;
        }
       
        TreeNode root = new TreeNode(nums[currIndex]);
        
        index[0]++;
        root.left = deserializeHelper(nums, index, lo, nums[currIndex]);
        
        index[0]++;
        root.right = deserializeHelper(nums, index, nums[currIndex], hi);
        return root;
        
    }
}
public class SerializeDeserializeBST {
	// Encodes a tree to a single string. Use DFS to make it simple
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		if (root == null) {
			return "";
		}
		dfs(sb, root);
		return sb.toString();
	}

	private void dfs(StringBuilder sb, TreeNode root) {
		if (root == null) {
			sb.append("$,");
			return;
		}
		sb.append(root.val + ",");
		dfs(sb, root.left);
		dfs(sb, root.right);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		System.out.println(data);
		if (data == null || data.length() == 0) {
			return null;
		}
		String[] strs = data.split(",");
		Queue<String> q = new LinkedList<String>();
		for (int i = 0; i < strs.length; i++) {
			q.add(strs[i]);
		}
		return helper(q);
	}

	private TreeNode helper(Queue<String> q) {
		String s = q.poll();
		if("$".endsWith(s)) return null;
		TreeNode node = new TreeNode(Integer.parseInt(s));
		node.left = helper(q);
		node.right = helper(q);
		return node;
	}
}
