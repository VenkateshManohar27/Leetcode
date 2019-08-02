package com.ven.leetcode.easy;

public class Palindrome {
	public boolean isPalindrome(String s) {
		if (s == null)
			return false;
		int start = 0, end = s.length() - 1;

		while (start < end) {
			while (start <= end && !Character.isLetterOrDigit(s.charAt(start)))
				start++;
			while (end > 0 && !Character.isLetterOrDigit(s.charAt(end)))
				end--;
			if (start < end && Character.toLowerCase(s.charAt(start++)) != Character.toLowerCase(s.charAt(end--)))
				return false;
		}

		return true;
	}
}
