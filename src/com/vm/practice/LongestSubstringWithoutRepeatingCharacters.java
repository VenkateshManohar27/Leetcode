package com.vm.practice;

import java.util.HashSet;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * Example 1:
 * 
 * Input: "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length
 * of 3. Example 2:
 * 
 * Input: "bbbbb" Output: 1 Explanation: The answer is "b", with the length of
 * 1. Example 3:
 * 
 * Input: "pwwkew" Output: 3 Explanation: The answer is "wke", with the length
 * of 3. Note that the answer must be a substring, "pwke" is a subsequence and
 * not a substring.
 * 
 * @author Venkatesh Manohar
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int i = 0, j = 0;
		int max = 0;
		HashSet<Character> set = new HashSet<>();
		while (j < s.length()) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j));
				max = Math.max(max, set.size());
				j++;
			} else {
				set.remove(s.charAt(i));
				i++;
			}
		}
		return max;
	}

	public int lengthOfLongestSubstring2(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int i = 0, j = 0;
		int max = 0;
		int[] chars = new int[256];
		while (j < s.length()) {
			int c = s.charAt(j);
			if(chars[c] == 0) {
				chars[c]++;
				j++;
			}else {
				chars[s.charAt(i)]--;
				i++;
			}
			max = Math.max(j-i, max);
		}
		return max;
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
		System.out
				.println("LongestSubstringWithoutRepeatingCharacters of null is " + ls.lengthOfLongestSubstring(null));
		System.out.println("LongestSubstringWithoutRepeatingCharacters of a is " + ls.lengthOfLongestSubstring("a"));
		System.out.println(
				"LongestSubstringWithoutRepeatingCharacters of abcabcbb is " + ls.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(
				"LongestSubstringWithoutRepeatingCharacters of bbbbb is " + ls.lengthOfLongestSubstring("bbbbb"));
		System.out.println(
				"LongestSubstringWithoutRepeatingCharacters of pwwkew is " + ls.lengthOfLongestSubstring("pwwkew"));

		
		System.out
		.println("LongestSubstringWithoutRepeatingCharacters of null is " + ls.lengthOfLongestSubstring2(null));
System.out.println("LongestSubstringWithoutRepeatingCharacters of a is " + ls.lengthOfLongestSubstring2("a"));
System.out.println(
		"LongestSubstringWithoutRepeatingCharacters of abcabcbb is " + ls.lengthOfLongestSubstring2("abcabcbb"));
System.out.println(
		"LongestSubstringWithoutRepeatingCharacters of bbbbb is " + ls.lengthOfLongestSubstring2("bbbbb"));
System.out.println(
		"LongestSubstringWithoutRepeatingCharacters of pwwkew is " + ls.lengthOfLongestSubstring2("pwwkew"));

System.out.println(
		"LongestSubstringWithoutRepeatingCharacters of ' ' is " + ls.lengthOfLongestSubstring2(" "));
	}
}
