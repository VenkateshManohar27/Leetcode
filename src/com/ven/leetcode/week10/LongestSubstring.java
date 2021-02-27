package com.ven.leetcode.week10;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

	public String longestNiceSubstring(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		Set<Character> set = new HashSet<>();
		for (char c : s.toCharArray()) {
			set.add(c);
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (set.contains(Character.toLowerCase(c)) && set.contains(Character.toUpperCase(c))) {
				continue;
			}
			String sub1 = longestNiceSubstring(s.substring(0, i));
			String sub2 = longestNiceSubstring(s.substring(i + 1));
			return (sub1.length() >= sub2.length()) ? sub1 : sub2;
		}
		return s;
	}

	public static void main(String[] args) {
		LongestSubstring l = new LongestSubstring();
		System.out.println(l.longestNiceSubstring("YazaAay"));
		System.out.println(l.longestNiceSubstring("dDzeE"));
		System.out.println(l.longestNiceSubstring("c"));
		System.out.println(l.longestNiceSubstring("Bb"));
		System.out.println(l.longestNiceSubstring("HkhBubUYy"));
	}
}
