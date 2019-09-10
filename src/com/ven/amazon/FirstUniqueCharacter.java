package com.ven.amazon;

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
	public static  int firstUniqChar(String s) {

		int count[] = new int[26];
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			if (count[s.charAt(i)-'a'] == 1) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		System.out.println(FirstUniqueCharacter.firstUniqChar("leetcode"));
	}
}
