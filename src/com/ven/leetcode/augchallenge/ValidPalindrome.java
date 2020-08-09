package com.ven.leetcode.augchallenge;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * Note: For the purpose of this problem, we define empty string as valid
 * palindrome.
 * 
 * Example 1:
 * 
 * Input: "A man, a plan, a canal: Panama" Output: true Example 2:
 * 
 * Input: "race a car" Output: false
 * 
 * 
 * Constraints:
 * 
 * s consists only of printable ASCII characters.
 * 
 * @author Venkatesh Manohar
 *
 */
public class ValidPalindrome {
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
	
	public static void main(String[] args) {
		ValidPalindrome vp = new ValidPalindrome();
		System.out.println(vp.isPalindrome("A man, a plan, a canal -- Panama"));
		System.out.println(vp.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(vp.isPalindrome("race a car"));
		System.out.println(vp.isPalindrome("Marge, let's \"[went].\" I await {news} telegram."));
	}
}
