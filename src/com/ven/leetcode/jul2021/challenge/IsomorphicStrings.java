package com.ven.leetcode.jul2021.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings s and t are isomorphic if the characters in s can be replaced to
 * get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character, but a character may map to itself.
 * 
 * Example 1:
 * 
 * Input: s = "egg", t = "add" Output: true Example 2:
 * 
 * Input: s = "foo", t = "bar" Output: false Example 3:
 * 
 * Input: s = "paper", t = "title" Output: true
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 5 * 104 t.length == s.length s and t consist of any valid
 * ascii character.
 * 
 * @author Venkatesh Manohar
 *
 */
public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		Map<Character, Character> mapTS = new HashMap<>();
		Map<Character, Character> mapST = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char sc = s.charAt(i);
			char tc = t.charAt(i);
			if (mapST.containsKey(sc) && mapST.get(sc) != tc) {
				return false;
			} else {
				mapST.put(sc, tc);
			}

			if (mapTS.containsKey(tc) && mapTS.get(tc) != sc) {
				return false;
			} else {
				mapTS.put(tc, sc);
			}
		}
		return true;
	}
}
