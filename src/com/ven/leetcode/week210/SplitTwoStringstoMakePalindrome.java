package com.ven.leetcode.week210;

/**
 * You are given two strings a and b of the same length. Choose an index and
 * split both strings at the same index, splitting a into two strings: aprefix
 * and asuffix where a = aprefix + asuffix, and splitting b into two strings:
 * bprefix and bsuffix where b = bprefix + bsuffix. Check if aprefix + bsuffix
 * or bprefix + asuffix forms a palindrome.
 * 
 * When you split a string s into sprefix and ssuffix, either ssuffix or sprefix
 * is allowed to be empty. For example, if s = "abc", then "" + "abc", "a" +
 * "bc", "ab" + "c" , and "abc" + "" are valid splits.
 * 
 * Return true if it is possible to form a palindrome string, otherwise return
 * false.
 * 
 * Notice that x + y denotes the concatenation of strings x and y.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: a = "x", b = "y" Output: true Explaination: If either a or b are
 * palindromes the answer is true since you can split in the following way:
 * aprefix = "", asuffix = "x" bprefix = "", bsuffix = "y" Then, aprefix +
 * bsuffix = "" + "y" = "y", which is a palindrome. Example 2:
 * 
 * Input: a = "abdef", b = "fecab" Output: false Example 3:
 * 
 * Input: a = "ulacfd", b = "jizalu" Output: true Explaination: Split them at
 * index 3: aprefix = "ula", asuffix = "cfd" bprefix = "jiz", bsuffix = "alu"
 * Then, aprefix + bsuffix = "ula" + "alu" = "ulaalu", which is a palindrome.
 * 
 * 
 * Constraints:
 * 
 * 1 <= a.length, b.length <= 105 a.length == b.length a and b consist of
 * lowercase English letters
 * 
 * @author Venkatesh Manohar
 *
 */
public class SplitTwoStringstoMakePalindrome {
	public boolean checkPalindromeFormation(String a, String b) {
		for (int i = 0; i <= a.length(); i++) {
			if (splitAndVerify(a, b, i - 1)) {
				return true;
			}
		}
		return false;
	}

	private boolean splitAndVerify(String a, String b, int i) {
		StringBuilder sbPat1 = new StringBuilder();
		StringBuilder sbPat2 = new StringBuilder();
		String aprefix = "";
		String asuffix = "";
		if (i >= 0) {
			aprefix = a.substring(0, i+1);
			asuffix = a.substring(i + 1);
		} else {
			asuffix = a;
		}
		String bprefix = "";
		String bsuffix = "";
		if (i >= 0) {
			bprefix = b.substring(0, i+1);
			bsuffix = b.substring(i + 1);
		} else {
			bsuffix = b;
		}
		if (isPalindrome(sbPat1.append(aprefix).append(bsuffix).toString())) {
			System.out.println(sbPat1);
			return true;
		}
		if (isPalindrome(sbPat2.append(bprefix).append(asuffix).toString())) {
			System.out.println(sbPat2);
			return true;
		}

		return false;
	}

	private boolean isPalindrome(String s) {
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
		SplitTwoStringstoMakePalindrome s = new SplitTwoStringstoMakePalindrome();
		System.out.println(s.checkPalindromeFormation("x", "y"));
		System.out.println(s.checkPalindromeFormation("abdef", "fecab"));
		System.out.println(s.checkPalindromeFormation("x", "y"));
		System.out.println(s.checkPalindromeFormation("x", "y"));
	}
}
