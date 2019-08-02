package com.ven.leetcode.easy;

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
public class FirstUniqueCharacter {
	public int firstUniqChar(String s) {
		int[] chars = new int[26];
		char[] arr = s.toCharArray();
		int index = -1;
		for (char c : arr) {
			chars[c - 'a']++;
		}
		for (int i = 0; i < arr.length; i++) {
			if (chars[arr[i] - 'a'] == 1) {
				index = i;
				break;
			}
		}
		return index;
	}

}
