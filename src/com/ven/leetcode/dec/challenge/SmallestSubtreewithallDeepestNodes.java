package com.ven.leetcode.dec.challenge;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import com.ven.leetcode.tree.TreeNode;
import com.ven.utility.TreeUtility;

/**
 * Given the root of a binary tree, the depth of each node is the shortest
 * distance to the root.
 * 
 * Return the smallest subtree such that it contains all the deepest nodes in
 * the original tree.
 * 
 * A node is called the deepest if it has the largest depth possible among any
 * node in the entire tree.
 * 
 * The subtree of a node is tree consisting of that node, plus the set of all
 * descendants of that node.
 * 
 * Note: This question is the same as 1123:
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4] Output: [2,7,4] Explanation: We
 * return the node with value 2, colored in yellow in the diagram. The nodes
 * coloured in blue are the deepest nodes of the tree. Notice that nodes 5, 3
 * and 2 contain the deepest nodes in the tree but node 2 is the smallest
 * subtree among them, so we return it. Example 2:
 * 
 * Input: root = [1] Output: [1] Explanation: The root is the deepest node in
 * the tree. Example 3:
 * 
 * Input: root = [0,1,3,null,2] Output: [2] Explanation: The deepest node in the
 * tree is 2, the valid subtrees are the subtrees of nodes 2, 1 and 0 but the
 * subtree of node 2 is the smallest.
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree will be in the range [1, 500]. 0 <= Node.val
 * <= 500 The values of the nodes in the tree are unique.
 * 
 * @author Venkatesh Manohar
 *
 */

/**
 * The result of a subtree is:
 *       Result.node: the largest depth node that is equal to or
 *                    an ancestor of all the deepest nodes of this subtree.
 *       Result.dist: the number of nodes in the path from the root
 *                    of this subtree, to the deepest node in this subtree.
 */
class Result {
    TreeNode node;
    int dist;
    Result(TreeNode n, int d) {
        node = n;
        dist = d;
    }
}
public class SmallestSubtreewithallDeepestNodes {
	private int maxDepth = 0;
	private HashMap<TreeNode, Integer> nodeDepth = null;

	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		if (root == null)
			return root;
		nodeDepth = new HashMap<>();
		nodeDepth.put(null, -1);
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int level = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			level++;
			if (!q.isEmpty()) {
				maxDepth = Math.max(maxDepth, level);
			}
			while (size > 0) {
				TreeNode node = q.poll();
				nodeDepth.put(node, level);
				if (node.left != null)
					q.offer(node.left);

				if (node.right != null)
					q.offer(node.right);

				size--;
			}

		}

		return answer(root);
	}

	private TreeNode answer(TreeNode node) {
		if (node == null || nodeDepth.get(node) == maxDepth) {
			return node;
		}
		TreeNode l = answer(node.left);
		TreeNode r = answer(node.right);
		if (l != null && r != null)
			return node;

		if (l != null)
			return l;

		if (r != null)
			return r;
		return null;
	}
	
	public TreeNode subtreeWithAllDeepestOptimized(TreeNode root) {
        return dfs(root).node;
    }
	
	public Result dfs(TreeNode root) {
		if(root == null) return new Result(root, 0);
		Result l = dfs(root.left);
		Result r = dfs(root.right);
		if(l.dist > r.dist) return new Result(l.node, l.dist + 1);
		if(l.dist < r.dist) return new Result(r.node, r.dist + 1);
		return new Result(root, l.dist + 1);
	}
	

	public static void main(String[] args) {
		SmallestSubtreewithallDeepestNodes s = new SmallestSubtreewithallDeepestNodes();
		s.subtreeWithAllDeepest(TreeUtility.generateTree(new Integer[] { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 }, 0));
	}
}
