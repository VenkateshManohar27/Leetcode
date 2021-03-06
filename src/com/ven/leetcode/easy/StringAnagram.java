package com.ven.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's
 * anagrams in s.
 * 
 * Strings consists of lowercase English letters only and the length of both
 * strings s and p will not be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * Example 1:
 * 
 * Input: s: "cbaebabacd" p: "abc"
 * 
 * Output: [0, 6]
 * 
 * Explanation: The substring with start index = 0 is "cba", which is an anagram
 * of "abc". The substring with start index = 6 is "bac", which is an anagram of
 * "abc". Example 2:
 * 
 * Input: s: "abab" p: "ab"
 * 
 * Output: [0, 1, 2]
 * 
 * Explanation: The substring with start index = 0 is "ab", which is an anagram
 * of "ab". The substring with start index = 1 is "ba", which is an anagram of
 * "ab". The substring with start index = 2 is "ab", which is an anagram of
 * "ab".
 * 
 * @author Venkatesh Manohar
 *
 */
public class StringAnagram {
	public List<Integer> findAnagrams2(String s, String p) {
		List<Integer> list = new ArrayList<>();
		if (s == null || s.length() == 0 || p == null || p.length() == 0)
			return list;
		int[] hash = new int[26]; // character hash
		// record each character in p to hash
		for (char c : p.toCharArray()) {
			hash[c - 'a']++;
		}
		// two points, initialize count to p's length
		int left = 0, right = 0, count = p.length();
		while (right < s.length()) {
			// move right everytime, if the character exists in p's hash, decrease the count
			// current hash value >= 1 means the character is existing in p
			if (hash[s.charAt(right++) - 'a']-- >= 1)
				count--;

			// when the count is down to 0, means we found the right anagram
			// then add window's left to result list
			if (count == 0)
				list.add(left);

			// if we find the window's size equals to p, then we have to move left (narrow
			// the window) to find the new match window
			// ++ to reset the hash because we kicked out the left
			// only increase the count if the character is in p
			// the count >= 0 indicate it was original in the hash, cuz it won't go below 0
			if (right - left == p.length() && hash[s.charAt(left++) - 'a']++ >= 0)
				count++;
		}
		return list;
	}

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<>();
		if (s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length())
			return list;
		int[] countS = new int[26]; // character hash
		int[] countP = new int[26]; // character hash

		for (int i = 0; i < p.length(); i++) {
			countS[s.charAt(i) - 'a']++;
			countP[p.charAt(i) - 'a']++;
		}

		for (int i = p.length(); i < s.length(); i++) {
			if (compare(countS, countP))
				list.add(i - p.length());

			// Add current character to current
			// window
			(countS[s.charAt(i) - 'a'])++;

			// Remove the first character of previous
			// window
			countS[s.charAt(i - p.length()) - 'a']--;
		}

		if (compare(countP, countS))
			list.add(s.length() - p.length());

		return list;
	}

	private boolean compare(int[] countS, int[] countP) {
		for (int i = 0; i < 26; i++) {
			if (countP[i] != countS[i])
				return false;
		}
		return true;
	}

}
