package com.ven.leetcode.june2021.challenge;

/**
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of
 * s1 and s2.
 * 
 * An interleaving of two strings s and t is a configuration where they are
 * divided into non-empty substrings such that:
 * 
 * s = s1 + s2 + ... + sn t = t1 + t2 + ... + tm |n - m| <= 1 The interleaving
 * is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 * Note: a + b is the concatenation of strings a and b.
 * 
 * Example 1:
 * 
 * 
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac" Output: true Example 2:
 * 
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc" Output: false Example 3:
 * 
 * Input: s1 = "", s2 = "", s3 = "" Output: true
 * 
 * 
 * Constraints:
 * 
 * 0 <= s1.length, s2.length <= 100 0 <= s3.length <= 200 s1, s2, and s3 consist
 * of lowercase English letters.
 * 
 * 
 * Follow up: Could you solve it using only O(s2.length) additional memory
 * space?
 * 
 * @author Venkatesh Manohar
 *
 */
// TLE
public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}

		return helper(s1, 0, s2, 0, s3, "");
	}

	private boolean helper(String s1, int i, String s2, int j, String s3, String res) {
		if (i == s1.length() && j == s2.length() && res.equals(s3)) {
			return true;
		}
		boolean ans = false;
		if (i < s1.length()) {
			ans |= helper(s1, i + 1, s2, j, s3, res + s1.charAt(i));
		}

		if (j < s2.length()) {
			ans |= helper(s1, i, s2, j + 1, s3, res + s2.charAt(j));
		}
		return ans;
	}

}

class InterleavingStringMemo {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		int[][] memo = new int[s1.length()][s2.length()];
		return helper(s1, 0, s2, 0, s3, 0, memo);
	}

	private boolean helper(String s1, int i, String s2, int j, String s3, int k, int[][] m) {
		if (i == s1.length()) {
			return s2.substring(j).equals(s3.substring(k));
		}
		if (j == s2.length()) {
			return s1.substring(i).equals(s3.substring(k));
		}
		if (m[i][j] > 0) {
			return m[i][j] == 2 ? true : false;
		}
		boolean ans = false;
		if ((s1.charAt(i) == s3.charAt(k) && helper(s1, i + 1, s2, j, s3, k + 1, m))
				|| (s2.charAt(j) == s3.charAt(k) && helper(s1, i, s2, j + 1, s3, k + 1, m))) {
			ans = true;
		}

		m[i][j] = (ans) ? 2 : 1;
		return ans;
	}

}
