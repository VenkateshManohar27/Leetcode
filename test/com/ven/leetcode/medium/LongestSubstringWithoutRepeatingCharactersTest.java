package com.ven.leetcode.medium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


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
class LongestSubstringWithoutRepeatingCharactersTest {
	LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testNull() {
		assertEquals(0, l.lengthOfLongestSubstring(null));
	}

	@Test
	void testEmpty() {
		assertEquals(0, l.lengthOfLongestSubstring(""));
	}
	
	@Test
	void testStrings() {
		assertEquals(3, l.lengthOfLongestSubstring("abcabcbb"));
		assertEquals(1, l.lengthOfLongestSubstring("bbbbb"));
		assertEquals(3, l.lengthOfLongestSubstring("pwwkew"));
		
	}
}
