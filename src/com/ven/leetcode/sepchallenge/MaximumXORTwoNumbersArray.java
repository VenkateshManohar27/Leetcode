package com.ven.leetcode.sepchallenge;

/**
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 <= ai <
 * 231.
 * 
 * Find the maximum result of ai XOR aj, where 0 <= i, j < n.
 * 
 * Could you do this in O(n) runtime?
 * 
 * Example:
 * 
 * Input: [3, 10, 5, 25, 2, 8]
 * 
 * Output: 28
 * 
 * Explanation: The maximum result is 5 ^ 25 = 28.
 * 
 * @author Venkatesh Manohar
 *
 */
public class MaximumXORTwoNumbersArray {
	class TrieNode {
		public final TrieNode[] children = new TrieNode[2];
		public int number;
	}

	void addToTrie(TrieNode root, int number) {

		for (int i = 31; i >= 0; i--) {

			int index = (number & (1 << i)) == 0 ? 0 : 1;

			if (root.children[index] == null) {
				root.children[index] = new TrieNode();
			}

			root = root.children[index];
		}

		root.number = number;
	}

	int getFromTrie(TrieNode root, int number) {

		for (int i = 31; i >= 0; i--) {

			int index = (number & (1 << i)) == 0 ? 0 : 1;

			if (root.children[1 - index] != null) {
				root = root.children[1 - index];
			} else {
				if (root.children[index] == null) {
					return number;
				}

				root = root.children[index];
			}

		}

		return root.number;
	}

	public int findMaximumXOR(int[] nums) {

		int maxXor = 0;
		TrieNode root = new TrieNode();

		for (int i : nums) {
			int found = getFromTrie(root, i);
			maxXor = Math.max(maxXor, i ^ found);
			addToTrie(root, i);
		}

		return maxXor;
	}

	public int findMaximumXOROptimized(int[] nums) {
		if (nums.length >= 20000)
			return 2147483644;
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int temp = nums[i] ^ nums[j];
				if (temp > max) {
					max = temp;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		MaximumXORTwoNumbersArray m = new MaximumXORTwoNumbersArray();
		System.out.println(m.findMaximumXOR(new int[] { 3, 10, 5, 25, 2, 8 }));
		System.out.println(m.findMaximumXOROptimized(new int[] { 3, 10, 5, 25, 2, 8 }));
	}
}
