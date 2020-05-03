package com.ven.leetcode.string;

import java.util.HashMap;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * Example 1:
 * 
 * Input: s = "egg", t = "add" Output: true Example 2:
 * 
 * Input: s = "foo", t = "bar" Output: false Example 3:
 * 
 * Input: s = "paper", t = "title" Output: true Note: You may assume both s and
 * t have the same length.
 * 
 * @author Venkatesh Manohar
 *
 */
public class Isomorphic {
	public boolean isIsomorphic(String s, String t) {
		if ((s == null && t == null) || s.length() != t.length()) {
			return false;
		}
		HashMap<Character, Character> map1 = new HashMap<>();
		HashMap<Character, Character> map2 = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char s1 = s.charAt(i);
			char t1 = t.charAt(i);
			if (!map1.containsKey(s1) && !map2.containsKey(t1)) {
				map1.put(s1, t1);
				map2.put(t1, s1);
			} else {
				Character s2 = map2.get(t1);
				Character t2 = map1.get(s1);
				if (s2 == null || s2 != s1 || t2 == null || t2 != t1) {
					return false;
				}
			}

		}

		return true;
	}
}
