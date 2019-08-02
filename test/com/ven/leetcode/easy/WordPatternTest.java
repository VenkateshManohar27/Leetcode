package com.ven.leetcode.easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in str.
 * 
 * Example 1:
 * 
 * Input: pattern = "abba", str = "dog cat cat dog" Output: true Example 2:
 * 
 * Input:pattern = "abba", str = "dog cat cat fish" Output: false Example 3:
 * 
 * Input: pattern = "aaaa", str = "dog cat cat dog" Output: false Example 4:
 * 
 * Input: pattern = "abba", str = "dog dog dog dog" Output: false
 * 
 * Notes: You may assume pattern contains only lowercase letters, and str
 * contains lowercase letters that may be separated by a single space.
 * 
 * @author Venkatesh Manohar
 *
 */
class WordPatternTest {
	String pattern1 = "abba", pattern2 = "aaaa";
	String str1 = "dog cat cat dog";
	String str2 = "dog cat cat fish";
	String str3 = "dog cat cat dog";
	String str4 = "dog dog dog dog";
	
	WordPattern wp = new WordPattern();

	@Test
	void testPatternString1() {
		assertTrue(wp.wordPattern(pattern1, str1));
	}
	
	@Test
	void testPatternString2() {
		assertFalse(wp.wordPattern(pattern1, str2));
	}
	
	@Test
	void testPatternString3() {
		assertFalse(wp.wordPattern(pattern2, str3));
	}
	
	@Test
	void testPatternString4() {
		assertFalse(wp.wordPattern(pattern1, str4));
	}

}
