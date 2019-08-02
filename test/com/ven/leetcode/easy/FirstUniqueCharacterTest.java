package com.ven.leetcode.easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
/**
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode" return 0.
 * 
 * s = "loveleetcode", return 2.
 * 
 * Note: You may assume the string contain only lowercase letters.
 * 
 * @author Venkatesh Manohar
 *
 */
class FirstUniqueCharacterTest {
	FirstUniqueCharacter firstUniqueCharacter = new FirstUniqueCharacter(); 
	@Test
	void test() {
		assertEquals(0, firstUniqueCharacter.firstUniqChar("leetcode"));
		assertEquals(2, firstUniqueCharacter.firstUniqChar("loveleetcode"));
	}

}
