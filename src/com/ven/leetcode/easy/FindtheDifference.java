package com.ven.leetcode.easy;

/**
 * Given two strings s and t which consist of only lowercase letters.
 * 
 * String t is generated by random shuffling string s and then add one more
 * letter at a random position.
 * 
 * Find the letter that was added in t.
 * 
 * Example:
 * 
 * Input: s = "abcd" t = "abcde"
 * 
 * Output: e
 * 
 * Explanation: 'e' is the letter that was added.
 * 
 * @author Venkatesh Manohar
 *
 */
public class FindtheDifference {
	public char findTheDifference(String s, String t) {

		int[] chars = new int[26];

		for (int i = 0; i < t.length(); i++) {
			chars[t.charAt(i) - 'a']++;
		}

		for (int i = 0; i < s.length(); i++) {
			chars[s.charAt(i) - 'a']--;
		}

		int index = 0;
		for (int i = 0; i < 26; i++) {
			if (chars[i] == 1) {
				index = i;
				break;
			}
		}

		return (char) ('a' + index);
	}

	public static void main(String[] args) {
		FindtheDifference fd = new FindtheDifference();
		System.out.println(fd.findTheDifference("abcd", "abcde"));
		System.out.println(fd.findTheDifference("a", "aa"));

	}
}