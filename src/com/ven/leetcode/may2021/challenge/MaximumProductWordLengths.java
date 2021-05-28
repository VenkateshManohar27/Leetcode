package com.ven.leetcode.may2021.challenge;

/**
 * Given a string array words, return the maximum value of length(word[i]) *
 * length(word[j]) where the two words do not share common letters. If no such
 * two words exist, return 0.
 * 
 * Example 1:
 * 
 * Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"] Output: 16
 * Explanation: The two words can be "abcw", "xtfn". Example 2:
 * 
 * Input: words = ["a","ab","abc","d","cd","bcd","abcd"] Output: 4 Explanation:
 * The two words can be "ab", "cd". Example 3:
 * 
 * Input: words = ["a","aa","aaa","aaaa"] Output: 0 Explanation: No such pair of
 * words.
 * 
 * 
 * Constraints:
 * 
 * 2 <= words.length <= 1000 1 <= words[i].length <= 1000 words[i] consists only
 * of lowercase English letters.
 * 
 * @author Venkatesh Manohar
 *
 */
public class MaximumProductWordLengths {
	public int maxProduct(String[] words) {
		int res = 0;
		int[] bytes = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			int val = 0;
			for (int j = 0; j < words[i].length(); j++) {
				val |= 1 << (words[i].charAt(j) - 'a');
			}
			bytes[i] = val;
		}
		for (int i = 0; i < bytes.length; i++) {
			for (int j = i + 1; j < bytes.length; j++) {
				if ((bytes[i] & bytes[j]) == 0) {
					res = Math.max(res, words[i].length() * words[j].length());
				}
			}
		}
		return res;
	}
}
