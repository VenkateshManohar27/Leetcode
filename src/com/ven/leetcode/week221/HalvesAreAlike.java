package com.ven.leetcode.week221;

/**
 * You are given a string s of even length. Split this string into two halves of
 * equal lengths, and let a be the first half and b be the second half.
 * 
 * Two strings are alike if they have the same number of vowels ('a', 'e', 'i',
 * 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and
 * lowercase letters.
 * 
 * Return true if a and b are alike. Otherwise, return false.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "book" Output: true Explanation: a = "bo" and b = "ok". a has 1
 * vowel and b has 1 vowel. Therefore, they are alike. Example 2:
 * 
 * Input: s = "textbook" Output: false Explanation: a = "text" and b = "book". a
 * has 1 vowel whereas b has 2. Therefore, they are not alike. Notice that the
 * vowel o is counted twice. Example 3:
 * 
 * Input: s = "MerryChristmas" Output: false Example 4:
 * 
 * Input: s = "AbCdEfGh" Output: true
 * 
 * 
 * Constraints:
 * 
 * 2 <= s.length <= 1000 s.length is even. s consists of uppercase and lowercase
 * letters.
 * 
 * @author Venkatesh Manohar
 *
 */
public class HalvesAreAlike {
	public boolean halvesAreAlike(String s) {
		String vowels = "aeiouAEIOU";
		int len = s.length();
		int countfirst = 0;
		int countsecond = 0;
		for (int i = 0, j = len / 2; i < len / 2 && j < s.length(); i++, j++) {
			char f = s.charAt(i);
			char h = s.charAt(j);

			if (vowels.indexOf(f) != -1) {
				countfirst++;
			}

			if (vowels.indexOf(h) != -1) {
				countsecond++;
			}

		}

		return countfirst == countsecond;
	}

	public static void main(String[] args) {
		HalvesAreAlike h = new HalvesAreAlike();
		System.out.println(h.halvesAreAlike("book"));
		System.out.println(h.halvesAreAlike("textbook"));
		System.out.println(h.halvesAreAlike("MerryChristmas"));
		System.out.println(h.halvesAreAlike("AbCdEfGh"));
	}
}
