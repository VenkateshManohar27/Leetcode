package com.ven.leetcode.week2;

/**
 * You are given two strings s and t.
 * 
 * String t is generated by random shuffling string s and then add one more
 * letter at a random position.
 * 
 * Return the letter that was added to t.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abcd", t = "abcde" Output: "e" Explanation: 'e' is the letter
 * that was added. Example 2:
 * 
 * Input: s = "", t = "y" Output: "y" Example 3:
 * 
 * Input: s = "a", t = "aa" Output: "a" Example 4:
 * 
 * Input: s = "ae", t = "aea" Output: "a"
 * 
 * 
 * Constraints:
 * 
 * 0 <= s.length <= 1000 t.length == s.length + 1 s and t consist of lower-case
 * English letters.
 * 
 * @author Venkatesh Manohar
 *
 */
public class FindtheDifference {
	public char findTheDifference(String s, String t) {
		int[] chars = new int[26];

		for (int i = 0; i < s.length(); i++) {
			chars[s.charAt(i) - 'a']++;
			chars[t.charAt(i) - 'a']--;
		}

		chars[t.charAt(t.length() - 1) - 'a']--;
		int index = -1;
		for (int i = 0; i < 26; i++) {
			if (chars[i] != 0) {
				index = i;
				break;
			}
		}

		return (char) ('a' + index);
	}

	public static void main(String[] args) {
		FindtheDifference f = new FindtheDifference();
		System.out.println(f.findTheDifference("abcd", "abcde"));
	}

}